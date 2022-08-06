package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.controller;

import com.google.common.collect.Multimap;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Account;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Product;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.dao.CartDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CartController", value = "/Cart")
public class CartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account currentAccount = (Account) session.getAttribute("account");
        Integer id = currentAccount.getId();

        CartDAO cartDAO = new CartDAO();
        ArrayList<Product> listProduct = cartDAO.getProductList(cartDAO.getProductIDFromCartByUserID(id));

        Multimap<String, String> map = (Multimap<String, String>) session.getAttribute("map");
        if (map != null){
            map.clear();
        }

        request.setAttribute("listProduct",listProduct);
        request.getRequestDispatcher("jsp/cart.jsp").forward(request, response);
    }


}
