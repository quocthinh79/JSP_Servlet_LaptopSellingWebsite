package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.dao;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Account;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.db.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    static {
        List<Account> accounts = new ArrayList<>();
        Account ac1 = new Account(1, "Nguyen Van A", "userName1", "123456", "tp hcm", "1@gmail.com");
        accounts.add(ac1);
    }

    public static boolean checkUser(String userName) {
        String sql = "select username from tk where username = ?";
        try {
            PreparedStatement preparedStatement = DBConnect.getInstance().get(sql);
            preparedStatement.setString(1, userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Account getUser(String userName, String passWord) {
        Account result = null;
        String sql = "select id, hoten, username, password, diachi, email from tk where username = ? and password = ?";
        try {
            PreparedStatement preparedStatement = DBConnect.getInstance().get(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, passWord);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String hoTen = resultSet.getString(2);
                String username = resultSet.getString(3);
                String pass = resultSet.getString(4);
                String diaChi = resultSet.getString(5);
                String email = resultSet.getString(6);
                result = new Account(id, hoTen, userName, pass, diaChi, email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
