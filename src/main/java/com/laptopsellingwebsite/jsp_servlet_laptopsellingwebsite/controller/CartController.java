package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.controller;

import com.google.common.collect.Multimap;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Account;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.CartInfo;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Product;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.dao.CartDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/Cart","/clearAllProduct","/addQuantity","/subtractQuantity","/clearAProduct","/getPrice","/getTotalPrice","/buy"})
public class CartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String URL = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/"), request.getRequestURI().length());
        HttpSession session = request.getSession();
        Account currentAccount = (Account) session.getAttribute("account");
        int id = currentAccount.getId();
        CartDAO cartDAO = new CartDAO();

        switch(URL) {
            case "/Cart":
                ArrayList<CartInfo> listProductOnCart = cartDAO.getProductList(cartDAO.getProductIDFromCartByUserID(id));
                request.setAttribute("listProduct",listProductOnCart);
                request.getRequestDispatcher("jsp/cart.jsp").forward(request, response);
            case "/clearAllProduct":
//              cartDAO.clearCart(id);
        }

    }


}
