package com.woniuxy.service;

import com.woniuxy.dao.NewAccountDAO;
import com.woniuxy.entity.NewAccount;
import com.woniuxy.exception.NewAccountExistException;
import com.woniuxy.exception.NewAccountIdNumExistException;

import java.math.BigDecimal;

public class NewAccountService {
    NewAccountDAO accountDAO=new NewAccountDAO();
    public void newAccount(NewAccount account){

        //判断账号是否重复
        if (accountDAO.getCountByAccount(account.getAccount())==1) {
            throw new NewAccountExistException("账号已存在");
        }
        //判断身份证是否重复
        if (accountDAO.getCountByIdNum(account.getIdNum())==1) {
            throw new NewAccountIdNumExistException("身份证号重复");
        }
        //创建新账户
        account.setTotalMoney(new BigDecimal(0));
        account.setState(1);
        accountDAO.newAccount(account);
    }


    //根据账号查找用户
    public NewAccount login(String account){
        return accountDAO.getByAccount(account);
    }

    //根据id查询
    public NewAccount getById(int id){
        return accountDAO.getById(id);
    }
}
