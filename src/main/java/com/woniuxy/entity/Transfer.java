package com.woniuxy.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transfer {
    private int id;
    private String transferOutNum;
    private BigDecimal amount;
    private String transferInNum;
    private LocalDateTime transferTime;
    private String name;


    public Transfer() {
    }

    public Transfer(int id, String transferOutNum, BigDecimal amount, String transferInNum, LocalDateTime transferTime, String name) {
        this.id = id;
        this.transferOutNum = transferOutNum;
        this.amount = amount;
        this.transferInNum = transferInNum;
        this.transferTime = transferTime;
        this.name = name;
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
     * @return transferOutNum
     */
    public String getTransferOutNum() {
        return transferOutNum;
    }

    /**
     * 设置
     * @param transferOutNum
     */
    public void setTransferOutNum(String transferOutNum) {
        this.transferOutNum = transferOutNum;
    }

    /**
     * 获取
     * @return amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置
     * @param amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 获取
     * @return transferInNum
     */
    public String getTransferInNum() {
        return transferInNum;
    }

    /**
     * 设置
     * @param transferInNum
     */
    public void setTransferInNum(String transferInNum) {
        this.transferInNum = transferInNum;
    }

    /**
     * 获取
     * @return transferTime
     */
    public LocalDateTime getTransferTime() {
        return transferTime;
    }

    /**
     * 设置
     * @param transferTime
     */
    public void setTransferTime(LocalDateTime transferTime) {
        this.transferTime = transferTime;
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

    public String toString() {
        return "Transfer{" + " 转出账号 = " + transferOutNum + ", 转账金额 = " + amount +", 收款人名字 = " + name + ", 收款人 = " + transferInNum + ", 转账时间 = " + transferTime + "}";
    }
}
