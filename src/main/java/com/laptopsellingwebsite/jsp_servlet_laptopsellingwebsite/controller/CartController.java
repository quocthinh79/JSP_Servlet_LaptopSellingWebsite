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
import java.io.PrintWriter;
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
                int totalCost = cartDAO.totalCost(id);
//                System.out.println(totalCost);
                request.setAttribute("listProduct", listProductOnCart);
                request.setAttribute("totalCost", totalCost);
                request.getRequestDispatcher("jsp/cart.jsp").forward(request, response);
                break;

            case "/addQuantity":
                String productIDForAdd = request.getParameter("id");
                int getProductRemainQuantity = cartDAO.getRemainNumber(productIDForAdd);
                int productQuantityWillAdd = cartDAO.getProductQuantity(productIDForAdd, id) + 1;
                String result ;
                // xu ly truong hop so luong nhap nhieu hon ton kho
                if (productQuantityWillAdd <= getProductRemainQuantity) {
                    result = "1";
//                    request.setAttribute("result",result);
                    PrintWriter out = response.getWriter();
                    out.println(result);
                    System.out.println("1");
                    cartDAO.updateProductQuantityByProductID(
                            productIDForAdd,
                            id,
                            cartDAO.getProductQuantity(productIDForAdd, id) + 1);
                } else {
                    result = "0";
//                    request.setAttribute("result",result);
                    PrintWriter out = response.getWriter();
                    out.println(result);
                    System.out.println("0");
                }
                break;


            case "/subtractQuantity":
                String productIDForSubtract = request.getParameter("id");
                cartDAO.updateProductQuantityByProductID(
                        productIDForSubtract,
                        id,
                        cartDAO.getProductQuantity(productIDForSubtract, id) - 1);
                break;

                case "/clearAProduct":
                String productIDForDelete = request.getParameter("idForDelete");
                cartDAO.removeProductFromCart(productIDForDelete, id);
                System.out.println(cartDAO.removeProductFromCart(productIDForDelete, id));
                    break;

//            case "/clearAllProduct":
//                int clear = (int) Integer.parseInt(request.getParameter("clear"));
//                System.out.println(clear);
//                if (clear == 1)
//                    cartDAO.clearCart(id);
            case "/buy":
                int getClick = (int) Integer.parseInt(request.getParameter("click"));
                System.out.println(getClick);
//                ArrayList<String> listProduct = cartDAO.getProductIDFromCartByUserID(id);
//
////                for(String productID:listProduct) {
////                    int productQuantityOnCartForBuyMethod = cartDAO.getProductQuantity(productID,id);
////
////                    cartDAO.updateWarehouse(productID,) ;
////
////                }
//
//                if(listProduct.size() > 0) {
//                    int totalCostForBuy = cartDAO.totalCost(id);
//                    cartDAO.updateCart(id, totalCostForBuy);
//                } else {
//                    request.setAttribute("Error","Gio hang rong");
//                }




        }
    }
}
