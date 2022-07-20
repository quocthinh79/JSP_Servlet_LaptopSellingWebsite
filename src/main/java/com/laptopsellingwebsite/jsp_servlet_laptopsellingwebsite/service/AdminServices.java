package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.dao.AdminDao;

import java.util.ArrayList;
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

    // Phân trang hãng sản xuất
    public ArrayList getAllManufacturer(int limit, int page) {
        return AdminDao.getInstance().getAllManufacturer(limit, page);
    }

    public int getTotalManufacturer() {
        return AdminDao.getInstance().getTotalManufacturer();
    }

    // Thêm xóa sửa hãng sản xuất
    public int insertHangSx(String tenHang, String quocGia, String poster, String logoVuong, String logoNgang, String slogan) {
        return AdminDao.getInstance().insertHangSx(tenHang, quocGia, poster, logoVuong, logoNgang, slogan);
    }

    public int updateHangSx(String tenHang, String quocGia, String poster, String logoVuong, String logoNgang, String slogan, String dieuKien) {
        return AdminDao.getInstance().updateHangSx(tenHang, quocGia, poster, logoVuong, logoNgang, slogan, dieuKien);
    }

    public int deleteHangSx(String dieuKien) {
        return AdminDao.getInstance().deleteHangSx(dieuKien);
    }

    // Phân trang kho hàng
    public ArrayList getAllWareHouse(int limit, int page) {
        return AdminDao.getInstance().getAllWareHouse(limit, page);
    }

    public int getTotalPageWareHouse() {
        return AdminDao.getInstance().getTotalPageWareHouse();
    }

    // Thêm xóa sửa hãng sản xuất
    public int insertKho(String maLaptop, int slNhap, int slXuat, int slTon) {
        return AdminDao.getInstance().insertKho(maLaptop, slNhap, slXuat, slTon);
    }

    public int updateKho(String maLaptop, int slNhap, int slXuat, int slTon, String dieuKien) {
        return AdminDao.getInstance().updateKho(maLaptop, slNhap, slXuat, slTon, dieuKien);
    }

    public int deleteKho(String dieuKien) {
        return AdminDao.getInstance().deleteKho(dieuKien);
    }

    // Phân trang tài khoản
    public ArrayList getAllAccount(int limit, int page) {
        return AdminDao.getInstance().getAllAccount(limit, page);
    }

    public int getTotalPageAccount() {
        return AdminDao.getInstance().getTotalPageAccount();
    }

    // Thêm xóa sửa hãng sản xuất
    public int insertAccount(String hoTen, String username, String pass, String diaChi, String email) {
        return AdminDao.getInstance().insertAccount(hoTen, username, pass, diaChi, email);
    }

    public int updateAccount(String hoTen, String username, String pass, String diaChi, String email, int dieuKien) {
        return AdminDao.getInstance().updateAccount(hoTen, username, pass, diaChi, email, dieuKien);
    }

    public int deleteAccount(int dieuKien) {
        return AdminDao.getInstance().deleteAccount(dieuKien);
    }
}
