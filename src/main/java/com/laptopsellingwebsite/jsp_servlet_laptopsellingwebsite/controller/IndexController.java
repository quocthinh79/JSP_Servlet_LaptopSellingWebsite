package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.controller;

import com.google.common.collect.Multimap;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "IndexController", value = "/Index")
public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Multimap<String, String> map = (Multimap<String, String>) session.getAttribute("map");
        if (map != null){
            map.clear();
        }
        request.setAttribute("productsTop4", ProductService.getInstance().getAllProducer());
        request.setAttribute("productsTop", ProductService.getInstance().getTopProduct1(4));
        request.setAttribute("productsProductBS", ProductService.getInstance().getTopProductBestSeller(10));
        request.setAttribute("topProducer", ProductService.getInstance().getTopProducer(4));
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
