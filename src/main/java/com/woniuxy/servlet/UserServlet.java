package com.woniuxy.servlet;

import com.woniuxy.entity.NewAccount;
import com.woniuxy.exception.NewAccountExistException;
import com.woniuxy.exception.NewAccountIdNumExistException;
import com.woniuxy.service.NewAccountService;
import com.woniuxy.utils.ProxyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String opr = req.getParameter("opr");
        if (opr.equals("initReg")) {
            deInitReg(req, resp);
        } else if ("reg".equals(opr)) {  //进入登录页面
            doReg(req, resp);
        } else if ("initLogin".equals(opr)) {  //进入登录页面
            doInitLogin(req, resp);
        } else if (opr.equals("login")) {
            doLogin(req, resp);
        }

    }

    private void doInitLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
    }

    private void deInitReg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/reg.jsp").forward(req, resp);

    }

    private void doReg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        NewAccount newAccount = new NewAccount();
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String cfmPassWord = req.getParameter("cfmPassWord");
        LocalDate birthdate = LocalDate.parse(req.getParameter("birthdate"));
        String idNum = req.getParameter("idNum");
        String tellNum = req.getParameter("tellNum");

        newAccount.setAccount(account);
        newAccount.setPassword(password);
        newAccount.setName(name);
        newAccount.setBirthdate(birthdate);
        newAccount.setIdNum(idNum);
        newAccount.setTellNum(tellNum);


        NewAccountService accountService = ProxyUtils.createProxy(NewAccountService.class);
        try {
            accountService.newAccount(newAccount);
            //req.setAttribute("newAccount", newAccount);
            resp.sendRedirect("user?opr=initLogin");
        } catch (NewAccountExistException e) {
            e.printStackTrace();
            req.setAttribute("msg", "账号" + account + "已存在");
            req.setAttribute("newAccount", newAccount);
            req.getRequestDispatcher("WEB-INF/reg.jsp").forward(req, resp);

        } catch (NewAccountIdNumExistException e) {
            e.printStackTrace();
            req.setAttribute("msg", "身份证号" + idNum + "已存在");
            req.getRequestDispatcher("reg.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("msg", "系统维护中");
            req.getRequestDispatcher("WEB-INF/reg.jsp").forward(req, resp);
        }
    }

    private void doLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        NewAccountService accountService = new NewAccountService();
        NewAccount newAccount = accountService.login(account);
        if (newAccount == null) {
            req.setAttribute("msg", "账号不存在");
            req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
        } else {
            if (!newAccount.getPassword().equals(password)) {
                req.setAttribute("msg", "密码错误");
                req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
            } else {
                HttpSession session = req.getSession();
                session.setAttribute("newAccount", newAccount);
                resp.sendRedirect("/");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
