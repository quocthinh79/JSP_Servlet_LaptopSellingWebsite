package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.controller;

import com.google.common.collect.Multimap;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Account;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.dao.CartDAO;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service.CartServices;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/addProductToCart", "/Product"})

public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String URL = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/"), request.getRequestURI().length());
        switch (URL) {
            case "/Product":
                String id = request.getParameter("id");
                String url = request.getServletPath();
                HttpSession session = request.getSession();

                request.setAttribute("url", url);
                Multimap<String, String> map = (Multimap<String, String>) session.getAttribute("map");
                if (map != null) {
                    map.clear();
                }
                request.setAttribute("productID", ProductService.getInstance().getProductWithID(id));
                request.setAttribute("productsProductBS", ProductService.getInstance().getTopProductBestSeller(10));
                request.getRequestDispatcher("jsp/product-page.jsp").forward(request, response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String URL = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/"), request.getRequestURI().length());
        switch (URL) {
            case "/Product":

                request.getRequestDispatcher("jsp/product-page.jsp").forward(request, response);

            case "/addProductToCart":
                HttpSession session = request.getSession();
                Account currentAccount = (Account) session.getAttribute("account");
                String productIDForAdd = request.getParameter("id");
                int userID = currentAccount.getId();
                CartDAO cartDAO = new CartDAO();

                int getProductRemainQuantity = cartDAO.getRemainNumber(productIDForAdd);
                int productQuantityWillAdd = cartDAO.getExportNumber(productIDForAdd) + 1;
                int getProductExportQuantity = cartDAO.getExportNumber(productIDForAdd);
                int getProductImportQuantity = cartDAO.getImportNumber(productIDForAdd);


                String result;
                // xu ly truong hop so luong nhap nhieu hon ton kho

                if ((productQuantityWillAdd) <= getProductImportQuantity) {
                    if (cartDAO.getCurrentCartByUserID(userID) == "" || cartDAO.isPuschased(cartDAO.getCurrentCartByUserID(userID)) == true) {
                        cartDAO.insertCart(userID);
                        cartDAO.insertProductToCart(productIDForAdd, userID, 1);
                        cartDAO.updateWarehouse(productIDForAdd, getProductExportQuantity + 1, getProductRemainQuantity - 1);
                        result = "1";
                        PrintWriter out = response.getWriter();
                        out.println(result);
                    } else if (cartDAO.isProductOnCart(productIDForAdd, userID) == false) {
                        cartDAO.insertProductToCart(productIDForAdd, userID, 1);
                        cartDAO.updateWarehouse(productIDForAdd, getProductExportQuantity + 1, getProductRemainQuantity - 1);
                        result = "1";
//                       request.setAttribute("result",result);
                        PrintWriter out = response.getWriter();
                        out.println(result);
                    } else {
                        result = "1";
//                       request.setAttribute("result",result);
                        PrintWriter out = response.getWriter();
                        out.println(result);
                        cartDAO.updateProductQuantityByProductID(
                                productIDForAdd,
                                userID,
                                cartDAO.getProductQuantity(productIDForAdd, userID) + 1);
                        cartDAO.updateWarehouse(productIDForAdd, getProductExportQuantity + 1, getProductRemainQuantity - 1);
                    }
                } else {
                    result = "0";
                    PrintWriter out = response.getWriter();
                    out.println(result);
                }
                break;

        }

    }

}

