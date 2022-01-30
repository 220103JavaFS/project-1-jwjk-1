package com.revature.services;

import com.revature.models.User;
import com.revature.repos.UserDAO;
import com.revature.repos.UserDAOImpl;

import java.util.List;

public class UserService {

    private UserDAO userDAO = new UserDAOImpl();

    public List<User> findAllUsers(){
        return userDAO.findAllUsers();
    }

    public User findUserByUserName(String userName){
        return userDAO.findUserByUserName(userName);
    }

    public boolean employeeInfoUpdate(User user) {
        return userDAO.employeeInfoUpdate(user);
    }
}
