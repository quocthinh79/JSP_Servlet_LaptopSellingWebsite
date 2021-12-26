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
import java.util.*;

@WebServlet(name = "Sort", value = "/Sort")
public class Sort extends HttpServlet {
    private static final ArrayList listProduct = new ArrayList<>();
    private static final ArrayList listColor = new ArrayList<>();
    private static final ArrayList listCPU = new ArrayList<>();
    private static final ArrayList listRAM = new ArrayList<>();
    private static final ArrayList listSERIES = new ArrayList<>();
    private static final ArrayList listPrice = new ArrayList<>();
    private static final Map<String, String> map = new HashMap();

    private static final ArrayList listProduct1 = new ArrayList<>();
    private static final ArrayList listColor1 = new ArrayList<>();
    private static final ArrayList listCPU1 = new ArrayList<>();
    private static final ArrayList listRAM1 = new ArrayList<>();
    private static final ArrayList listSERIES1 = new ArrayList<>();
    private static final ArrayList listPrice1 = new ArrayList<>();
    private static final Map<String, String> map1 = new HashMap();

    private static void sortFuction(Map<String, String> map, HttpServletResponse response, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        String hangsx = (String) session.getAttribute("idHang");
        List<Product> list = null;
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        currencyVN.setCurrency(Currency.getInstance("VND"));

        String orderBy = request.getParameter("value");
        if (map.isEmpty()) {
            if (hangsx == null) {
                if (orderBy.equalsIgnoreCase("desc"))
                    list = ProductService.getInstance().getAllProduct("desc");
                else if (orderBy.equalsIgnoreCase("asc"))
                    list = ProductService.getInstance().getAllProduct("asc");
            } else {
                if (orderBy.equalsIgnoreCase("desc"))
                    list = ProductService.getInstance().getProductManufacturer(hangsx, "desc");
                else if (orderBy.equalsIgnoreCase("asc"))
                    list = ProductService.getInstance().getProductManufacturer(hangsx, "asc");
            }
        } else if (hangsx == null) {
            if (orderBy.equalsIgnoreCase("desc")) {
                list = ProductService.getInstance().sortProduct(map, "desc");
            } else {
                list = ProductService.getInstance().sortProduct(map, "asc");
            }
        } else {
            if (orderBy.equalsIgnoreCase("desc")) {
                list = ProductService.getInstance().sortProductWithProducer(map, hangsx, "desc");
            } else {
                list = ProductService.getInstance().sortProductWithProducer(map, hangsx, "asc");
            }
        }
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

    private static List addList(List list, String value) {
        if (!list.contains(value)) {
            list.add(value);
        } else {
            list.remove(value);
        }
        return list;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String value = request.getParameter("value");
        value = "'" + value + "'";
        String name = request.getParameter("name");

        HttpSession session = request.getSession(true);
        switch (name) {
            case "hang":
                if (session.getAttribute("idHang") == null) {
                    String hangsx = String.join(", ", addList(listProduct, value));
                    map.put("hang", hangsx);
                } else {
                    String hangsx = String.join(", ", addList(listProduct1, value));
                    map1.put("hang", hangsx);
                }
                break;
            case "mau":
                if (session.getAttribute("idHang") == null) {
                    String mau = String.join(", ", addList(listColor, value));
                    map.put("mau", mau);
                } else {
                    String mau = String.join(", ", addList(listColor1, value));
                    map1.put("mau", mau);
                }
                break;
            case "cpu":
                if (session.getAttribute("idHang") == null) {
                    String cpu = String.join(", ", addList(listCPU, value));
                    map.put("SUBSTRING_INDEX(SUBSTRING_INDEX(CPU, ' ', 3), ' ', -2)", cpu);
                } else {
                    String cpu = String.join(", ", addList(listCPU1, value));
                    map1.put("SUBSTRING_INDEX(SUBSTRING_INDEX(CPU, ' ', 3), ' ', -2)", cpu);
                }
                break;
            case "ram":
                if (session.getAttribute("idHang") == null) {
                    String ram = String.join(", ", addList(listRAM, value));
                    map.put("ram", ram);
                } else {
                    String ram = String.join(", ", addList(listRAM1, value));
                    map1.put("ram", ram);
                }
                break;
            case "series":
                if (session.getAttribute("idHang") == null) {
                    String series = String.join(", ", addList(listSERIES, value));
                    map.put("series", series);
                } else {
                    String series = String.join(", ", addList(listSERIES1, value));
                    map1.put("series", series);
                }
                break;
            case "btn-filter-price":
                String strLow = request.getParameter("lowestPrice").replaceAll(",", "");
                String strHigh = request.getParameter("highPrice").replaceAll(",", "");
                String priceSQL = strLow + " AND " + strHigh;

                if (session.getAttribute("idHang") == null) {
                    String price = String.join(", ", addList(listPrice, priceSQL));
                    map.put("GIABAN", price);
                } else {
                    String price = String.join(", ", addList(listPrice1, priceSQL));
                    map1.put("GIABAN", price);
                }
                break;
        }
        System.out.println(map.entrySet());
        map.entrySet().removeIf(e -> e.getValue().isEmpty());
        map1.entrySet().removeIf(e -> e.getValue().isEmpty());
        if (session.getAttribute("idHang") == null) {
            sortFuction(map, response, request);
        } else {
            sortFuction(map1, response, request);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
