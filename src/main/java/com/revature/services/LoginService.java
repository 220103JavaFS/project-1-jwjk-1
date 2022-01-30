package com.revature.services;

import com.revature.models.User;
import com.revature.repos.UserDAO;
import com.revature.repos.UserDAOImpl;

public class LoginService {

    private UserDAO userDAO = new UserDAOImpl();

    public LoginService(){

    }

    public LoginService(UserDAO userDAO) {

        this.userDAO = userDAO;
    }

    public boolean login(String username, String password) {
        User user = userDAO.findUserByUserName(username);
        if (user != null && password.equals(user.getPassword())){
        return true;
    }else{
        return false;
        }
    }



}
