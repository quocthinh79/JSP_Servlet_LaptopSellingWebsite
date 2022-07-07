package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.controller;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DangXuat")
public class XuLyDangXuat extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public XuLyDangXuat() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().setAttribute("taiKhoanDaDangNhap", new ArrayList<>());
		HttpSession ssDangXuat = request.getSession(false);
		if (ssDangXuat != null) {
			ssDangXuat.invalidate();
		}
		response.sendRedirect("JSP_Servlet_LaptopSellingWebsite-main/src/main/webapp/index.jsp");
	}

}