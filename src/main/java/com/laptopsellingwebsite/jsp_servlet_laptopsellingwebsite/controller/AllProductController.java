package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.controller;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Product;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

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
//        doGet(request, response);
        response.setContentType("text/html;charset=UTF-8");
        String idHang = request.getParameter("idHang");
        HttpSession session = request.getSession();
        session.setAttribute("idHang", idHang);
        List<Product> listProduct = null;

        int page = 1;
        if (request.getParameter("page") != null && request.getParameter("page") != ""){
            page = Integer.parseInt(request.getParameter("page"));
        }
        request.setAttribute("page", page);
        int limit = 24;

        if (idHang != null && idHang != "") {
            int totalPageProducer = ProductService.getInstance().getTotalPageByProducer(idHang);
            int totalProducer = (int) Math.ceil((double) totalPageProducer / (double) limit);
            request.setAttribute("totalPage", totalProducer);
            listProduct = ProductService.getInstance().getProductManufacturer(idHang, limit, page);
            request.setAttribute("allProducer", ProductService.getInstance().getProducerWithID(idHang));
        } else {
            int totalPage = ProductService.getInstance().getTotalPage();
            int total = (int) Math.ceil((double) totalPage / (double) limit);
            request.setAttribute("totalPage", total);
            listProduct = ProductService.getInstance().getAllProduct(limit, page);
            request.setAttribute("allProducer", ProductService.getInstance().getAllProducer());
        }
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        PrintWriter out = response.getWriter();
        for (Product x : listProduct) {
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
}


//package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.controller;
//
//import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Product;
//import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service.ProductService;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.text.NumberFormat;
//import java.util.List;
//import java.util.Locale;
//
//@WebServlet(name = "AllProductController", value = "/AllProduct")
//public class AllProductController extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String idHang = request.getParameter("idHang");
//
//        int page = 1;
//        if (request.getParameter("page") != null && request.getParameter("page") != ""){
//            page = Integer.parseInt(request.getParameter("page"));
//        }
//        request.setAttribute("page", page);
//        int limit = 24;
//
//        String queryString = request.getQueryString();
//        request.setAttribute("queryString", "&" + queryString);
//
//
//        if (idHang != null) {
//            int totalPageProducer = ProductService.getInstance().getTotalPageByProducer(idHang);
//            int totalProducer = (int) Math.ceil((double) totalPageProducer / (double) limit);
//            request.setAttribute("totalPage", totalProducer);
//            request.setAttribute("allProduct", ProductService.getInstance().getProductManufacturer(idHang, limit, page));
//            request.setAttribute("allProducer", ProductService.getInstance().getProducerWithID(idHang));
//        } else {
//            int totalPage = ProductService.getInstance().getTotalPage();
//            int total = (int) Math.ceil((double) totalPage / (double) limit);
//            request.setAttribute("totalPage", total);
//            request.setAttribute("allProduct", ProductService.getInstance().getAllProduct(limit, page));
//            request.setAttribute("allProducer", ProductService.getInstance().getAllProducer());
//        }
//        request.getRequestDispatcher("jsp/all-product.jsp").forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        doGet(request, response);
//        response.setContentType("text/html;charset=UTF-8");
//        String idHang = request.getParameter("idHang");
//        List<Product> listProduct = null;
//
//        int page = 1;
//        if (request.getParameter("page") != null && request.getParameter("page") != ""){
//            page = Integer.parseInt(request.getParameter("page"));
//        }
//        request.setAttribute("page", page);
//        int limit = 24;
//
//
//        if (idHang != null) {
//            int totalPageProducer = ProductService.getInstance().getTotalPageByProducer(idHang);
//            int totalProducer = (int) Math.ceil((double) totalPageProducer / (double) limit);
//            request.setAttribute("totalPage", totalProducer);
//            listProduct = ProductService.getInstance().getProductManufacturer(idHang, limit, page);
//            request.setAttribute("allProducer", ProductService.getInstance().getProducerWithID(idHang));
//        } else {
//            int totalPage = ProductService.getInstance().getTotalPage();
//            int total = (int) Math.ceil((double) totalPage / (double) limit);
//            request.setAttribute("totalPage", total);
//            listProduct = ProductService.getInstance().getAllProduct(limit, page);
//            request.setAttribute("allProducer", ProductService.getInstance().getAllProducer());
//        }
//        Locale localeVN = new Locale("vi", "VN");
//        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
//        PrintWriter out = response.getWriter();
//        for (Product x : listProduct) {
//            out.println("<div class=\"hover-all-product\">\n" +
//                    "                        <a class=\"all-product-item\" href=\"" + request.getContextPath() + "/Product?id=" + x.getMaLapTop() + "\">\n" +
//                    "                            <div class=\"status-sale\">-11%</div>\n" +
//                    "                            <div class=\"img-all-product-item\"\n" +
//                    "                                 style=\"background-image: url('" + x.getLinkHinh1() + "')\">\n" +
//                    "                            </div>\n" +
//                    "                            <div class=\"status\">HẾT HÀNG</div>\n" +
//                    "                            <div class=\"infor-all-product-item\">\n" +
//                    "                                    " + x.getTenLaptop() + "\n" +
//                    "                            </div>\n" +
//                    "                            <div class=\"price-all-product-item\">\n" +
//                    "                                    " + currencyVN.format(x.getGiaBan()) + "\n" +
//                    "                            </div>\n" +
//                    "                            <div class=\"sale-all-product-item\">\n" +
//                    "                                <span class=\"origin-price\">33.999.000đ</span> <span>11%</span>\n" +
//                    "                            </div>\n" +
//                    "                        </a>\n" +
//                    "                    </div>");
//        }
//    }
//}
