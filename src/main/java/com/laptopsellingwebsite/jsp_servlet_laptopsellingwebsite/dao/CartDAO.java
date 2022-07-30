package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.dao;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Product;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.db.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartDAO {
    private static CartDAO instance;

    public static CartDAO getInstance() {
        if (instance == null) {
            instance = new CartDAO();
        }
        return instance;
    }

    public ArrayList<String> getProductIDFromCartByUserID(String userID) {
        ArrayList<String> result = new ArrayList<String>();
        try {
            String querryLayMaLaptop = "select malaptop from ctgh where MAGIOHANG in (select MAGIOHANG from giohang where giohang.MAKH = ?";
            PreparedStatement ps = DBConnect.getInstance().get(querryLayMaLaptop);
            ps.setString(1,userID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(rs.getString(1));
            }
            return result;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;

        }

    }

//    public Product getProduct(String idProduct) {
//        try {
//            Product result = new Product();
//            String query  = "select * from thongtinlaptop where malaptop = ?";
//            PreparedStatement ps = DBConnect.getInstance().get(query);
//            ps.setString(1,idProduct);
//            ResultSet resultSet = ps.executeQuery();
//            while (resultSet.next()){
//                        result.setMaLapTop(resultSet.getString(1)) ,
//                        ,
//                        resultSet.getString(3),
//                        resultSet.getInt(4),
//                        resultSet.getString(5),
//                        resultSet.getString(6),
//                        resultSet.getString(7),
//                        resultSet.getString(8),
//                        resultSet.getString(9),
//                        resultSet.getString(10),
//                        resultSet.getString(11),
//                        resultSet.getString(12),
//                        resultSet.getString(13),
//                        resultSet.getString(14),
//                        resultSet.getString(18),
//                        resultSet.getString(15),
//                        resultSet.getString(16),
//                        resultSet.getString(17),
//                        resultSet.getString(19));
//            }
//
//            return result;
//
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//           return null;
//        }
//    }
}
