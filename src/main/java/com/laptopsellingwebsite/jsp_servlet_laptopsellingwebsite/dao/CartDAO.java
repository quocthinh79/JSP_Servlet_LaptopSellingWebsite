package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.dao;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.CartInfo;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Product;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.db.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

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

    public ArrayList<CartInfo> getProductList (ArrayList<String> listProductID) {
        ArrayList<CartInfo> result = new ArrayList<CartInfo>();
        try {
            for (String id_product: listProductID) {
                String querry = "SELECT thongtinlaptop.MALAPTOP, thongtinlaptop.TENLAPTOP, thongtinlaptop.LINKHINH1, ctgh.SOLUONG, thongtinlaptop.GIABAN " +
                        "from thongtinlaptop join ctgh on thongtinlaptop.MALAPTOP = ctgh.MALAPTOP where thongtinlaptop.MALAPTOP = ?";
                PreparedStatement st = DBConnect.getInstance().get(querry);
                st.setString(1,id_product);

                ResultSet resultSet = st.executeQuery();

                while(resultSet.next()) {
                    CartInfo product = new CartInfo(resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3).toLowerCase(),
                            resultSet.getInt(4),
                            resultSet.getInt(5)
                            );
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

    public int getCost (String productID) {
        int result = 0;
        try {
            String querry = "select Giaban from thongtinlaptop where malaptop = ?";
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

    public int totalCost(int userID) {
        int result = 0;
            ArrayList<String> listProductID = getProductIDFromCartByUserID(userID);
            for(String productID: listProductID) {
                int cost = getCost(productID);
                int quantity = getProductQuantity(productID,userID);
                result+= cost*quantity;
            }
            return result;
    }

    public boolean updateCart(int userID, int totalCost) {
        boolean result = false;
        try {
            LocalDate dateNow = LocalDate.now();
            String getDateNow = "" + dateNow;
            String cartID = getCartID(userID);
            String command = "update giohang set giohang.trigia = ?, giohang.ngayxuatgiohang = ? where magiohang = ?";
            PreparedStatement ps = DBConnect.getInstance().get(command);
            ps.setInt(1,totalCost);
            ps.setString(2, getDateNow);
            ps.setString(3, cartID);
            int row = ps.executeUpdate();
            if (row > 0) result = true;
            ps.close();
            return result;


        } catch (SQLException | ClassNotFoundException e ) {
            e.printStackTrace();
            return result;
        }
    }

    public int getImportNumber(String productID) {
        int result = 0;
        try {
            String querry = "select slnhap from khohang where malaptop = ?";
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

    public int getExportNumber(String productID) {
        int result = 0;
        try {
            String querry = "select slxuat from khohang where malaptop = ?";
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

    public int getRemainNumber(String productID) {
        int result = 0;
        try {
            String querry = "select tonkho from khohang where malaptop = ?";
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

    public boolean updateWarehouse(String productID, int numOfExport, int numRemain) {
        boolean result = false;
        try {

            String command = "update khohang set khohang.slxuat = ?, khohang.tonkho = ?  where malaptop = ?";
            PreparedStatement ps = DBConnect.getInstance().get(command);
            ps.setInt(1,numOfExport);
            ps.setInt(2,numRemain);
            ps.setString(3, productID);
            int row = ps.executeUpdate();
            if (row > 0) result = true;
            ps.close();
            return result;


        } catch (SQLException | ClassNotFoundException e ) {
            e.printStackTrace();
            return result;
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

    public String getCartID(int userID) {
        String result = "";
        try {

            String command = "select magiohang from giohang where makh = ?";
            PreparedStatement ps = DBConnect.getInstance().get(command);
            ps.setInt(1,userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getString(1);
            }
            return result;
        } catch (SQLException | ClassNotFoundException e ) {
            e.printStackTrace();
            return result;
        }
    }

    public boolean insertProductToCart(String productID, int userID, int quantity) {
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

    public boolean updateProductQuantityByProductID(String productID, int userID, int quantityUpdated) {
        boolean result = false;
        try {
            String cartID = getCartID(userID);
            String command = "update ctgh set soluong = ? where magiohang = ? and malaptop = ?";
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

    public boolean removeProductFromCart(String productID, int userID) {
        boolean result = false;
        try {
            String cartID = getCartID(userID);
            String command = "DELETE FROM ctgh where magiohang = ? and malaptop = ?";
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

    public boolean insertCart(int userID) {
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
            ps.setInt(2,userID);

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

    public boolean isProductOnCart(String productID, int userID) {
        boolean check = false;
        try {
            ArrayList<String> result = new ArrayList<String>();
            String cartID = getCartID(userID);
            String command = "select * FROM ctgh where magiohang = ? and malaptop = ?";
            PreparedStatement ps = DBConnect.getInstance().get(command);
            ps.setString(1,cartID);
            ps.setString(2, productID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result.add(rs.getString(1));
            }
            for(String i: result) {
                if(i != null)
                    check = true;
                else check = false;
            }
            ps.close();
            rs.close();
            return check;

        } catch (SQLException | ClassNotFoundException e ) {
            e.printStackTrace();
            return false;
        }
    }

    public int getProductQuantity(String productID, int userID) {
        try {
            int result = 0;
            String cartID = getCartID(userID);
            String command = "select soluong FROM ctgh where magiohang = ? and malaptop = ?";
            PreparedStatement ps = DBConnect.getInstance().get(command);
            ps.setString(1,cartID);
            ps.setString(2, productID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                result = rs.getInt(1);
            }
            ps.close();
            rs.close();
            return result;

        } catch (SQLException | ClassNotFoundException e ) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean clearCart(int userID) {
        try {
            boolean result = false;
            String cartID = getCartID(userID);
            String command = "delete from ctgh where magiohang = ?";
            PreparedStatement ps = DBConnect.getInstance().get(command);
            ps.setString(1,cartID);
            int affectedRow = ps.executeUpdate();
            if(affectedRow > 1) {
                result = true;
            }

            return result;

        } catch (SQLException | ClassNotFoundException e ) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        CartDAO cartDAO = new CartDAO();
        System.out.println(cartDAO.getProductQuantity("450-2H0Y1PA",1));
        System.out.println(cartDAO.getCost("450-2H0Y1PA"));
        System.out.println(cartDAO.totalCost(1));
    }
}
