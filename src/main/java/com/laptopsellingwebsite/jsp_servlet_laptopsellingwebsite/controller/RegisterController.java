package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.controller;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service.UserServices;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterController", value = "/Register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hoTen = request.getParameter("hoTen");
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        String diaChi = request.getParameter("diaChi");
        String email = request.getParameter("email");
        String base = request.getServletContext().getContextPath();
        if (!UserServices.checkUser(username) && !UserServices.getInstance().checkEmail(email)) {
            UserServices.getInstance().registerCustomer(hoTen, username, pass, diaChi, email);
            response.sendRedirect(base);
        } else {
            request.setAttribute("existsUsername", "Username hoặc email bạn đăng kí đã tồn tại");
            request.setAttribute("hoTen", hoTen);
            request.setAttribute("username", username);
            request.setAttribute("pass", pass);
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("email", email);
            request.getRequestDispatcher("").forward(request, response);
        }

    }
}
