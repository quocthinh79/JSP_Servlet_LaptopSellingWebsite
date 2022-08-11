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
                request.setAttribute("listProduct", listProductOnCart);
                request.getRequestDispatcher("jsp/cart.jsp").forward(request, response);


            case "/addQuantity":
                String productIDForAdd = request.getParameter("id");
                cartDAO.updateProductQuantityByProductID(
                        productIDForAdd,
                        id,
                        cartDAO.getProductQuantity(productIDForAdd, id) + 1);

                System.out.println(cartDAO.updateProductQuantityByProductID(
                        productIDForAdd,
                        id,
                        cartDAO.getProductQuantity(productIDForAdd, id) + 1));
            case "/subtractQuantity":
                String productIDForSubtract = request.getParameter("id");
                cartDAO.updateProductQuantityByProductID(
                        productIDForSubtract,
                        id,
                        cartDAO.getProductQuantity(productIDForSubtract, id) - 1);
                System.out.println(cartDAO.updateProductQuantityByProductID(
                        productIDForSubtract,
                        id,
                        cartDAO.getProductQuantity(productIDForSubtract, id) - 1));
            case "/clearAProduct":
                String productIDForDelete = request.getParameter("idForDelete");
                cartDAO.removeProductFromCart(productIDForDelete, id);
                System.out.println(cartDAO.removeProductFromCart(productIDForDelete, id));


//            case "/clearAllProduct":
//                int clear = (int) Integer.parseInt(request.getParameter("clear"));
//                System.out.println(clear);
//                if (clear == 1)
//                    cartDAO.clearCart(id);
            case "/buy":
                int getClick = (int) Integer.parseInt(request.getParameter("click"));
                System.out.println(getClick);
                ArrayList<String> listProduct = cartDAO.getProductIDFromCartByUserID(id);
                for(String productID:listProduct) {

                    cartDAO.updateWarehouse(
                            productID, cartDAO.getExportNumber(productID),
                            cartDAO.getRemainNumber(productID) - cartDAO.getExportNumber(productID));

                }

                //                if(listProduct.size() > 0) {
                    int totalCost = cartDAO.totalCost(id);
                    cartDAO.updateCart(id, totalCost);

//                } else {
//                    request.setAttribute("Error","Gio hang rong");
//                }

//
//
//
        }
    }
}
