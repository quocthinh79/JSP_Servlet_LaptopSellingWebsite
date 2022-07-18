package com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.service;

import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.beans.Account;
import com.laptopsellingwebsite.jsp_servlet_laptopsellingwebsite.dao.UserDao;

public class UserServices {

    public static Account getUser(String userName, String pass) {
        Account account = UserDao.getUser(userName, pass);
        return account;
    }

    public static boolean checkUser(String userName) {
        if (UserDao.checkUser(userName))
            return true;
        return false;
    }
}
