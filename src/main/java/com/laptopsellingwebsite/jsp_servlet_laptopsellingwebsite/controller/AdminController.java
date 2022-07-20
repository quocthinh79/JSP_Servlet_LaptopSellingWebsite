package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.controller;

import com.google.common.collect.Multimap;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service.AdminServices;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service.ProductService;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
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
                // Đổ dữ liệu và phân trang cho bảng Thông tin laptop
                int page = 1;
                if (request.getParameter("pageTTLT") == null && request.getParameter("pageTTLT") == "") {
                    page = 1;
                }
                if (request.getParameter("pageTTLT") != null && request.getParameter("pageTTLT") != "") {
                    page = Integer.parseInt(request.getParameter("pageTTLT"));
                }
                request.setAttribute("pageTTLT", page);
                int limit = 24;
                request.setAttribute("allProduct", ProductService.getInstance().getAllProduct(limit, page));
                int totalPage = ProductService.getInstance().getTotalPage();
                int total = (int) Math.ceil((double) totalPage / (double) limit);
                request.setAttribute("totalPageTTLT", total);
                request.getRequestDispatcher("jsp/admin.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = request.getParameter("send");
        String dataTemp = data;
        String[] exactlyData = dataTemp.split(",");
        String currentTable = request.getParameter("currentTable");
        String URL = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/"), request.getRequestURI().length());
        PrintWriter out = response.getWriter();
        switch (URL) {
            case "/Edit":
                String dieuKienUpdate = request.getParameter("dieuKien");
                switch (currentTable.toUpperCase()) {
                    case "TTLT":
                        String maLaptop = exactlyData[0];
                        String tenLaptop = exactlyData[1];
                        String hang = exactlyData[2];
                        int giaban = 0;
                        try {
                            giaban = Integer.parseInt(exactlyData[3]);
                        } catch (Exception e) {
                            giaban = 0;
                        }
                        String series = exactlyData[4];
                        String mau = exactlyData[5];
                        String cpu = exactlyData[6];
                        String vga = exactlyData[7];
                        String ram = exactlyData[8];
                        String kichThuocManHinh = exactlyData[9];
                        String oCung = exactlyData[10];
                        String banPhim = exactlyData[11];
                        String pin = exactlyData[12];
                        String khoiLuong = exactlyData[13];
                        String linkHinh1 = exactlyData[14];
                        String linkHinh2 = exactlyData[15];
                        String linkHinh3 = exactlyData[16];
                        String linkHinh4 = exactlyData[17];
                        String linkHinh5 = exactlyData[18];
                        out.println(AdminServices.getInstance().updateLaptop(maLaptop, tenLaptop, hang, giaban, series, mau, cpu, vga, ram, kichThuocManHinh, oCung, banPhim, pin, khoiLuong, linkHinh1, linkHinh2, linkHinh3, linkHinh4, linkHinh5, dieuKienUpdate));
                        break;
                }
                break;
            case "/Delete":
                String dieuKienDelete = request.getParameter("dieuKien");
                switch (currentTable.toUpperCase()) {
                    case "TTLT":
                        out.println(AdminServices.getInstance().deleteLaptop(dieuKienDelete));
                        break;
                }
                break;
            case "/Add":
                switch (currentTable.toUpperCase()) {
                    case "TTLT":
                        String maLaptop = exactlyData[0];
                        String tenLaptop = exactlyData[1];
                        String hang = exactlyData[2];
                        int giaban = 0;
                        try {
                            giaban = Integer.parseInt(exactlyData[3]);
                        } catch (Exception e) {
                            giaban = 0;
                        }
                        String series = exactlyData[4];
                        String mau = exactlyData[5];
                        String cpu = exactlyData[6];
                        String vga = exactlyData[7];
                        String ram = exactlyData[8];
                        String kichThuocManHinh = exactlyData[9];
                        String oCung = exactlyData[10];
                        String banPhim = exactlyData[11];
                        String pin = exactlyData[12];
                        String khoiLuong = exactlyData[13];
                        String linkHinh1 = exactlyData[14];
                        String linkHinh2 = exactlyData[15];
                        String linkHinh3 = exactlyData[16];
                        String linkHinh4 = exactlyData[17];
                        String linkHinh5 = exactlyData[18];
                        out.println(AdminServices.getInstance().insertLapTop(maLaptop, tenLaptop, hang, giaban, series, mau, cpu, vga, ram, kichThuocManHinh, oCung, banPhim, pin, khoiLuong, linkHinh1, linkHinh2, linkHinh3, linkHinh4, linkHinh5));
                        break;
                }
                break;
        }
    }
}
