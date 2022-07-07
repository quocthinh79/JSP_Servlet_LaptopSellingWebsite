package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnectDB {
		public static String sqlDB;
		
		public MyConnectDB() {
			super();
			sqlDB = "jdbc:sqlserver://shopphoneltw.database.windows.net:1433;database=Shopphone;user=shopphone@shopphoneltw;password=Admin1234;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
		}
		
		public static  Connection connect() throws Exception{
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection connect = DriverManager.getConnection(sqlDB);
//				Class.forName("com.mysql.jdbc.Driver");
//				Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopphonechuan","root","abcdabcd");
				return connect;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return null;
		}
		public  void thucThiSQL(String sql) throws Exception{
			Connection connect =connect();
			Statement stmt = connect.createStatement();
			stmt.executeUpdate(sql);
		}
		public ResultSet chonDuLieu(String sql) throws Exception{
			Connection connect =connect();
			Statement stmt = connect.createStatement();
			ResultSet rs=	stmt.executeQuery(sql);
			return rs;
		}
		
		public static void main(String[]  args) throws Exception {
			System.out.println(90);
			MyConnectDB myConnectDB = new MyConnectDB();
			myConnectDB.connect();
		}
		
		public PreparedStatement dungStament(String sql) throws SQLException, Exception{
			return connect().prepareStatement(sql);
		}

		public static Connection getConnection() {
			return null;
		}
	
	
	
}