package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Product;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.dao.ProductDao;

import java.util.List;

public class ProductService {
    private static ProductService instance;

    private ProductService() {

    }

    public static ProductService getInstance() {
        if (instance == null) {
            instance = new ProductService();
        }
        return instance;
    }

    public List<Product> getAllProduct() {
        return ProductDao.getInstance().getAllProduct();
    }

    public List getAllProducer() {
        return ProductDao.getInstance().getAllProducer();
    }

    public List getTopProduct1(int num) {
        return ProductDao.getInstance().getTopProduct1(num);
    }

    public List getTopProductBestSeller(int num) {
        return ProductDao.getInstance().getTopProductBestSeller(num);
    }

    public List getProductManufacturer(String manufacturer) {
        return ProductDao.getInstance().getProductManufacturer(manufacturer);
    }

    public List getProducerWithID(String producer) {
        return ProductDao.getInstance().getProducerWithID(producer);
    }

    public List getProductWithID(String ID) {
        return ProductDao.getInstance().getProductWithID(ID);
    }

    public List getProductWithProducer(String producer) {
        return ProductDao.getInstance().getProductWithProducer(producer);
    }

    public List getTopProducer(int num) {
        return ProductDao.getInstance().getTopProducer(num);
    }

    public List sortWithPrice(int highPrice, int lowPrice) {
        return ProductDao.getInstance().sortWithPrice(highPrice, lowPrice);
    }

    public List sortPriceWithProducer(int highPrice, int lowPrice, String hangSX) {
        return ProductDao.getInstance().sortPriceWithProducer(highPrice, lowPrice, hangSX);
    }
}
