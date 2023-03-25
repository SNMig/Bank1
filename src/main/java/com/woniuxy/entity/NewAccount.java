package com.woniuxy.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NewAccount {
    private int id;
    private String account;
    private String password;
    private String name;
    private LocalDate birthdate;
    private String idNum;
    private String tellNum;
    private int state;
    private BigDecimal totalMoney;


    public NewAccount() {
    }

    public NewAccount(int id, String account, String password, String name, LocalDate birthdate, String idNum, String tellNum, int state, BigDecimal totalMoney) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.birthdate = birthdate;
        this.idNum = idNum;
        this.tellNum = tellNum;
        this.state = state;
        this.totalMoney = totalMoney;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return account
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置
     * @param account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return birthdate
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * 设置
     * @param birthdate
     */
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * 获取
     * @return idNum
     */
    public String getIdNum() {
        return idNum;
    }

    /**
     * 设置
     * @param idNum
     */
    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    /**
     * 获取
     * @return tellNum
     */
    public String getTellNum() {
        return tellNum;
    }

    /**
     * 设置
     * @param tellNum
     */
    public void setTellNum(String tellNum) {
        this.tellNum = tellNum;
    }

    /**
     * 获取
     * @return state
     */
    public int getState() {
        return state;
    }

    /**
     * 设置
     * @param state
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     * 获取
     * @return totalMoney
     */
    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    /**
     * 设置
     * @param totalMoney
     */
    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String toString() {
        return "NewAccount{id = " + id + ", account = " + account + ", password = " + password + ", name = " + name + ", birthdate = " + birthdate + ", idNum = " + idNum + ", tellNum = " + tellNum + ", state = " + state + ", totalMoney = " + totalMoney + "}";
    }
}
