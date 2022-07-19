package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.dao;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Manufacturer;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Product;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.db.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDao {
    private static AdminDao instance;

    public static AdminDao getInstance() {
        if (instance == null) {
            instance = new AdminDao();
        }
        return instance;
    }

    public void insertLapTop(String maLapTop, String hang, int giaBan, String series, String mau, String cpu, String vga, String ram, String kichThuocManHinh, String oCung, String banPhim, String pin, String khoiLuong, String linkHinh1, String linkHinh2, String linkHinh3, String linkHinh4, String linkHinh5) {
        try {
            String query = "select * from thongtinlaptop LIMIT " + "?" + " OFFSET " + "?";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setString(1, maLapTop);
            ps.setString(2, hang);
            ps.setInt(3, giaBan);
            ps.setString(4, series);
            ps.setString(5, mau);
            ps.setString(6, cpu);
            ps.setString(7, vga);
            ps.setString(8, ram);
            ps.setString(9, kichThuocManHinh);
            ps.setString(10, oCung);
            ps.setString(11, banPhim);
            ps.setString(12, pin);
            ps.setString(13, khoiLuong);
            ps.setString(14, linkHinh1);
            ps.setString(15, linkHinh2);
            ps.setString(16, linkHinh3);
            ps.setString(17, linkHinh4);
            ps.setString(18, linkHinh5);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
