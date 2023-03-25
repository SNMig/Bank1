package com.woniuxy.servlet;

import com.woniuxy.entity.NewAccount;
import com.woniuxy.global.Global;
import com.woniuxy.service.NewAccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String account=req.getParameter("account");
        String password=req.getParameter("password");
        NewAccountService accountService = new NewAccountService();
        NewAccount newAccount = accountService.login(account);
        if (newAccount == null) {
            System.out.println("账号不存在");
        } else {
            while (!newAccount.getPassword().equals(password)) {
                System.out.println("密码错误");

                //password = scanner.next();
            }
            Global.accounts = newAccount;
            System.out.println("登录成功");
        }
    }
}
