package com.woniuxy.service;

import com.woniuxy.dao.CreateCardDAO;
import com.woniuxy.entity.CreateCard;
import com.woniuxy.exception.CreateCardNumExistException;
import com.woniuxy.utils.Dbhelper;

import java.util.List;

public class CreateCardService {
    public void createCard(CreateCard createCard){
        CreateCardDAO createCardDAO =new CreateCardDAO();
        if (createCardDAO.getCountByCardNum(createCard.getCardNum())==1){
            throw new CreateCardNumExistException("卡号已存在");
        }
        createCard.setCardState(1);
        createCardDAO.CreateCard(createCard);

    }

    public CreateCard card(String cardNum){
        CreateCardDAO createCardDAO =new CreateCardDAO();
        return createCardDAO.getCardByCardNum(cardNum);
    }


    public int cardHolder(String cardNum){
        CreateCardDAO createCardDAO =new CreateCardDAO();
        return createCardDAO.getAccountIdByCardNum(cardNum);
    }

    public List<CreateCard> getByAccountId(int id){
        CreateCardDAO createCardDAO =new CreateCardDAO();
        return createCardDAO.getByAccountId(id);
    }

    public CreateCard getById(int id){
        CreateCardDAO createCardDAO =new CreateCardDAO();
        return createCardDAO.getById(id);
    }

    public void update(CreateCard card){
        CreateCardDAO createCardDAO =new CreateCardDAO();
        CreateCard c=createCardDAO.getById(card.getId());
        c.setBalance(c.getBalance());
        c.setCardNum(c.getCardNum());
        c.setPassword(c.getPassword());
        createCardDAO.update(c);

    }
    public void delById(int id){
        CreateCardDAO createCardDAO =new CreateCardDAO();
        createCardDAO.delById(id);
    }

}
