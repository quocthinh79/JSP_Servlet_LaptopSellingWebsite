package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.dao.ThanhVienDAO;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.model.User;

@WebServlet("/DangNhap")
public class XuLyDangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public XuLyDangNhap() {
        super();
    }
    com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.model.MyConnectDB myCN = new com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.model.MyConnectDB();

  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		ServletContext context=getServletContext();
  		String urlRQ=(String) context.getAttribute("urlweb");
  		HttpSession ssDangXuat = request.getSession(false);
  		if (ssDangXuat != null) {
  			ssDangXuat.invalidate();
  		}
  		String username= request.getParameter("user");
  		String pass= request.getParameter("pwd");
  		System.out.println(""+username+pass);
  		PrintWriter out = response.getWriter();
  		boolean login=false;
  		
  		try {
  			if(new ThanhVienDAO().checkLogin(username, pass)){
  				login=true;
  				System.out.println(username);
  				User tv = new ThanhVienDAO().getUser(username);
  				HttpSession session = request.getSession();
  				session.setAttribute("user", tv);
  				session.setMaxInactiveInterval(8*60*60);
  			}
  			if(!login){
  				out.println("Tai khoan hoac mat khau khong dung");
  			}else{
  				if(urlRQ==null|| urlRQ.equals("")){
  					response.sendRedirect("JSP_Servlet_LaptopSellingWebsite-main/src/main/webapp/index.jsp");
  				}else{
  					response.sendRedirect(urlRQ);
  				}
  			}
  		} catch (Exception e) {
  			e.printStackTrace();
  		}		
  	
  	}
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		String userid= "";
  		String username= request.getParameter("user");
  		String pass= request.getParameter("pwd");
  		String name= request.getParameter("name");
  		String email= request.getParameter("email");
  		String address= request.getParameter("address");
  		String phone= request.getParameter("phone");
  		String stk= request.getParameter("stk");
  		
  		PrintWriter out = response.getWriter();
  		boolean ketnoi=true;
  		try {
  			if(username.equals("")||pass.equals("")||name.equals("")||email.equals("")||address.equals("")||phone.equals("")){
  				out.println("Ban nhap thieu noi dung");
  			}
  			{
  			ResultSet rs = myCN.chonDuLieu("select * from user ");
  			while (rs.next()) {
  				String t = rs.getString(1);
  				userid=Integer.parseInt(t)+1+"";
  			}
  			if(new ThanhVienDAO().checkUserName(username)){
  				ketnoi=false;
  			}
  			User u = new User(userid, username, pass, name, email, address, phone, stk);
  		
  			if(ketnoi){
  				new ThanhVienDAO().add(u);
  				response.sendRedirect("JSP_Servlet_LaptopSellingWebsite-main/src/main/webapp/index.jsp");
  			}else{
  				out.print("Tai khoan da ton tai");
  			}
  			}
  		} catch (ClassNotFoundException | SQLException e) {
  			System.out.println(e.getMessage());
  		} catch (Exception e) {
  			System.out.println(e.getMessage());
  		}
  	}
}