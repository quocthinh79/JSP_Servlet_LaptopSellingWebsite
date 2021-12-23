package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Product;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.dao.ProductDao;

import java.util.List;

public class ProductService {
    private static ProductService instance;

    public static ProductService getInstance(){
        if (instance == null){
            instance = new ProductService();
        }
        return instance;
    }

    private ProductService() {

    }

    public List<Product> getAllProduct(){
        return ProductDao.getInstance().getAllProduct();
    }

    public List getAllProducer(){
        return ProductDao.getInstance().getAllProducer();
    }

    public List getTopProduct1(int num){
        return ProductDao.getInstance().getTopProduct1(num);
    }

    public List getTopProductBestSeller(int num){
        return ProductDao.getInstance().getTopProductBestSeller(num);
    }

    public List getProductManufacturer(String manufacturer){
        return ProductDao.getInstance().getProductManufacturer(manufacturer);
    }

    public List getProducerWithID(String producer){
        return ProductDao.getInstance().getProducerWithID(producer);
    }

    public List getProductWithID(String ID){
        return ProductDao.getInstance().getProductWithID(ID);
    }

    public List getProductWithProducer(String producer){
        return ProductDao.getInstance().getProductWithProducer(producer);
    }
    public List getTopProducer(int num){
        return ProductDao.getInstance().getTopProducer(num);
    }
}
