package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.dao.AdminDao;

import java.util.List;

public class AdminServices {
    private static AdminServices instance;

    private AdminServices() {

    }

    public static AdminServices getInstance() {
        if (instance == null) {
            instance = new AdminServices();
        }
        return instance;
    }

    public int insertLapTop(String maLapTop, String tenLaptop, String hang, int giaBan, String series, String mau, String cpu, String vga, String ram, String kichThuocManHinh, String oCung, String banPhim, String pin, String khoiLuong, String linkHinh1, String linkHinh2, String linkHinh3, String linkHinh4, String linkHinh5) {
        return AdminDao.getInstance().insertLapTop(maLapTop, tenLaptop, hang, giaBan, series, mau, cpu, vga, ram, kichThuocManHinh, oCung, banPhim, pin, khoiLuong, linkHinh1, linkHinh2, linkHinh3, linkHinh4, linkHinh5);
    }

    public int updateLaptop(String maLapTop, String tenLaptop, String hang, int giaBan, String series, String mau, String cpu, String vga, String ram, String kichThuocManHinh, String oCung, String banPhim, String pin, String khoiLuong, String linkHinh1, String linkHinh2, String linkHinh3, String linkHinh4, String linkHinh5, String dieuKien) {
        return AdminDao.getInstance().updateLaptop(maLapTop, tenLaptop, hang, giaBan, series, mau, cpu, vga, ram, kichThuocManHinh, oCung, banPhim, pin, khoiLuong, linkHinh1, linkHinh2, linkHinh3, linkHinh4, linkHinh5, dieuKien);
    }

    public int deleteLaptop(String dieuKien) {
        return AdminDao.getInstance().deleteLaptop(dieuKien);
    }

}
