package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.model.*;

public class ThanhVienDAO implements ObjectDAO {

	public static Map<String,User> mapUser = loadDataUser();
	public static Map<String,User> mapUndo=new HashMap<>();
	public boolean delAll() {
		mapUndo.putAll(mapUser);
		mapUser.clear();
		return true;
	}

	public boolean undo() {
		mapUser.putAll(mapUndo);
		mapUndo.clear();
		return true;
	}
	
	public boolean delete(String id) {
		mapUser.remove(id);
		String sql = "delete from [dbo].[USER] where id='" + id + "'";
		try {
			new MyConnectDB().thucThiSQL(sql);
			return true;
		} catch (Exception e) {
			System.out.println("Hệ thống lỗi vì:" + e.getMessage());
			return false;
		}
	}

	public static Map<String, User> loadDataUser() {
		 Map<String,User> map = new HashMap<>();
		try {
			ResultSet rs = new MyConnectDB().chonDuLieu("select * from [dbo].[user]");
			while(rs.next()){
				String userid = rs.getString(1);
				String userName = rs.getString(2);
				String pass = rs.getString(3);
				String name = rs.getString(4);
				String email = rs.getString(5);
				String address = rs.getString(6);
				String phone = rs.getString(7);
				String stk = rs.getString(8);
				map.put(userid, new User(userid, userName, pass, name, email, address, phone, stk));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
	// login
	public boolean checkLogin(String username, String pass) throws Exception {
		System.out.println(mapUser);
			for(User u : mapUser.values()){
				if (u.getUsername().equals(username) && u.getPass().equals(pass)) {
					TenDangNhap.name = u.getName();
					TenDangNhap.maDN = Integer.parseInt(u.getUserid());
					return true;
				}
			}
		return false;
	}
	public User getUser(String name) throws Exception{
		User user=null;
		String role="";
		String sql="select u.username,u.password,u.role from [dbo].[user]  u where u.username='"+name+"'";
		try {
			ResultSet result=new MyConnectDB().chonDuLieu(sql);
			while(result.next()){
				user=new User(result.getString(1), result.getString(2));
				role=result.getString(3);
				user.setRole(role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}
		// kiểm tra username tồn tại chưa
	public boolean checkUserName(String username) throws Exception {
		for(User u : mapUser.values()){
			if (u.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean add(Object obj) throws Exception {
		User u = (User) obj;
		mapUser.put(u.getUserid(), u);
		try {
			String sql="insert into [dbo].[USER]  values (?,?,?,?,?,?,?,?)";
			Connection connect = MyConnectDB.connect();
			PreparedStatement ppstm = connect.prepareStatement(sql);
			ppstm.setString(1, u.getUserid());
			ppstm.setString(2, u.getUsername());
			ppstm.setString(3, u.getPass());
			ppstm.setString(4, u.getName());
			ppstm.setString(5, u.getEmail());
			ppstm.setString(6, u.getAddress());
			ppstm.setString(7, u.getPhone());
			ppstm.setString(8, u.getStk());
			ppstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Hệ thống gặp lỗi " + e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean edit(Object obj) {
		User u = (User) obj;
		mapUser.replace(u.getUserid(), u);
		try {
			String sql = "update [dbo].[USER] set id=?,username=?,password=?,name=?,email=?,address=?,phone=?,stk=? where id=?";
			Connection connect = MyConnectDB.connect();
			PreparedStatement ppstm = connect.prepareStatement(sql);
			ppstm.setString(1, u.getUserid());
			ppstm.setString(2, u.getUsername());
			ppstm.setString(3, u.getPass());
			ppstm.setString(4, u.getName());
			ppstm.setString(5, u.getEmail());
			ppstm.setString(6, u.getAddress());
			ppstm.setString(7, u.getPhone());
			ppstm.setString(8, u.getStk());
			ppstm.setString(9, u.getUserid());
			ppstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Hệ thống gặp lỗi " + e.getMessage());
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(new ThanhVienDAO().mapUser);
	}

}