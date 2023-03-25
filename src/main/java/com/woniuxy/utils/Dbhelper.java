package com.woniuxy.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;


import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Dbhelper {
    private static Properties properties = null;

    static {
        properties = new Properties();
        InputStream is = Dbhelper.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ThreadLocal<Connection> conns = new ThreadLocal<>();

    public static Connection getConnection() {
        Connection connection = conns.get();
        if (connection == null) {
            DataSource dataSource = null;
            try {
                dataSource = DruidDataSourceFactory.createDataSource(properties);
                connection = dataSource.getConnection();
                conns.set(connection);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }


    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void executeSQL(String sql, Object... params) {
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T executeSingleQuery(Class<T> c, String sql, Object... params) {
        T t = null;
        Connection connection = getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            ResultSet rs = pstmt.executeQuery();
            Field[] fields = c.getDeclaredFields();
            ResultSetMetaData metaData = rs.getMetaData();
            while (rs.next()) {
                t = c.newInstance();
                for (Field field : fields) {
                    if (!isExist(metaData, field.getName())) {
                        continue;
                    }
                    field.setAccessible(true);
                    if (field.getType() == int.class || field.getType() == Integer.class) {
                        field.set(t, rs.getInt(field.getName()));
                    } else if (field.getType() == String.class) {
                        field.set(t, rs.getString(field.getName()));
                    } else if (field.getType() == char.class) {
                        field.set(t, rs.getString(field.getName()).charAt(0));
                    } else if (field.getType() == BigDecimal.class) {
                        field.set(t, rs.getBigDecimal(field.getName()));
                    } else if (field.getType() == LocalDateTime.class) {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        LocalDateTime d = LocalDateTime.parse(rs.getString(field.getName()), formatter);
                        field.set(t, d);
                    }
                }

            }
            return t;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }


    public static <T> List<T> executeQuery(Class<T> c, String sql, Object... params) {
        List<T> data = new ArrayList<>();
        PreparedStatement pstmt = null;
        try {
            pstmt = getConnection().prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }

            ResultSet rs = pstmt.executeQuery();
            Field[] fields = c.getDeclaredFields();
            ResultSetMetaData metaData = rs.getMetaData();
            while (rs.next()) {
                T t = c.newInstance();
                for (Field field : fields) {
                    if (!isExist(metaData, field.getName())) {
                        continue;
                    }
                    field.setAccessible(true);
                    if (field.getType() == int.class || field.getType() == Integer.class) {
                        field.set(t, rs.getInt(field.getName()));
                    } else if (field.getType() == String.class) {
                        field.set(t, rs.getString(field.getName()));
                    } else if (field.getType() == char.class) {
                        field.set(t, rs.getString(field.getName()).charAt(0));
                    } else if (field.getType() == BigDecimal.class) {
                        field.set(t, rs.getBigDecimal(field.getName()));
                    } else if (field.getType() == LocalDateTime.class) {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        LocalDateTime d = LocalDateTime.parse(rs.getString(field.getName()), formatter);
                        field.set(t, d);
                    }
                }
                data.add(t);
            }
            return data;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }


    public static boolean isExist(ResultSetMetaData metaData, String labelName) throws SQLException {
        for (int i = 0; i < metaData.getColumnCount(); i++) {
            if (labelName.equals(metaData.getColumnLabel(i + 1))) {
                return true;
            }
        }
        return false;
    }

    public static int getScalar(String sql, Object... params) {
        //Connection connection = getConnection();
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
