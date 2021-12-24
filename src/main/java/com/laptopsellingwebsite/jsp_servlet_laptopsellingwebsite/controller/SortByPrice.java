package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.controller;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.concurrent.ExecutorService;

@WebServlet(name = "SortByPrice", value = "/SortByPrice")
public class SortByPrice extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idHang =  request.getParameter("idHang");
        String strLow = request.getParameter("lowestPrice");
        int lowPrice = Integer.parseInt(strLow.replaceAll(",", ""));
        String strHigh = request.getParameter("highPrice");
        int highPrice = Integer.parseInt(strHigh.replaceAll(",", ""));


        if (idHang != null) {
            request.setAttribute("allProducer", ProductService.getInstance().getProducerWithID(idHang));
            request.setAttribute("allProduct", ProductService.getInstance().sortPriceWithProducer(highPrice, lowPrice, idHang));
        } else {
            request.setAttribute("allProducer", ProductService.getInstance().getAllProducer());
            request.setAttribute("allProduct", ProductService.getInstance().sortWithPrice(highPrice, lowPrice));
        }
        request.getRequestDispatcher("jsp/all-product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
