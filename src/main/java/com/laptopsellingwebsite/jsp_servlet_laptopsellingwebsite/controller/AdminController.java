package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.controller;

import com.google.common.collect.Multimap;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service.ProductService;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

//@WebServlet(name = "ProductController", value = "/Admin")
@WebServlet(urlPatterns = {"/Edit", "/Delete", "/Add", "/Admin"})
public class AdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String URL = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/"), request.getRequestURI().length());
        switch (URL) {
            case "/Admin":
                HttpSession session = request.getSession();
                Multimap<String, String> map = (Multimap<String, String>) session.getAttribute("map");
                if (map != null) {
                    map.clear();
                }
                int page = 1;
                if (request.getParameter("pageTTLT") == null && request.getParameter("pageTTLT") == ""){
                    page = 1;
                }
                if (request.getParameter("pageTTLT") != null && request.getParameter("pageTTLT") != ""){
                    page = Integer.parseInt(request.getParameter("pageTTLT"));
                }
                request.setAttribute("pageTTLT", page);
                int limit = 24;
                request.setAttribute("allProduct", ProductService.getInstance().getAllProduct(limit, page));
                int totalPage = ProductService.getInstance().getTotalPage();
                int total = (int) Math.ceil((double) totalPage / (double) limit);
                request.setAttribute("totalPageTTLT", total);
//                request.setAttribute("products", ProductService.getInstance().getAllProduct());
//                request.setAttribute("productsDell", ProductService.getInstance().getProductWithProducer("DELL"));
                request.getRequestDispatcher("jsp/admin.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = request.getParameter("send");
        String currentTable = request.getParameter("currentTable");
        int sizeData = data.split(",").length;
        System.out.println(sizeData);
        String URL = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/"), request.getRequestURI().length());
        switch (URL) {
            case "/Edit":
                System.out.println("Edit");
                break;
            case "/Delete":
                System.out.println("Delete");
                break;
            case "/Add":
                System.out.println("Add");
                break;
        }
    }
}
