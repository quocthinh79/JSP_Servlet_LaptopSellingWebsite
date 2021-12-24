package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.controller;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Product;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "Sort", value = "/Sort")
public class Sort extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Enumeration e = request.getParameterNames();
        System.out.println(e.hasMoreElements());
        while(e.hasMoreElements()){
            System.out.println(e.nextElement());
        }
        List<Product> result = ProductService.getInstance().getAllProduct();
        PrintWriter out = response.getWriter();
        for (Product x : result) {
            out.println("<div class=\"hover-all-product\">\n" +
                    "                        <a class=\"all-product-item\" href=\"/Product?id="+x.getMaLapTop()+"\">\n" +
                    "                            <div class=\"status-sale\">-11%</div>\n" +
                    "                            <div class=\"img-all-product-item\"\n" +
                    "                                 style=\"background-image: url('../image/logo.png')\">\n" +
                    "                            </div>\n" +
                    "                            <div class=\"status\">HẾT HÀNG</div>\n" +
                    "                            <div class=\"infor-all-product-item\">\n" +
                    "                                    "+x.getTenLaptop()+"\n" +
                    "                            </div>\n" +
                    "                            <div class=\"price-all-product-item\">\n" +
                    "                                    "+x.getGiaBan()+"\n" +
                    "                            </div>\n" +
                    "                            <div class=\"sale-all-product-item\">\n" +
                    "                                <span class=\"origin-price\">33.999.000đ</span> <span>11%</span>\n" +
                    "                            </div>\n" +
                    "                        </a>\n" +
                    "                    </div>");
        }
//        request.setAttribute("allProduct", ProductService.getInstance().getAllProduct());

//        request.setAttribute("allProducer", ProductService.getInstance().getAllProducer());
//        request.getRequestDispatcher("jsp/all-product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
