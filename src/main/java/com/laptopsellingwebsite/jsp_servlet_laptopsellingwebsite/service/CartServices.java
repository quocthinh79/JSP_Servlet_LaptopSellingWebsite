package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.dao.CartDAO;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.dao.ProductDao;

import java.util.List;

public class CartServices {
    private static CartServices instance;
    private CartServices() {

    }

    public static CartServices getInstance() {
        if (instance == null) {
            instance = new CartServices();
        }
        return instance;
    }

    public boolean insertCart(String userID) {
        return CartDAO.getInstance().insertCart(userID);
    }
    public boolean insertProductToCart(String productID, String userID, int quantity) {
        return CartDAO.getInstance().insertProductToCart(productID, userID, quantity);
    }

    public boolean updateProductQuantityToCart(String productID, String userID, int quantity) {
        return CartDAO.getInstance().updateProductQuantityByProductID(productID, userID, quantity);
    }

    public boolean removeProductFromCart(String productID, String userID) {
        return CartDAO.getInstance().removeProductFromCart(productID, userID);
    }
}
