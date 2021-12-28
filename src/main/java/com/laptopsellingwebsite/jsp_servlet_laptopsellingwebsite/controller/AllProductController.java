package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.controller;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AllProductController", value = "/AllProduct")
public class AllProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idHang = request.getParameter("idHang");
        HttpSession session = request.getSession();
        session.setAttribute("idHang", idHang);

        int page = 1;
        if (request.getParameter("page") != null && request.getParameter("page") != ""){
            page = Integer.parseInt(request.getParameter("page"));
        }
        request.setAttribute("page", page);
        int limit = 24;


        if (idHang != null) {
            int totalPageProducer = ProductService.getInstance().getTotalPageByProducer(idHang);
            int totalProducer = (int) Math.ceil((double) totalPageProducer / (double) limit);
            request.setAttribute("totalPage", totalProducer);
            request.setAttribute("allProduct", ProductService.getInstance().getProductManufacturer(idHang, limit, page));
            request.setAttribute("allProducer", ProductService.getInstance().getProducerWithID(idHang));
        } else {
            int totalPage = ProductService.getInstance().getTotalPage();
            int total = (int) Math.ceil((double) totalPage / (double) limit);
            request.setAttribute("totalPage", total);
            request.setAttribute("allProduct", ProductService.getInstance().getAllProduct(limit, page));
            request.setAttribute("allProducer", ProductService.getInstance().getAllProducer());
        }
        request.getRequestDispatcher("jsp/all-product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}