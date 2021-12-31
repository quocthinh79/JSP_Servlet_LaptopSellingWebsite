package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.controller;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
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
import java.util.Currency;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "Sort", value = "/Sort")
public class Sort extends HttpServlet {
    private static final Multimap<String, String> map = HashMultimap.create();
    private static final int count = 0;

    private static void sortFuction(Multimap<String, String> map, HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
//        map = new HashMap<>();
        HttpSession session = request.getSession();
        String hangsx = (String) session.getAttribute("idHang");
        List<Product> list = null;
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        currencyVN.setCurrency(Currency.getInstance("VND"));

        String orderBy = request.getParameter("value");
        session.setAttribute("orderBy", orderBy);
        int page = 1;
        if (request.getParameter("page") != null && request.getParameter("page") != "") {
            page = Integer.parseInt(request.getParameter("page"));
        }
        request.setAttribute("page", page);
        int limit = 24;
        int totalPage;
        int total = 0;
        if (map.isEmpty()) {
            if (hangsx != null && hangsx != "") {
                totalPage = ProductService.getInstance().getTotalPageByProducer(hangsx);
                total = (int) Math.ceil((double) totalPage / (double) limit);
                request.setAttribute("totalPage", total);
                list = ProductService.getInstance().getProductManufacturer(hangsx, limit, page);
                request.setAttribute("allProducer", ProductService.getInstance().getProducerWithID(hangsx));
            } else {
                totalPage = ProductService.getInstance().getTotalPage();
                total = (int) Math.ceil((double) totalPage / (double) limit);
                request.setAttribute("totalPage", total);
                list = ProductService.getInstance().getAllProduct(limit, page);
                request.setAttribute("allProducer", ProductService.getInstance().getAllProducer());
            }
        } else if (hangsx == null) {
            totalPage = ProductService.getInstance().sortProductTotalPage(map);
            total = (int) Math.ceil((double) totalPage / (double) limit);
            request.setAttribute("totalPage", total);
            if (orderBy.equalsIgnoreCase("desc")) {
                list = ProductService.getInstance().sortProduct(map, "desc", limit, page);
            } else {
                list = ProductService.getInstance().sortProduct(map, "asc", limit, page);
            }
        } else {
            if (orderBy.equalsIgnoreCase("desc")) {
                list = ProductService.getInstance().sortProductWithProducer(map, hangsx, "desc");
            } else {
                list = ProductService.getInstance().sortProductWithProducer(map, hangsx, "asc");
            }
        }
        session.setAttribute("map", map);
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String value = request.getParameter("value");
        String name = request.getParameter("name");

        switch (name) {
            case "hang":
                if (map.values().contains(value)) {
                    map.remove("hang", value);
                } else {
                    map.put("hang", value);
                }
                break;
            case "mau":
                if (map.values().contains(value)) {
                    map.remove("mau", value);
                } else {
                    map.put("mau", value);
                }
                break;
            case "cpu":
                if (map.values().contains(value)) {
                    map.remove("SUBSTRING_INDEX(SUBSTRING_INDEX(cpu, ' ', 3), ' ', -2)", value);
                } else {
                    map.put("SUBSTRING_INDEX(SUBSTRING_INDEX(cpu, ' ', 3), ' ', -2)", value);
                }
                break;
            case "ram":
                if (map.values().contains(value)) {
                    map.remove("ram", value);
                } else {
                    map.put("ram", value);
                }
                break;
            case "series":
                if (map.values().contains(value)) {
                    map.remove("series", value);
                } else {
                    map.put("series", value);
                }
                break;
            case "btn-filter-price":
                map.get("GIABAN").clear();
                String strLow = request.getParameter("lowestPrice").replaceAll(",", "");
                String strHigh = request.getParameter("highPrice").replaceAll(",", "");
                if (!strLow.equals("") && !strHigh.equals("")) {
                    map.put("GIABAN", strLow);
                    map.put("GIABAN", strHigh);
                }
                break;
        }
        map.entries().removeIf(e -> e.getValue() == null);
        sortFuction(map, response, request);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}