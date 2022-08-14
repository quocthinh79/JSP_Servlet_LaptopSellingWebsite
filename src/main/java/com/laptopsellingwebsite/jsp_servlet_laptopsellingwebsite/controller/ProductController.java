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

@WebServlet(urlPatterns = {"/addProductToCart", "/Product","/addToCartNow"})

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

        HttpSession session = request.getSession();
        Account currentAccount = (Account) session.getAttribute("account");
        int userID = currentAccount.getId();

        String productIDForAdd = request.getParameter("id");
        CartDAO cartDAO = new CartDAO();
        int getProductRemainQuantity = cartDAO.getRemainNumber(productIDForAdd);
        int productQuantityWillAdd = cartDAO.getExportNumber(productIDForAdd) + 1;
        int getProductExportQuantity = cartDAO.getExportNumber(productIDForAdd);
        int getProductImportQuantity = cartDAO.getImportNumber(productIDForAdd);
        request.getRequestDispatcher("jsp/product-page.jsp").forward(request, response);


        switch (URL) {
            case "/Product":
            case "/addProductToCart":
                //kiem tra trang thai dang nhap
                String resultForAdd = "";
                if (currentAccount == null) {
                    resultForAdd = "0";
                    System.out.println("Chua dang nhap");
                    PrintWriter out = response.getWriter();
                    out.println(resultForAdd);
                } else {
                    // xu ly truong hop so luong nhap nhieu hon ton kho
                    if (productQuantityWillAdd <= getProductImportQuantity) {
                        if (cartDAO.getCurrentCartByUserID(userID) == "" || cartDAO.isPuschased(cartDAO.getCurrentCartByUserID(userID)) == true) {
                            System.out.println("chua co gio hang");
                            cartDAO.insertCart(userID);
                            cartDAO.insertProductToCart(productIDForAdd, userID, 1);
                            cartDAO.updateWarehouse(productIDForAdd, getProductExportQuantity + 1, getProductRemainQuantity - 1);
                            resultForAdd = "1";
                            PrintWriter out = response.getWriter();
                            out.println(resultForAdd);
                        } else if (cartDAO.isProductOnCart(productIDForAdd, userID) == false) {
                            System.out.println("da co gio hang, chua ton tai sp se them");
                            cartDAO.insertProductToCart(productIDForAdd, userID, 1);
                            cartDAO.updateWarehouse(productIDForAdd, getProductExportQuantity + 1, getProductRemainQuantity - 1);
                            resultForAdd = "1";
                            PrintWriter out = response.getWriter();
                            out.println(resultForAdd);
                        } else {
                            System.out.println("da co gio hang, ton tai sp se them");
                            resultForAdd = "1";
                            PrintWriter out = response.getWriter();
                            out.println(resultForAdd);
                            cartDAO.updateProductQuantityByProductID(
                                    productIDForAdd,
                                    userID,
                                    cartDAO.getProductQuantity(productIDForAdd, userID) + 1);
                            cartDAO.updateWarehouse(productIDForAdd, getProductExportQuantity + 1, getProductRemainQuantity - 1);
                        }
                    } else {
                        System.out.println("Khong the them");
                        resultForAdd = "2";
                        PrintWriter out = response.getWriter();
                        out.println(resultForAdd);
                    }
                }
                break;

            case "/addToCartNow":
                String resultForAddNow;
                //kiem tra trang thai dang nhap
                //neu chua dang nhap, gui loi ve client
                if (currentAccount == null) {
                    resultForAddNow = "0";
                    System.out.println("Chua dang nhap");
                    PrintWriter out = response.getWriter();
                    out.println(resultForAddNow);
                }
                //Login success
                else {
                    // xu ly truong hop so luong nhap nhieu hon ton kho
                    if (productQuantityWillAdd <= getProductImportQuantity) {
                        //truong hop gio hang chua ton tai
                        if (cartDAO.getCurrentCartByUserID(userID) == "" || cartDAO.isPuschased(cartDAO.getCurrentCartByUserID(userID)) == true) {
                            cartDAO.insertCart(userID);
                            cartDAO.insertProductToCart(productIDForAdd, userID, 1);
                            cartDAO.updateWarehouse(productIDForAdd, getProductExportQuantity + 1, getProductRemainQuantity - 1);
                            resultForAddNow = "1";
                            System.out.println("Them vao gio hang chua ton tai");
                            PrintWriter out = response.getWriter();
                            out.println(resultForAddNow);
                        }
                        //truong hop gio hang chua co san pham chuan bi them vao
                        else if (cartDAO.isProductOnCart(productIDForAdd, userID) == false) {
                            cartDAO.insertProductToCart(productIDForAdd, userID, 1);
                            cartDAO.updateWarehouse(productIDForAdd, getProductExportQuantity + 1, getProductRemainQuantity - 1);
                            resultForAddNow = "1";
                            PrintWriter out = response.getWriter();
                            out.println(resultForAddNow);
                            System.out.println("Them vao gio hang da ton tai, chua co san pham sap them vao gio" );

                        } else {
                            // truong hop gio hang da ton tai san pham san pham
                            resultForAddNow = "1";
                            PrintWriter out = response.getWriter();
                            out.println(resultForAddNow);
                            System.out.println("Them vao gio hang da ton tai, c san pham sap them  da co trong gio");
//                          request.getRequestDispatcher("jsp/cart.jsp").forward(request,response);
                            cartDAO.updateProductQuantityByProductID(
                                    productIDForAdd,
                                    userID,
                                    cartDAO.getProductQuantity(productIDForAdd, userID) + 1);
                            cartDAO.updateWarehouse(productIDForAdd, getProductExportQuantity + 1, getProductRemainQuantity - 1);
                        }
                    } // truong hop so luong san pham khong con trong kho
                    else {
                        resultForAddNow = "2";
                        PrintWriter out = response.getWriter();
                        out.println(resultForAddNow);
                    }
                }
                break;

        }
    }
}