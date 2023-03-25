package com.woniuxy.entity;

import java.math.BigDecimal;

public class CreateCard {
    private  int id;
    private String cardNum;
    private BigDecimal balance;
    private int cardholder;
    private int cardState;
    private String password;

    public CreateCard() {
    }

    public CreateCard(int id, String cardNum, BigDecimal balance, int cardholder, int cardState, String password) {
        this.id = id;
        this.cardNum = cardNum;
        this.balance = balance;
        this.cardholder = cardholder;
        this.cardState = cardState;
        this.password = password;
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
     * @return cardNum
     */
    public String getCardNum() {
        return cardNum;
    }

    /**
     * 设置
     * @param cardNum
     */
    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    /**
     * 获取
     * @return balance
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 设置
     * @param balance
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 获取
     * @return cardholder
     */
    public int getCardholder() {
        return cardholder;
    }

    /**
     * 设置
     * @param cardholder
     */
    public void setCardholder(int cardholder) {
        this.cardholder = cardholder;
    }

    /**
     * 获取
     * @return cardState
     */
    public int getCardState() {
        return cardState;
    }

    /**
     * 设置
     * @param cardState
     */
    public void setCardState(int cardState) {
        this.cardState = cardState;
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

    public String toString() {
        return "CreateCard{id = " + id + ", cardNum = " + cardNum + ", balance = " + balance + ", cardholder = " + cardholder + ", cardState = " + cardState + ", password = " + password + "}";
    }
}
