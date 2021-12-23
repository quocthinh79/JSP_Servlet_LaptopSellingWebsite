package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.dao;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Manufacturer;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Product;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.db.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {
    private static ProductDao instance;
    ArrayList<Manufacturer> listProducer;
    int count = 0;


    public static ProductDao getInstance() {
        if (instance == null) {
            instance = new ProductDao();
        }
        return instance;
    }

//    public List<Product> getAllProduct(){
//        return JDBIConnection.get().withHandle(handle -> {
//           return handle.createQuery("select * from thongtinlaptop").mapToBean(Product.class).stream().collect(Collectors.toList());
//        });
//    }

    public ArrayList getAllProduct() {
        ArrayList<Product> listResult = new ArrayList<>();
        try {
            String query = "select * from thongtinlaptop";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
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
                listResult.add(product);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listResult;
    }

    public ArrayList getAllProducer() {
        listProducer = new ArrayList<>();
        try {
            String query = "select * from hangsx";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Manufacturer produccer = new Manufacturer(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6));
                listProducer.add(produccer);
            }
            resultSet.close();
            ps.close();
            return listProducer;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList getTopProduct1(int num) {
        ArrayList<Product> listProduct = new ArrayList<>();
        try {
            for (Manufacturer x : listProducer) {
                String query = "select * from thongtinlaptop JOIN hangsx on HANG = TENHANG WHERE HANG = ? ORDER BY thongtinlaptop.GIABAN DESC LIMIT ?";
                PreparedStatement ps = DBConnect.getInstance().get(query);
                ps.setString(1, x.getTenHang());
                ps.setInt(2, num);
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
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
                    listProduct.add(product);
                }
            }
            return listProduct;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList getTopProductBestSeller(int num) {
        ArrayList<Product> listProductBestSeller = new ArrayList<>();
        try {
            for (Manufacturer x : listProducer) {
                String query = "select * from thongtinlaptop ORDER BY thongtinlaptop.GIABAN DESC LIMIT ?";
                PreparedStatement ps = DBConnect.getInstance().get(query);
                ps.setInt(1, num);
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
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
                    listProductBestSeller.add(product);
                }
            }
            return listProductBestSeller;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList getProductManufacturer(String manufacturer) {
        ArrayList<Product> listProductManufacturer = new ArrayList<>();
        try {
//            for (Manufacturer x : listProducer) {
            String query = "SELECT * FROM THONGTINLAPTOP WHERE HANG = ?";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setString(1, manufacturer);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
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
                listProductManufacturer.add(product);
            }
//            }
            return listProductManufacturer;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList getProducerWithID(String producer) {
        ArrayList<Manufacturer> listProducer = new ArrayList<>();
        try {
            String query = "SELECT * FROM HANGSX WHERE TENHANG = ?";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setString(1, producer);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Manufacturer produccer = new Manufacturer(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6));
                listProducer.add(produccer);
            }
            resultSet.close();
            ps.close();
            return listProducer;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList getProductWithID(String ID) {
        ArrayList<Product> listProductWithID = new ArrayList<>();
        try {
            String query = "SELECT * FROM THONGTINLAPTOP WHERE MALAPTOP = ?";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setString(1, ID);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
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
                listProductWithID.add(product);
            }
            resultSet.close();
            ps.close();
            return listProductWithID;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList getProductWithProducer(String producer) {
        ArrayList<Product> listProductWithID = new ArrayList<>();
        try {
            String query = "SELECT * FROM THONGTINLAPTOP WHERE HANG = ?";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setString(1, producer);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
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
                listProductWithID.add(product);
            }
            resultSet.close();
            ps.close();
            return listProductWithID;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList getTopProducer(int num) {
        ArrayList listTopProducer = new ArrayList<>();
        try {
            String query = "select * from hangsx limit ?";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setInt(1, num);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Manufacturer produccer = new Manufacturer(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6));
                listTopProducer.add(produccer);
            }
            resultSet.close();
            ps.close();
            return listTopProducer;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
