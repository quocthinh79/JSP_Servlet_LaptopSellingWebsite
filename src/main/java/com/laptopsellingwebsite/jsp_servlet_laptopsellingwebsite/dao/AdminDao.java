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

    public int insertLapTop(String maLapTop, String tenLaptop, String hang, int giaBan, String series, String mau, String cpu, String vga, String ram, String kichThuocManHinh, String oCung, String banPhim, String pin, String khoiLuong, String linkHinh1, String linkHinh2, String linkHinh3, String linkHinh4, String linkHinh5) {
        try {
            String query = "INSERT INTO thongtinlaptop VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setString(1, maLapTop);
            ps.setString(2, tenLaptop);
            ps.setString(3, hang);
            ps.setInt(4, giaBan);
            ps.setString(5, series);
            ps.setString(6, mau);
            ps.setString(7, cpu);
            ps.setString(8, vga);
            ps.setString(9, ram);
            ps.setString(10, kichThuocManHinh);
            ps.setString(11, oCung);
            ps.setString(12, banPhim);
            ps.setString(13, pin);
            ps.setString(14, khoiLuong);
            ps.setString(15, linkHinh1);
            ps.setString(16, linkHinh2);
            ps.setString(17, linkHinh3);
            ps.setString(18, linkHinh4);
            ps.setString(19, linkHinh5);
            return ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int updateLaptop(String maLapTop, String tenLaptop, String hang, int giaBan, String series, String mau, String cpu, String vga, String ram, String kichThuocManHinh, String oCung, String banPhim, String pin, String khoiLuong, String linkHinh1, String linkHinh2, String linkHinh3, String linkHinh4, String linkHinh5, String dieuKien) {
        try {
            String query = "UPDATE `thongtinlaptop` SET `MALAPTOP`=?,`TENLAPTOP`=?,`HANG`=?,`GIABAN`=?,`SERIES`=?,`MAU`=?,`CPU`=?,`VGA`=?,`RAM`=?,`KICHTHUOCMANHINH`=?,`OCUNG`=?,`BANPHIM`=?,`PIN`=?,`KHOILUONG`=?,`LINKHINH1`=?,`LINKHINH2`=?,`LINKHINH3`=?,`LINKHINH4`=?,`LINKHINH5`=? WHERE MALAPTOP = ?";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setString(1, maLapTop);
            ps.setString(2, tenLaptop);
            ps.setString(3, hang);
            ps.setInt(4, giaBan);
            ps.setString(5, series);
            ps.setString(6, mau);
            ps.setString(7, cpu);
            ps.setString(8, vga);
            ps.setString(9, ram);
            ps.setString(10, kichThuocManHinh);
            ps.setString(11, oCung);
            ps.setString(12, banPhim);
            ps.setString(13, pin);
            ps.setString(14, khoiLuong);
            ps.setString(15, linkHinh1);
            ps.setString(16, linkHinh2);
            ps.setString(17, linkHinh3);
            ps.setString(18, linkHinh4);
            ps.setString(19, linkHinh5);
            ps.setString(20, dieuKien);
            return ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteLaptop(String dieuKien) {
        try {
            String query = "DELETE FROM `thongtinlaptop` WHERE MALAPTOP = ?";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setString(1, dieuKien);
            return ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
