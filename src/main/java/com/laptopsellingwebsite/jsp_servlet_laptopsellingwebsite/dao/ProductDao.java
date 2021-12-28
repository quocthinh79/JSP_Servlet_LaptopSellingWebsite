package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.dao;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Manufacturer;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Product;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.db.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import static java.util.stream.Collectors.joining;

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

    public ArrayList getAllProduct(int limit, int page) {
        ArrayList<Product> listResult = new ArrayList<>();
        try {
            int offset = (page - 1) * limit;
            String query = "select * from thongtinlaptop LIMIT " + limit + " OFFSET " + offset;
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
            return listResult;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getTotalPage() {
        try {
            String query = "select count(*) as total from thongtinlaptop";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            return resultSet.getInt("total");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

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

    public ArrayList getAllProduct(String temp) {
        ArrayList<Product> listResult = new ArrayList<>();
        try {
            String query;
            if (temp != null) {
                query = "select * from thongtinlaptop" + " ORDER BY GIABAN " + temp;
            } else {
                query = "select * from thongtinlaptop";
            }
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

    public ArrayList getProductManufacturer(String manufacturer, int limit, int page) {
        ArrayList<Product> listProductManufacturer = new ArrayList<>();
        try {
            int offset = (page - 1) * limit;
            String query = "SELECT * FROM THONGTINLAPTOP WHERE HANG = ? LIMIT " + limit + " OFFSET " + offset;
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

    public ArrayList getProductManufacturer(String manufacturer, String temp) {
        ArrayList<Product> listProductManufacturer = new ArrayList<>();
        try {
            String query;
            if (temp != null) {
                query = "SELECT * FROM THONGTINLAPTOP WHERE HANG = ?" + " ORDER BY GIABAN " + temp;
            } else {
                query = "SELECT * FROM THONGTINLAPTOP WHERE HANG = ?";
            }
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

    public ArrayList sortWithPrice(int highPrice, int lowPrice) {
        ArrayList result = new ArrayList();
        try {
            String query = "select * from THONGTINLAPTOP WHERE GIABAN BETWEEN ? and ?";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setInt(1, lowPrice);
            ps.setInt(2, highPrice);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16),
                        rs.getString(17),
                        rs.getString(18),
                        rs.getString(19));
                result.add(product);
            }
            return result;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList sortPriceWithProducer(int highPrice, int lowPrice, String hangSX) {
        ArrayList result = new ArrayList();
        try {
            String query = "select * from THONGTINLAPTOP WHERE HANG = ? AND GIABAN BETWEEN ? and ?";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setString(1, hangSX);
            ps.setInt(2, lowPrice);
            ps.setInt(3, highPrice);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16),
                        rs.getString(17),
                        rs.getString(18),
                        rs.getString(19));
                result.add(product);
            }
            return result;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Product> sortProduct(Map<String, String> map, String temp) {
        ArrayList<Product> result = new ArrayList();
        try {
            String joinString = map.entrySet().stream()
                    .map(e -> (!e.getKey().equalsIgnoreCase("GIABAN")) ?
                            (e.getKey() + " IN " + "(" + e.getValue() + ")") :
                            (e.getKey() + " BETWEEN " + e.getValue()))
                    .collect(joining(" AND "));
            String query = "";
            if (!joinString.equals("")) {
                query = "select * from THONGTINLAPTOP " + "WHERE" + " %s " + " ORDER BY GIABAN " + temp;
            } else {
                query = "select * from THONGTINLAPTOP " + " ORDER BY GIABAN " + temp;
            }
            String sqlQuery = String.format(query, joinString);
            PreparedStatement ps = DBConnect.getInstance().get(sqlQuery);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16),
                        rs.getString(17),
                        rs.getString(18),
                        rs.getString(19));
                result.add(product);
            }
            return result;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Product> sortProductWithProducer(Map<String, String> map, String hangsx) {
        ArrayList<Product> result = new ArrayList();
        try {
            hangsx = "'" + hangsx + "'";
            String query = "";
            String joinString = map.entrySet().stream()
                    .map(e -> (!e.getKey().equalsIgnoreCase("GIABAN")) ?
                            (e.getKey() + " IN " + "(" + e.getValue() + ")") :
                            (e.getKey() + " BETWEEN " + e.getValue()))
                    .collect(joining(" AND "));
            if (!joinString.equals("")) {
                query = "select * from THONGTINLAPTOP " + "WHERE HANG = " + hangsx + " AND %s " + " ORDER BY GIABAN ";
            } else {
                query = "select * from THONGTINLAPTOP " + "WHERE HANG = " + hangsx + " ORDER BY GIABAN ";
            }
            String sqlQuery = String.format(query, joinString);
            PreparedStatement ps = DBConnect.getInstance().get(sqlQuery);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16),
                        rs.getString(17),
                        rs.getString(18),
                        rs.getString(19));
                result.add(product);
            }
            return result;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Product> sortProductWithProducer(Map<String, String> map, String hangsx, String temp) {
        ArrayList<Product> result = new ArrayList();
        try {
//            hangsx = "'" + hangsx + "'";
//            String query;
//            if (temp != null) {
//                query = "select * from THONGTINLAPTOP WHERE HANG = " + hangsx + " AND %s " + " ORDER BY GIABAN " + temp;
//            } else {
//                query = "select * from THONGTINLAPTOP WHERE HANG = " + hangsx + " AND %s";
//            }
//            String joinString;
//            joinString = map.entrySet().stream().map(e -> e.getKey() + " IN " + "(" + e.getValue() + ")").collect(joining(" AND "));

            hangsx = "'" + hangsx + "'";
            String query = "";
            String joinString = map.entrySet().stream()
                    .map(e -> (!e.getKey().equalsIgnoreCase("GIABAN")) ?
                            (e.getKey() + " IN " + "(" + e.getValue() + ")") :
                            (e.getKey() + " BETWEEN " + e.getValue()))
                    .collect(joining(" AND "));
            if (!joinString.equals("")) {
                query = "select * from THONGTINLAPTOP " + "WHERE HANG = " + hangsx + " AND %s " + " ORDER BY GIABAN " + temp;
            } else {
                query = "select * from THONGTINLAPTOP " + "WHERE HANG = " + hangsx + " ORDER BY GIABAN " + temp;
            }
            String sqlQuery = String.format(query, joinString);
            PreparedStatement ps = DBConnect.getInstance().get(sqlQuery);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16),
                        rs.getString(17),
                        rs.getString(18),
                        rs.getString(19));
                result.add(product);
            }
            return result;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

        public int getTotalPageByProducer(String producer) {
        try {
            String query = "select count(*) as total from thongtinlaptop where hang = ?";
            PreparedStatement ps = DBConnect.getInstance().get(query);
            ps.setString(1, producer);
            ResultSet resultSet = ps.executeQuery();
            resultSet.next();
            return resultSet.getInt("total");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}


//package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.dao;
//
//import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Manufacturer;
//import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Product;
//import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.db.DBConnect;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Map;
//
//import static java.util.stream.Collectors.joining;
//
//public class ProductDao {
//    private static ProductDao instance;
//    ArrayList<Manufacturer> listProducer;
//    int count = 0;
//
//
//    public static ProductDao getInstance() {
//        if (instance == null) {
//            instance = new ProductDao();
//        }
//        return instance;
//    }
//
////    public List<Product> getAllProduct(){
////        return JDBIConnection.get().withHandle(handle -> {
////           return handle.createQuery("select * from thongtinlaptop").mapToBean(Product.class).stream().collect(Collectors.toList());
////        });
////    }
//
//    public ArrayList getAllProduct(int limit, int page) {
//        ArrayList<Product> listResult = new ArrayList<>();
//        try {
//            int offset = (page - 1) * limit;
//            String query = "select * from thongtinlaptop LIMIT " + limit + " OFFSET " + offset;
//            PreparedStatement ps = DBConnect.getInstance().get(query);
//            ResultSet resultSet = ps.executeQuery();
//            while (resultSet.next()) {
//                Product product = new Product(resultSet.getString(1),
//                        resultSet.getString(2),
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
//                        resultSet.getString(15),
//                        resultSet.getString(16),
//                        resultSet.getString(17),
//                        resultSet.getString(18),
//                        resultSet.getString(19));
//                listResult.add(product);
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return listResult;
//    }
//
//    public int getTotalPage() {
//        try {
//            String query = "select count(*) as total from thongtinlaptop";
//            PreparedStatement ps = DBConnect.getInstance().get(query);
//            ResultSet resultSet = ps.executeQuery();
//            resultSet.next();
//            return resultSet.getInt("total");
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
//
//    public ArrayList getAllProduct() {
//        ArrayList<Product> listResult = new ArrayList<>();
//        try {
//            String query = "select * from thongtinlaptop";
//            PreparedStatement ps = DBConnect.getInstance().get(query);
//            ResultSet resultSet = ps.executeQuery();
//            while (resultSet.next()) {
//                Product product = new Product(resultSet.getString(1),
//                        resultSet.getString(2),
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
//                        resultSet.getString(15),
//                        resultSet.getString(16),
//                        resultSet.getString(17),
//                        resultSet.getString(18),
//                        resultSet.getString(19));
//                listResult.add(product);
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return listResult;
//    }
//
//    public ArrayList getAllProduct(String temp, int limit, int page) {
//        ArrayList<Product> listResult = new ArrayList<>();
//        try {
//            int offset = (page - 1) * limit;
//            String query;
//            if (temp != null) {
//                query = "select * from thongtinlaptop" + " ORDER BY GIABAN " + temp + " LIMIT " + limit + " OFFSET " + offset;
//            } else {
//                query = "select * from thongtinlaptop";
//            }
//            PreparedStatement ps = DBConnect.getInstance().get(query);
//            ResultSet resultSet = ps.executeQuery();
//            while (resultSet.next()) {
//                Product product = new Product(resultSet.getString(1),
//                        resultSet.getString(2),
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
//                        resultSet.getString(15),
//                        resultSet.getString(16),
//                        resultSet.getString(17),
//                        resultSet.getString(18),
//                        resultSet.getString(19));
//                listResult.add(product);
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return listResult;
//    }
//
//    public ArrayList getAllProducer() {
//        listProducer = new ArrayList<>();
//        try {
//            String query = "select * from hangsx";
//            PreparedStatement ps = DBConnect.getInstance().get(query);
//            ResultSet resultSet = ps.executeQuery();
//            while (resultSet.next()) {
//                Manufacturer produccer = new Manufacturer(resultSet.getString(1),
//                        resultSet.getString(2),
//                        resultSet.getString(3),
//                        resultSet.getString(4),
//                        resultSet.getString(5),
//                        resultSet.getString(6));
//                listProducer.add(produccer);
//            }
//            resultSet.close();
//            ps.close();
//            return listProducer;
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public ArrayList getTopProduct1(int num) {
//        ArrayList<Product> listProduct = new ArrayList<>();
//        try {
//            for (Manufacturer x : listProducer) {
//                String query = "select * from thongtinlaptop JOIN hangsx on HANG = TENHANG WHERE HANG = ? ORDER BY thongtinlaptop.GIABAN DESC LIMIT ?";
//                PreparedStatement ps = DBConnect.getInstance().get(query);
//                ps.setString(1, x.getTenHang());
//                ps.setInt(2, num);
//                ResultSet resultSet = ps.executeQuery();
//                while (resultSet.next()) {
//                    Product product = new Product(resultSet.getString(1),
//                            resultSet.getString(2),
//                            resultSet.getString(3),
//                            resultSet.getInt(4),
//                            resultSet.getString(5),
//                            resultSet.getString(6),
//                            resultSet.getString(7),
//                            resultSet.getString(8),
//                            resultSet.getString(9),
//                            resultSet.getString(10),
//                            resultSet.getString(11),
//                            resultSet.getString(12),
//                            resultSet.getString(13),
//                            resultSet.getString(14),
//                            resultSet.getString(15),
//                            resultSet.getString(16),
//                            resultSet.getString(17),
//                            resultSet.getString(18),
//                            resultSet.getString(19));
//                    listProduct.add(product);
//                }
//            }
//            return listProduct;
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public ArrayList getTopProductBestSeller(int num) {
//        ArrayList<Product> listProductBestSeller = new ArrayList<>();
//        try {
//            for (Manufacturer x : listProducer) {
//                String query = "select * from thongtinlaptop ORDER BY thongtinlaptop.GIABAN DESC LIMIT ?";
//                PreparedStatement ps = DBConnect.getInstance().get(query);
//                ps.setInt(1, num);
//                ResultSet resultSet = ps.executeQuery();
//                while (resultSet.next()) {
//                    Product product = new Product(resultSet.getString(1),
//                            resultSet.getString(2),
//                            resultSet.getString(3),
//                            resultSet.getInt(4),
//                            resultSet.getString(5),
//                            resultSet.getString(6),
//                            resultSet.getString(7),
//                            resultSet.getString(8),
//                            resultSet.getString(9),
//                            resultSet.getString(10),
//                            resultSet.getString(11),
//                            resultSet.getString(12),
//                            resultSet.getString(13),
//                            resultSet.getString(14),
//                            resultSet.getString(15),
//                            resultSet.getString(16),
//                            resultSet.getString(17),
//                            resultSet.getString(18),
//                            resultSet.getString(19));
//                    listProductBestSeller.add(product);
//                }
//            }
//            return listProductBestSeller;
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public ArrayList getProductManufacturer(String manufacturer) {
//        ArrayList<Product> listProductManufacturer = new ArrayList<>();
//        try {
//            String query = "SELECT * FROM THONGTINLAPTOP WHERE HANG = ?";
//            PreparedStatement ps = DBConnect.getInstance().get(query);
//            ps.setString(1, manufacturer);
//            ResultSet resultSet = ps.executeQuery();
//            while (resultSet.next()) {
//                Product product = new Product(resultSet.getString(1),
//                        resultSet.getString(2),
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
//                        resultSet.getString(15),
//                        resultSet.getString(16),
//                        resultSet.getString(17),
//                        resultSet.getString(18),
//                        resultSet.getString(19));
//                listProductManufacturer.add(product);
//            }
////            }
//            return listProductManufacturer;
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public ArrayList getProductManufacturer(String manufacturer, int limit, int page) {
//        ArrayList<Product> listProductManufacturer = new ArrayList<>();
//        try {
//            int offset = (page - 1) * limit;
//            String query = "SELECT * FROM THONGTINLAPTOP WHERE HANG = ? LIMIT " + limit + " OFFSET " + offset;
//            PreparedStatement ps = DBConnect.getInstance().get(query);
//            ps.setString(1, manufacturer);
//            ResultSet resultSet = ps.executeQuery();
//            while (resultSet.next()) {
//                Product product = new Product(resultSet.getString(1),
//                        resultSet.getString(2),
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
//                        resultSet.getString(15),
//                        resultSet.getString(16),
//                        resultSet.getString(17),
//                        resultSet.getString(18),
//                        resultSet.getString(19));
//                listProductManufacturer.add(product);
//            }
////            }
//            return listProductManufacturer;
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public int getTotalPageByProducer(String producer) {
//        try {
//            String query = "select count(*) as total from thongtinlaptop where hang = ?";
//            PreparedStatement ps = DBConnect.getInstance().get(query);
//            ps.setString(1, producer);
//            ResultSet resultSet = ps.executeQuery();
//            resultSet.next();
//            return resultSet.getInt("total");
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
//
//    public ArrayList getProductManufacturer(String manufacturer, String temp, int limit, int page) {
//        ArrayList<Product> listProductManufacturer = new ArrayList<>();
//        try {
//            int offset = (page - 1) * limit;
//            String query;
//            if (temp != null) {
//                query = "SELECT * FROM THONGTINLAPTOP WHERE HANG = ?" + " ORDER BY GIABAN " + " LIMIT " + limit + " OFFSET " + offset;
//            } else {
//                query = "SELECT * FROM THONGTINLAPTOP WHERE HANG = ?";
//            }
//            PreparedStatement ps = DBConnect.getInstance().get(query);
//            ps.setString(1, manufacturer);
//            ResultSet resultSet = ps.executeQuery();
//            while (resultSet.next()) {
//                Product product = new Product(resultSet.getString(1),
//                        resultSet.getString(2),
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
//                        resultSet.getString(15),
//                        resultSet.getString(16),
//                        resultSet.getString(17),
//                        resultSet.getString(18),
//                        resultSet.getString(19));
//                listProductManufacturer.add(product);
//            }
////            }
//            return listProductManufacturer;
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public ArrayList getProducerWithID(String producer) {
//        ArrayList<Manufacturer> listProducer = new ArrayList<>();
//        try {
//            String query = "SELECT * FROM HANGSX WHERE TENHANG = ?";
//            PreparedStatement ps = DBConnect.getInstance().get(query);
//            ps.setString(1, producer);
//            ResultSet resultSet = ps.executeQuery();
//            while (resultSet.next()) {
//                Manufacturer produccer = new Manufacturer(resultSet.getString(1),
//                        resultSet.getString(2),
//                        resultSet.getString(3),
//                        resultSet.getString(4),
//                        resultSet.getString(5),
//                        resultSet.getString(6));
//                listProducer.add(produccer);
//            }
//            resultSet.close();
//            ps.close();
//            return listProducer;
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public ArrayList getProductWithID(String ID) {
//        ArrayList<Product> listProductWithID = new ArrayList<>();
//        try {
//            String query = "SELECT * FROM THONGTINLAPTOP WHERE MALAPTOP = ?";
//            PreparedStatement ps = DBConnect.getInstance().get(query);
//            ps.setString(1, ID);
//            ResultSet resultSet = ps.executeQuery();
//            while (resultSet.next()) {
//                Product product = new Product(resultSet.getString(1),
//                        resultSet.getString(2),
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
//                        resultSet.getString(15),
//                        resultSet.getString(16),
//                        resultSet.getString(17),
//                        resultSet.getString(18),
//                        resultSet.getString(19));
//                listProductWithID.add(product);
//            }
//            resultSet.close();
//            ps.close();
//            return listProductWithID;
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public ArrayList getProductWithProducer(String producer) {
//        ArrayList<Product> listProductWithID = new ArrayList<>();
//        try {
//            String query = "SELECT * FROM THONGTINLAPTOP WHERE HANG = ?";
//            PreparedStatement ps = DBConnect.getInstance().get(query);
//            ps.setString(1, producer);
//            ResultSet resultSet = ps.executeQuery();
//            while (resultSet.next()) {
//                Product product = new Product(resultSet.getString(1),
//                        resultSet.getString(2),
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
//                        resultSet.getString(15),
//                        resultSet.getString(16),
//                        resultSet.getString(17),
//                        resultSet.getString(18),
//                        resultSet.getString(19));
//                listProductWithID.add(product);
//            }
//            resultSet.close();
//            ps.close();
//            return listProductWithID;
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public ArrayList getTopProducer(int num) {
//        ArrayList listTopProducer = new ArrayList<>();
//        try {
//            String query = "select * from hangsx limit ?";
//            PreparedStatement ps = DBConnect.getInstance().get(query);
//            ps.setInt(1, num);
//            ResultSet resultSet = ps.executeQuery();
//            while (resultSet.next()) {
//                Manufacturer produccer = new Manufacturer(resultSet.getString(1),
//                        resultSet.getString(2),
//                        resultSet.getString(3),
//                        resultSet.getString(4),
//                        resultSet.getString(5),
//                        resultSet.getString(6));
//                listTopProducer.add(produccer);
//            }
//            resultSet.close();
//            ps.close();
//            return listTopProducer;
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public ArrayList sortWithPrice(int highPrice, int lowPrice) {
//        ArrayList result = new ArrayList();
//        try {
//            String query = "select * from THONGTINLAPTOP WHERE GIABAN BETWEEN ? and ?";
//            PreparedStatement ps = DBConnect.getInstance().get(query);
//            ps.setInt(1, lowPrice);
//            ps.setInt(2, highPrice);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Product product = new Product(rs.getString(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getInt(4),
//                        rs.getString(5),
//                        rs.getString(6),
//                        rs.getString(7),
//                        rs.getString(8),
//                        rs.getString(9),
//                        rs.getString(10),
//                        rs.getString(11),
//                        rs.getString(12),
//                        rs.getString(13),
//                        rs.getString(14),
//                        rs.getString(15),
//                        rs.getString(16),
//                        rs.getString(17),
//                        rs.getString(18),
//                        rs.getString(19));
//                result.add(product);
//            }
//            return result;
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public ArrayList sortPriceWithProducer(int highPrice, int lowPrice, String hangSX) {
//        ArrayList result = new ArrayList();
//        try {
//            String query = "select * from THONGTINLAPTOP WHERE HANG = ? AND GIABAN BETWEEN ? and ?";
//            PreparedStatement ps = DBConnect.getInstance().get(query);
//            ps.setString(1, hangSX);
//            ps.setInt(2, lowPrice);
//            ps.setInt(3, highPrice);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Product product = new Product(rs.getString(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getInt(4),
//                        rs.getString(5),
//                        rs.getString(6),
//                        rs.getString(7),
//                        rs.getString(8),
//                        rs.getString(9),
//                        rs.getString(10),
//                        rs.getString(11),
//                        rs.getString(12),
//                        rs.getString(13),
//                        rs.getString(14),
//                        rs.getString(15),
//                        rs.getString(16),
//                        rs.getString(17),
//                        rs.getString(18),
//                        rs.getString(19));
//                result.add(product);
//            }
//            return result;
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public int totalPageSort(Map<String, String> map){
//        try {
//            String joinString = map.entrySet().stream()
//                    .map(e -> (!e.getKey().equalsIgnoreCase("GIABAN")) ?
//                            (e.getKey() + " IN " + "(" + e.getValue() + ")") :
//                            (e.getKey() + " BETWEEN " + e.getValue()))
//                    .collect(joining(" AND "));
//            String query = "";
//            if (!joinString.equals("")) {
//                query = "select count(*) as total from THONGTINLAPTOP " + "WHERE" + " %s ";
//            } else {
//                query = "select count(*) as total from THONGTINLAPTOP " + " ORDER BY GIABAN ";
//            }
//            String sqlQuery = String.format(query, joinString);
//            PreparedStatement ps = DBConnect.getInstance().get(sqlQuery);
//            ResultSet rs = ps.executeQuery();
//            rs.next();
//            return  rs.getInt("total");
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
//
//    public int totalPageSortByProducer(Map<String, String> map, String producer){
//        try {
//            String joinString = map.entrySet().stream()
//                    .map(e -> (!e.getKey().equalsIgnoreCase("GIABAN")) ?
//                            (e.getKey() + " IN " + "(" + e.getValue() + ")") :
//                            (e.getKey() + " BETWEEN " + e.getValue()))
//                    .collect(joining(" AND "));
//            String query = "";
//            if (!joinString.equals("")) {
//                query = "select count(*) as total from THONGTINLAPTOP " + "WHERE HANG = " + producer + " AND %s ";
//            } else {
//                query = "select count(*) as total from THONGTINLAPTOP " + "WHERE HANG = " + producer;
//            }
//            String sqlQuery = String.format(query, joinString);
//            PreparedStatement ps = DBConnect.getInstance().get(sqlQuery);
//            ResultSet rs = ps.executeQuery();
//            rs.next();
//            System.out.println(rs.getInt("total"));
//            return  rs.getInt("total");
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
//
//    public ArrayList<Product> sortProduct(Map<String, String> map, String temp, int limit, int page) {
//        ArrayList<Product> result = new ArrayList();
//        try {
//            int offset = (page - 1) * limit;
//            String joinString = map.entrySet().stream()
//                    .map(e -> (!e.getKey().equalsIgnoreCase("GIABAN")) ?
//                            (e.getKey() + " IN " + "(" + e.getValue() + ")") :
//                            (e.getKey() + " BETWEEN " + e.getValue()))
//                    .collect(joining(" AND "));
//            String query = "";
//            if (!joinString.equals("")) {
//                query = "select * from THONGTINLAPTOP " + "WHERE" + " %s " + " ORDER BY GIABAN " + temp  + " LIMIT " + limit + " OFFSET " + offset;
//            } else {
//                query = "select * from THONGTINLAPTOP " + " ORDER BY GIABAN " + temp  + " LIMIT " + limit + " OFFSET " + offset;
//            }
//            String sqlQuery = String.format(query, joinString);
//            PreparedStatement ps = DBConnect.getInstance().get(sqlQuery);
//            System.out.println(ps.toString());
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Product product = new Product(rs.getString(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getInt(4),
//                        rs.getString(5),
//                        rs.getString(6),
//                        rs.getString(7),
//                        rs.getString(8),
//                        rs.getString(9),
//                        rs.getString(10),
//                        rs.getString(11),
//                        rs.getString(12),
//                        rs.getString(13),
//                        rs.getString(14),
//                        rs.getString(15),
//                        rs.getString(16),
//                        rs.getString(17),
//                        rs.getString(18),
//                        rs.getString(19));
//                result.add(product);
//            }
//            return result;
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public ArrayList<Product> sortProductWithProducer(Map<String, String> map, String hangsx) {
//        ArrayList<Product> result = new ArrayList();
//        try {
//            hangsx = "'" + hangsx + "'";
//            String query = "";
//            String joinString = map.entrySet().stream()
//                    .map(e -> (!e.getKey().equalsIgnoreCase("GIABAN")) ?
//                            (e.getKey() + " IN " + "(" + e.getValue() + ")") :
//                            (e.getKey() + " BETWEEN " + e.getValue()))
//                    .collect(joining(" AND "));
//            if (!joinString.equals("")) {
//                query = "select * from THONGTINLAPTOP " + "WHERE HANG = " + hangsx + " AND %s " + " ORDER BY GIABAN ";
//            } else {
//                query = "select * from THONGTINLAPTOP " + "WHERE HANG = " + hangsx + " ORDER BY GIABAN ";
//            }
//            String sqlQuery = String.format(query, joinString);
//            PreparedStatement ps = DBConnect.getInstance().get(sqlQuery);
//            System.out.println(ps.toString());
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Product product = new Product(rs.getString(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getInt(4),
//                        rs.getString(5),
//                        rs.getString(6),
//                        rs.getString(7),
//                        rs.getString(8),
//                        rs.getString(9),
//                        rs.getString(10),
//                        rs.getString(11),
//                        rs.getString(12),
//                        rs.getString(13),
//                        rs.getString(14),
//                        rs.getString(15),
//                        rs.getString(16),
//                        rs.getString(17),
//                        rs.getString(18),
//                        rs.getString(19));
//                result.add(product);
//            }
//            return result;
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public ArrayList<Product> sortProductWithProducer(Map<String, String> map, String hangsx, String temp, int limit, int page) {
//        ArrayList<Product> result = new ArrayList();
//        try {
////            hangsx = "'" + hangsx + "'";
////            String query;
////            if (temp != null) {
////                query = "select * from THONGTINLAPTOP WHERE HANG = " + hangsx + " AND %s " + " ORDER BY GIABAN " + temp;
////            } else {
////                query = "select * from THONGTINLAPTOP WHERE HANG = " + hangsx + " AND %s";
////            }
////            String joinString;
////            joinString = map.entrySet().stream().map(e -> e.getKey() + " IN " + "(" + e.getValue() + ")").collect(joining(" AND "));
//
//            int offset = (page - 1) * limit;
//            hangsx = "'" + hangsx + "'";
//            String query = "";
//            String joinString = map.entrySet().stream()
//                    .map(e -> (!e.getKey().equalsIgnoreCase("GIABAN")) ?
//                            (e.getKey() + " IN " + "(" + e.getValue() + ")") :
//                            (e.getKey() + " BETWEEN " + e.getValue()))
//                    .collect(joining(" AND "));
//            if (!joinString.equals("")) {
//                query = "select * from THONGTINLAPTOP " + "WHERE HANG = " + hangsx + " AND %s " + " ORDER BY GIABAN " + temp  + " LIMIT " + limit + " OFFSET " + offset;
//            } else {
//                query = "select * from THONGTINLAPTOP " + "WHERE HANG = " + hangsx + " ORDER BY GIABAN " + temp  + " LIMIT " + limit + " OFFSET " + offset;
//            }
//            String sqlQuery = String.format(query, joinString);
//            PreparedStatement ps = DBConnect.getInstance().get(sqlQuery);
//            System.out.println(ps.toString());
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Product product = new Product(rs.getString(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getInt(4),
//                        rs.getString(5),
//                        rs.getString(6),
//                        rs.getString(7),
//                        rs.getString(8),
//                        rs.getString(9),
//                        rs.getString(10),
//                        rs.getString(11),
//                        rs.getString(12),
//                        rs.getString(13),
//                        rs.getString(14),
//                        rs.getString(15),
//                        rs.getString(16),
//                        rs.getString(17),
//                        rs.getString(18),
//                        rs.getString(19));
//                result.add(product);
//            }
//            return result;
//        } catch (SQLException | ClassNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}
