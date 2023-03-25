package com.woniuxy.dao;

import com.woniuxy.entity.NewAccount;
import com.woniuxy.utils.Dbhelper;

import java.math.BigDecimal;

public class NewAccountDAO {
    public void newAccount(NewAccount newAccount){

        Dbhelper.executeSQL("insert into new_account(account,password,name,date,id_num,tell_num,state,total_money)values(?,?,?,?,?,?,?,?)", newAccount.getAccount(), newAccount.getPassword(), newAccount.getName(), newAccount.getBirthdate(), newAccount.getIdNum(), newAccount.getTellNum(), newAccount.getState(), newAccount.getTotalMoney());

    }

    //根据账号查找用户是否存在
    public int getCountByAccount(String account){
        String sql="select count(*) from new_account where account=?";
        return Dbhelper.getScalar(sql,account);
    }

    //根据身份证查找用户是否存在
    public  int getCountByIdNum(String idNum){
        String sql="select count(*) from new_account where id_num=?";
        return Dbhelper.getScalar(sql,idNum);
    }

    //根据账号查找用户
    public NewAccount getByAccount(String account){
        return Dbhelper.executeSingleQuery(NewAccount.class,"select id,account,password,name,date birthdate,id_num idNum,tell_num tellNum,state,total_money totalMoney from new_account where account=?",account);
    }

    //更新
    public void updateTotalMoney(int id, BigDecimal money){
        Dbhelper.executeSQL("update new_account set total_money=total_money+? where id=?",money,id);
    }
//根据id查
    public NewAccount getById(int id){
        return Dbhelper.executeSingleQuery(NewAccount.class,"select id,account,password,name,date birthdate,id_num idNum,tell_num tellNum,state,total_money totalMoney from new_account where id=?",id);
    }
}
