package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.controller;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Product;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "SearchController", value = "/Search")
public class SearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = null;
        String txt = request.getParameter("txt");
        response.setContentType("text/html;charset=UTF-8");
        list = ProductService.getInstance().search(txt);
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        PrintWriter out = response.getWriter();
        for (Product x : list) {
            out.println("<div class=\"hover-all-product\">\n" +
                    "                        <a class=\"all-product-item\" href=\"" + request.getContextPath() + "/Product?id=" + x.getMaLapTop() + "\">\n" +
                    "                            <div class=\"status-sale\">-11%</div>\n" +
                    "                            <div class=\"img-all-product-item\"\n" +
                    "                                 style=\"background-image: url('" + x.getLinkHinh1() + "')\">\n" +
                    "                            </div>\n" +
                    "                            <div class=\"status\">HẾT HÀNG</div>\n" +
                    "                            <div class=\"infor-all-product-item\">\n" +
                    "                                    " + x.getTenLaptop() + "\n" +
                    "                            </div>\n" +
                    "                            <div class=\"price-all-product-item\">\n" +
                    "                                    " + currencyVN.format(x.getGiaBan()) + "\n" +
                    "                            </div>\n" +
                    "                            <div class=\"sale-all-product-item\">\n" +
                    "                                <span class=\"origin-price\">33.999.000đ</span> <span>11%</span>\n" +
                    "                            </div>\n" +
                    "                        </a>\n" +
                    "                    </div>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
