package com.woniuxy.service;

import com.woniuxy.dao.CreateCardDAO;
import com.woniuxy.dao.NewAccountDAO;
import com.woniuxy.dao.TransferDAO;
import com.woniuxy.entity.NewAccount;
import com.woniuxy.entity.Transfer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class TransferService {
    public void transfer(String outNum, String inNum, BigDecimal money){
        CreateCardDAO createCardDAO=new CreateCardDAO();
        NewAccountDAO newAccountDAO=new NewAccountDAO();

        //更新卡余额
        createCardDAO.updateMoney(outNum,new BigDecimal(0).subtract(money));
        createCardDAO.updateMoney(inNum,money);

        //查找用户Id并更改总金额
        int outNumId=createCardDAO.getAccountIdByCardNum(outNum);
        int inNumId=createCardDAO.getAccountIdByCardNum(inNum);

        if (outNum!=inNum) {
            newAccountDAO.updateTotalMoney(outNumId,new BigDecimal(0).subtract(money));
            newAccountDAO.updateTotalMoney(inNumId,money);
        }

        //增加一个交易信息
        Transfer transfer=new Transfer();
        transfer.setTransferInNum(inNum);
        transfer.setTransferOutNum(outNum);
        transfer.setAmount(money);
        transfer.setTransferTime(LocalDateTime.now());
        TransferDAO transferDAO=new TransferDAO();
        transferDAO.add(transfer);
    }

    public List<Transfer> getInformation(String cardNum){
        TransferDAO transferDAO=new TransferDAO();
        return transferDAO.getAll(cardNum);
    }

    public Transfer getOutNum(String num){
        TransferDAO transferDAO=new TransferDAO();
        return transferDAO.getInNumByOutNum(num);
    }
}
