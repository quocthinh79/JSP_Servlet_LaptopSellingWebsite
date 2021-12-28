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
import java.util.List;
import java.util.Map;

@WebServlet(name = "Pagination", value = "/Pagination")
public class Pagination extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String idHang = (String) session.getAttribute("idHang");
        List<Product> listProduct = null;
        Map<String, String> map = (Map<String, String>) session.getAttribute("map");
        String orderBy = (String) session.getAttribute("orderBy");
        int page = 1;
        if (request.getParameter("page") != null && request.getParameter("page") != ""){
            page = Integer.parseInt(request.getParameter("page"));
        }
        request.setAttribute("page", page);
        int limit = 24;
        int totalPage;
        int total = 0;
        if (map == null){
            if (idHang != null && idHang != "") {
                totalPage = ProductService.getInstance().getTotalPageByProducer(idHang);
                total = (int) Math.ceil((double) totalPage / (double) limit);
                request.setAttribute("totalPage", total);
                listProduct = ProductService.getInstance().getProductManufacturer(idHang, limit, page);
                request.setAttribute("allProduct", listProduct);
                request.setAttribute("allProducer", ProductService.getInstance().getProducerWithID(idHang));
            } else {
                totalPage = ProductService.getInstance().getTotalPage();
                total = (int) Math.ceil((double) totalPage / (double) limit);
                request.setAttribute("totalPage", total);
                listProduct = ProductService.getInstance().getAllProduct(limit, page);
                request.setAttribute("allProduct", listProduct);
                request.setAttribute("allProducer", ProductService.getInstance().getAllProducer());
            }
        } else if (idHang == null) {
            totalPage = ProductService.getInstance().sortProductTotalPage(map);
            total = (int) Math.ceil((double) totalPage / (double) limit);
            request.setAttribute("totalPage", total);
            if (orderBy.equalsIgnoreCase("desc")) {
                listProduct = ProductService.getInstance().sortProduct(map, "desc", limit, page);
                request.setAttribute("allProduct", listProduct);
                request.setAttribute("allProducer", ProductService.getInstance().getAllProducer());
            } else {
                listProduct = ProductService.getInstance().sortProduct(map, "asc", limit, page);
                request.setAttribute("allProduct", listProduct);
                request.setAttribute("allProducer", ProductService.getInstance().getAllProducer());
            }
        }
//        else {
//            if (orderBy.equalsIgnoreCase("desc")) {
//                list = ProductService.getInstance().sortProductWithProducer(map, hangsx, "desc");
//            } else {
//                list = ProductService.getInstance().sortProductWithProducer(map, hangsx, "asc");
//            }
//        }

        request.getRequestDispatcher("jsp/all-product.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
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
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.text.NumberFormat;
//import java.util.List;
//import java.util.Locale;
//import java.util.Map;
//
//@WebServlet(name = "Pagination", value = "/Pagination")
//public class Pagination extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        HttpSession session = request.getSession();
//        String idHang = (String) session.getAttribute("idHang");
//        List<Product> listProduct = null;
//        Map<String, String> map = (Map<String, String>) session.getAttribute("map");
//        String orderBy = (String) session.getAttribute("orderBy");
//        int page = 1;
//        if (request.getParameter("page") != null && request.getParameter("page") != ""){
//            page = Integer.parseInt(request.getParameter("page"));
//        }
//        request.setAttribute("page", page);
//        int limit = 24;
//        int totalPage;
//        int total = 0;
//        if (map == null){
//            if (idHang != null && idHang != "") {
//                totalPage = ProductService.getInstance().getTotalPageByProducer(idHang);
//                total = (int) Math.ceil((double) totalPage / (double) limit);
//                request.setAttribute("totalPage", total);
//                listProduct = ProductService.getInstance().getProductManufacturer(idHang, limit, page);
//                request.setAttribute("allProducer", ProductService.getInstance().getProducerWithID(idHang));
//            } else {
//                totalPage = ProductService.getInstance().getTotalPage();
//                total = (int) Math.ceil((double) totalPage / (double) limit);
//                request.setAttribute("totalPage", total);
//                listProduct = ProductService.getInstance().getAllProduct(limit, page);
//                request.setAttribute("allProducer", ProductService.getInstance().getAllProducer());
//            }
//        } else if (idHang == null) {
//            totalPage = ProductService.getInstance().sortProductTotalPage(map);
//            total = (int) Math.ceil((double) totalPage / (double) limit);
//            request.setAttribute("totalPage", total);
//            if (orderBy.equalsIgnoreCase("desc")) {
//                listProduct = ProductService.getInstance().sortProduct(map, "desc", limit, page);
//            } else {
//                listProduct = ProductService.getInstance().sortProduct(map, "asc", limit, page);
//            }
//        }
////        else {
////            if (orderBy.equalsIgnoreCase("desc")) {
////                list = ProductService.getInstance().sortProductWithProducer(map, hangsx, "desc");
////            } else {
////                list = ProductService.getInstance().sortProductWithProducer(map, hangsx, "asc");
////            }
////        }
//
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
//        out.println("*total page* " + total);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }
//}
