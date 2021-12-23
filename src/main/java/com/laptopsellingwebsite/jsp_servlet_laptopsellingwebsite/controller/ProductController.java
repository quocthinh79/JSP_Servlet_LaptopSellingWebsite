package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.controller;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SingleProductController", value = "/Product")
public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("productID", ProductService.getInstance().getProductWithID("A315-58G-50S4"));
        request.setAttribute("productsProductBS", ProductService.getInstance().getTopProductBestSeller(10));
        request.getRequestDispatcher("jsp/product-page.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
