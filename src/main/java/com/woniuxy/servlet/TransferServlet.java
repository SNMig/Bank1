package com.woniuxy.servlet;

import com.woniuxy.entity.CreateCard;
import com.woniuxy.entity.NewAccount;
import com.woniuxy.entity.Transfer;
import com.woniuxy.service.CreateCardService;
import com.woniuxy.service.NewAccountService;
import com.woniuxy.service.TransferService;
import com.woniuxy.utils.ProxyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.smartcardio.Card;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;
@WebServlet("/transfer")
public class TransferServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String opr = req.getParameter("opr");
        if ("initAdd".equals(opr)) {
            initAdd(req, resp);
        }  if ("add".equals(opr)) {
            add(req, resp);
        } else if ("cardsearch".equals(opr)) {
            searchByCardNum(req, resp);
        }else if ("search".equals(opr)) {
            doSearch(req, resp);
        }

        PrintWriter writer = resp.getWriter();
        writer.write("<html>");
    }

    private void doSearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cardNum=req.getParameter("cardNum");
        HttpSession session= req.getSession();
        TransferService transferService=new TransferService();
        List<Transfer> transfers=transferService.getInformation(cardNum);
        //获得收款人的卡号
        String inCard = transferService.getOutNum(cardNum).getTransferInNum();
        //根据卡号查持卡人
        CreateCardService cardService = new CreateCardService();
        int idHolder = cardService.cardHolder(inCard);
        //获得名字
        NewAccountService accountService = ProxyUtils.createProxy(NewAccountService.class);
        NewAccount account = new NewAccount();
        account = accountService.getById(idHolder);
        String name = account.getName();
        for (int i = 0; i < transfers.size(); i++) {
            transfers.get(i).setName(name);
        }

        req.setAttribute("transfers",transfers);
        req.getRequestDispatcher("WEB-INF/transfer_list.jsp").forward(req,resp);
    }

    private void initAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        NewAccount newAccount=(NewAccount)req.getSession().getAttribute("newAccount");
        if (newAccount==null){
            resp.sendRedirect("user?opr=initLogin");
            return;
        }
        CreateCardService cardService=new CreateCardService();
        List<CreateCard> cards=cardService.getByAccountId(newAccount.getId());
        req.setAttribute("cards",cards);
        req.getRequestDispatcher("WEB-INF/transfer_add.jsp").forward(req,resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String outNUm=req.getParameter("transferOutNum");
        String inNum=req.getParameter("transferInNum");
        BigDecimal money=new BigDecimal(req.getParameter("money"));
        TransferService transferService=new TransferService();
        transferService.transfer(outNUm,inNum,money);
        req.getRequestDispatcher("WEB-INF/index.jsp").forward(req,resp);
    }

    private void searchByCardNum(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewAccount newAccount=(NewAccount)req.getSession().getAttribute("newAccount");
        if (newAccount==null){
            resp.sendRedirect("user?opr=initLogin");
            return;
        }
        CreateCardService cardService=new CreateCardService();
        List<CreateCard> cards=cardService.getByAccountId(newAccount.getId());
        req.setAttribute("cards",cards);


        req.getRequestDispatcher("WEB-INF/transfer_list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
