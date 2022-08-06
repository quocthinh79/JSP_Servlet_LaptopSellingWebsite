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

    public ArrayList<String> getProductIDFromCartByUserID(int userID) {
        ArrayList<String> idProductList = new ArrayList<String>();
        try {
            String querryLayMaLaptop = "select malaptop from ctgh where MAGIOHANG in (select MAGIOHANG from giohang where giohang.MAKH = ?)";
            PreparedStatement ps = DBConnect.getInstance().get(querryLayMaLaptop);
            ps.setInt(1,userID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                idProductList.add(rs.getString(1));
            }
            return idProductList;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;

        }

    }

    public ArrayList getProductList (ArrayList<String> listProductID) {
        ArrayList<Product> result = new ArrayList<Product>();
        try {
            for (String id_product: listProductID) {
                String querry = "select * from thongtinlaptop where malaptop = ?";
                PreparedStatement st = DBConnect.getInstance().get(querry);
                st.setString(1,id_product);

                ResultSet resultSet = st.executeQuery();

                while(resultSet.next()) {
                    Product product = new Product(resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(9),
                            resultSet.getString(10),
                            resultSet.getString(11),
                            resultSet.getString(12),
                            resultSet.getString(13),
                            resultSet.getString(14),
                            resultSet.getString(15),
                            resultSet.getString(16),
                            resultSet.getString(17),
                            resultSet.getString(18),
                            resultSet.getString(19));
                    result.add(product);
                }
                resultSet.close();
                st.close();
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public int getSLNhap(String productID) {
        int result = 0;
        try {
            String querry = "select SLNHAP from khohang where malaptop = ?";
            PreparedStatement ps = DBConnect.getInstance().get(querry);
            ps.setString(1, productID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }

            return result;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public String getCartID(String userID) {
        String result = "";
        try {

            String command = "select magiohang from giohang where makh = ?";
            PreparedStatement ps = DBConnect.getInstance().get(command);
            ps.setString(1,userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getString(1);
            }
            return result;
        } catch (SQLException | ClassNotFoundException e ) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertProductToCart(String productID, String userID, int quantity) {
        boolean result = false;
        try {
            String cartID = getCartID(userID);
            String command = "insert into ctgh values (?,?,?)";
            PreparedStatement ps = DBConnect.getInstance().get(command);
            ps.setString(1,cartID);
            ps.setString(2,productID);
            ps.setInt(3, quantity);
            int row = ps.executeUpdate();
            if (row > 0) result = true;
            ps.close();
            return result;


        } catch (SQLException | ClassNotFoundException e ) {
            e.printStackTrace();
            return result;
        }
    }

    public boolean updateProductQuantityByProductID(String productID, String userID, int quantityUpdated) {
        boolean result = false;
        try {
            String cartID = getCartID(userID);
            String command = "update ctgh set soluong = ? where magiohang = ? and masanpham = ?";
            PreparedStatement ps = DBConnect.getInstance().get(command);
            ps.setInt(1,quantityUpdated);
            ps.setString(2,cartID);
            ps.setString(3, productID);
            int row = ps.executeUpdate();
            if (row > 0) result = true;
            return result;

        } catch (SQLException | ClassNotFoundException e ) {
            e.printStackTrace();
            return result;
        }
    }

    public boolean removeProductFromCart(String productID, String userID) {
        boolean result = false;
        try {
            String cartID = getCartID(userID);
            String command = "DELETE FROM ctgh where magiohang = ? and masanpham = ?";
            PreparedStatement ps = DBConnect.getInstance().get(command);
            ps.setString(1,cartID);
            ps.setString(2, productID);
            int row = ps.executeUpdate();
            if (row > 0) result = true;
            return result;

        } catch (SQLException | ClassNotFoundException e ) {
            e.printStackTrace();
            return result;
        }
    }

    public int countCustomer() {
        try {
            String command = "select count(*) from tk";
            PreparedStatement ps = DBConnect.getInstance().get(command);
            ResultSet rs = ps.executeQuery();
            int result =  rs.getInt(1);
            return result;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean insertCart(String userID) {
        boolean result = false;
        try {
            String cartID = "";
            int customerQuantity = countCustomer();
            if (customerQuantity < 10) {
                cartID = "HD0" + customerQuantity + 1;
            } else {
                cartID = "HD" + customerQuantity + 1;
            }
            String command = "insert into giohang values (?,?,'','')";
            PreparedStatement ps = DBConnect.getInstance().get(command);
            ps.setString(1,cartID);
            ps.setString(2,userID);

            int rowAffected = ps.executeUpdate();
            if (rowAffected > 0)
                result = true;
            else result = false;

            return result;
        } catch (SQLException | ClassNotFoundException e ) {
            e.printStackTrace();
            return false;
        }
    }
}
