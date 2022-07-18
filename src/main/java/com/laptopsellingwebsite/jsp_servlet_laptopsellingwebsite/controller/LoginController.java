package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.controller;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Account;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service.UserServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/Login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String pass = request.getParameter("password");
        String base = request.getServletContext().getContextPath();
        if (UserServices.checkUser(userName)) {
            Account account = UserServices.getUser(userName, pass);
            if (account != null) {
                HttpSession session = request.getSession();

                session.setAttribute("account", account);
                response.sendRedirect(base);
            } else {
                request.setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
                request.setAttribute("username", userName);
                request.setAttribute("password", pass);
                request.getRequestDispatcher("").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Tài khoản không tồn tại");
            request.setAttribute("username", userName);
            request.setAttribute("password", pass);
            request.getRequestDispatcher("").forward(request, response);
        }
    }
}
