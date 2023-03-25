package com.woniuxy.dao;

import com.woniuxy.entity.Transfer;
import com.woniuxy.utils.Dbhelper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TransferDAO {
    public void add(Transfer transfer){
        Dbhelper.executeSQL("insert into transfer(transfer_out_number,amount,transfer_in_number,transfer_time)values(?,?,?,?)",transfer.getTransferOutNum(),transfer.getAmount(),transfer.getTransferInNum(),transfer.getTransferTime());
    }


    public List<Transfer> getAll(String account){
        List<Transfer> list=new ArrayList<>();
        String sql="select id,transfer_out_number transferOutNum,amount,transfer_in_number transferInNum,transfer_time transferTime from transfer where transfer_out_number=?";
        return list=Dbhelper.executeQuery(Transfer.class,sql,account);

    }

    public Transfer getInNumByOutNum(String outNum){
        return Dbhelper.executeSingleQuery(Transfer.class,"select id,transfer_out_number transferOutNum,amount,transfer_in_number transferInNum,transfer_time transferTime from transfer where transfer_out_number=?",outNum);
    }
}
