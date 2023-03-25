package com.woniuxy.servlet;

import com.woniuxy.entity.CreateCard;
import com.woniuxy.entity.NewAccount;
import com.woniuxy.service.CreateCardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
@WebServlet("/card")
public class CardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opr = req.getParameter("opr");
        if ("doList".equals(opr)){
            doList(req, resp);
        }else if ("initUpdate".equals(opr)){
            doInitUpdate(req,resp);
        }else if ("doUpdate".equals(opr)) {
            doUpdate(req, resp);
        }else if (opr.equals("del")) {
            doDel(req, resp);
        }
    }

    private void doList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateCardService cardService=new CreateCardService();
        NewAccount newAccount=(NewAccount)req.getSession().getAttribute("newAccount");
        List<CreateCard>cards=cardService.getByAccountId(newAccount.getId());
        req.setAttribute("cards",cards);
        req.getRequestDispatcher("WEB-INF/card_list.jsp").forward(req,resp);
    }
    private void doInitUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        CreateCardService cardService=new CreateCardService();
        CreateCard card=cardService.getById(Integer.parseInt(id));
        req.setAttribute("card",card);
        req.getRequestDispatcher("WEB-INF/card_update.jsp").forward(req,resp);
    }
    private void doUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        String cardNum=req.getParameter("CardNum");
        String balance=req.getParameter("balance");
        String password=req.getParameter("password");

        CreateCard card=new CreateCard();
        card.setId(id);
        card.setCardNum(cardNum);
        card.setBalance(new BigDecimal(balance));
        card.setPassword(password);
        CreateCardService cardService=new CreateCardService();
        cardService.update(card);
        resp.sendRedirect("card?opr=doList");

    }

    private void doDel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        CreateCardService cardService=new CreateCardService();
        cardService.delById(Integer.parseInt(id));
        resp.sendRedirect("card?opr=doList");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
