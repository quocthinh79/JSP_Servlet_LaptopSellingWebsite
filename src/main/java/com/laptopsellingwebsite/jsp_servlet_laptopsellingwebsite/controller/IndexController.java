package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.controller;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "IndexController", value = "/Index")
public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("productsTop4", ProductService.getInstance().getAllProducer());
        request.setAttribute("productsTop", ProductService.getInstance().getTopProduct1(4));
        request.setAttribute("productsProductBS", ProductService.getInstance().getTopProductBestSeller(10));
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
