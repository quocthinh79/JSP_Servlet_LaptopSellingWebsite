package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.dao;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Account;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Manufacturer;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Product;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.WareHouse;
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

    // Phân trang Hãng sản xuất
    public ArrayList getAllManufacturer(int limit, int page) {
        ArrayList<Manufacturer> listResult = new ArrayList<>();
        try {
            int offset = (page - 1) * limit;
            String query = "select * from hangsx LIMIT " + "?" + " OFFSET " + "?";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Manufacturer manufacturer = new Manufacturer(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6));
                listResult.add(manufacturer);
            }
            return listResult;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getTotalManufacturer() {
        try {
            String query = "select count(*) as total from hangsx";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            return resultSet.getInt("total");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Thêm, xóa, sửa Hãng sản xuất
    public int insertHangSx(String tenHang, String quocGia, String poster, String logoVuong, String logoNgang, String slogan) {
        try {
            String query = "INSERT INTO hangsx VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setString(1, tenHang);
            ps.setString(2, quocGia);
            ps.setString(3, poster);
            ps.setString(4, logoVuong);
            ps.setString(5, logoNgang);
            ps.setString(6, slogan);
            return ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int updateHangSx(String tenHang, String quocGia, String poster, String logoVuong, String logoNgang, String slogan, String dieuKien) {
        try {
            String query = "UPDATE `hangsx` SET `TENHANG`=?,`QUOCGIA`=?,`POSTER`=?,`LOGOVUONG`=?,`LOGONGANG`=?,`SLOGAN`=? WHERE `TENHANG`=?";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setString(1, tenHang);
            ps.setString(2, quocGia);
            ps.setString(3, poster);
            ps.setString(4, logoVuong);
            ps.setString(5, logoNgang);
            ps.setString(6, slogan);
            ps.setString(7, dieuKien);
            return ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteHangSx(String dieuKien) {
        try {
            String query = "DELETE FROM `hangsx` WHERE TENHANG = ?";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setString(1, dieuKien);
            return ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Phân trang Hãng sản xuất
    public ArrayList getAllWareHouse(int limit, int page) {
        ArrayList<WareHouse> listResult = new ArrayList<>();
        try {
            int offset = (page - 1) * limit;
            String query = "select * from khohang LIMIT " + "?" + " OFFSET " + "?";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                WareHouse wareHouse = new WareHouse(resultSet.getString(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4));
                listResult.add(wareHouse);
            }
            return listResult;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getTotalPageWareHouse() {
        try {
            String query = "select count(*) as total from khohang";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            return resultSet.getInt("total");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Thêm, xóa, sửa Kho hàng
    public int insertKho(String maLaptop, int slNhap, int slXuat, int slTon) {
        try {
            String query = "INSERT INTO khohang VALUES (?, ?, ?, ?)";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setString(1, maLaptop);
            ps.setInt(2, slNhap);
            ps.setInt(3, slXuat);
            ps.setInt(4, slTon);
            return ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int updateKho(String maLaptop, int slNhap, int slXuat, int slTon, String dieuKien) {
        try {
            String query = "UPDATE `khohang` SET `MALAPTOP`=?,`SLNHAP`=?,`SLXUAT`=?,`TONKHO`=? WHERE `MALAPTOP`=?";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setString(1, maLaptop);
            ps.setInt(2, slNhap);
            ps.setInt(3, slXuat);
            ps.setInt(4, slTon);
            ps.setString(5, dieuKien);
            return ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteKho(String dieuKien) {
        try {
            String query = "DELETE FROM `khohang` WHERE MALAPTOP = ?";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setString(1, dieuKien);
            return ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Phân trang tài khoản
    public ArrayList getAllAccount(int limit, int page) {
        ArrayList<Account> listResult = new ArrayList<>();
        try {
            int offset = (page - 1) * limit;
            String query = "select * from tk LIMIT " + "?" + " OFFSET " + "?";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Account account = new Account(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6));
                listResult.add(account);
            }
            return listResult;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getTotalPageAccount() {
        try {
            String query = "select count(*) as total from tk";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            return resultSet.getInt("total");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Thêm, xóa, sửa tài khoản
    public int insertAccount(String hoTen, String username, String pass, String diaChi, String email) {
        try {
            String query = "INSERT INTO tk VALUES (NULL, ?, ?, ?, ?, ?, NULL)";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setString(1, hoTen);
            ps.setString(2, username);
            ps.setString(3, pass);
            ps.setString(4, diaChi);
            ps.setString(5, email);
            return ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int updateAccount(String hoTen, String username, String pass, String diaChi, String email, int dieuKien) {
        try {
            String query = "UPDATE `tk` SET `HOTEN`=?,`USERNAME`=?,`PASSWORD`=?,`DIACHI`=?,`EMAIL`=?  WHERE `ID`=?";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setString(1, hoTen);
            ps.setString(2, username);
            ps.setString(3, pass);
            ps.setString(4, diaChi);
            ps.setString(5, email);
            ps.setInt(6, dieuKien);
            System.out.println(ps.toString());
            return ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteAccount(int dieuKien) {
        try {
            String query = "DELETE FROM `tk` WHERE ID = ?";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setInt(1, dieuKien);
            return ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
