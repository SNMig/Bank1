package com.woniuxy.dao;

import com.woniuxy.entity.CreateCard;
import com.woniuxy.utils.Dbhelper;

import java.math.BigDecimal;
import java.util.List;

public class CreateCardDAO {
    public void CreateCard(CreateCard createCard){
        Dbhelper.executeSQL("insert into create_card(card_num,balance,cardholder,card_state,password)values(?,?,?,?,?)", createCard.getCardNum(), createCard.getBalance(), createCard.getCardholder(), createCard.getCardState(), createCard.getPassword());
    }

    /**
     * 判断卡号是否重复
     */
    public int getCountByCardNum(String cardNum){
        String sql="select count(*) from create_card where card_num=?";
        return Dbhelper.getScalar(sql,cardNum);
    }

    //根据卡号查找用户账号
    public int getAccountIdByCardNum(String cardNumber){
        return Dbhelper.executeSingleQuery(CreateCard.class,"select id,card_num cardNum,balance,cardholder,card_state cardState,password from create_card where card_num=?",cardNumber).getCardholder();
    }

    //更新金额
    public void updateMoney(String cardNumber, BigDecimal money){
        Dbhelper.executeSQL("update create_card set balance=balance+? where card_num=?",money,cardNumber);
    }

    //根据卡号查询卡
    public CreateCard getCardByCardNum(String cardNum){
        String sql="select id,card_num cardNum,balance,cardholder,card_state cardState,password from create_card where card_num=?";
        return Dbhelper.executeSingleQuery(CreateCard.class,sql,cardNum);

    }

    public List<CreateCard> getByAccountId(int id){
        String sql="select id,card_num cardNum,balance,cardholder,card_state cardState,password from create_card where cardholder=?";
        return Dbhelper.executeQuery(CreateCard.class,sql,id);

    }

    public CreateCard getById(int id){
        String sql="select id,card_num cardNum,balance,cardholder,card_state cardState,password from create_card where id=?";
        return Dbhelper.executeSingleQuery(CreateCard.class,sql,id);

    }

    public void update(CreateCard card){
        Object[] params={card.getCardNum(),card.getBalance(),card.getPassword(),card.getCardholder(),card.getCardState(),card.getId()};
        Dbhelper.executeSQL("update create_card set card_Num cardNum=?,balance=?,password=?,cardholder=?,card_state cardState where id=?",params);
    }

    public void delById(int id){
        Dbhelper.executeSQL("delete from create_card where id=?",id);
    }

}
