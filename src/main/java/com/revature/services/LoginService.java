package com.revature.services;

import com.revature.models.User;
import com.revature.repos.UserDAO;
import com.revature.repos.UserDAOImpl;

import java.security.NoSuchAlgorithmException;

public class LoginService {
    private static Encryptor encryptor = new Encryptor();
    private UserDAO userDAO = new UserDAOImpl();

    public LoginService(){

    }

    public LoginService(UserDAO userDAO) {

        this.userDAO = userDAO;
    }

    public boolean login(String username, String password) throws NoSuchAlgorithmException {
        User user = userDAO.findUserByUserName(username);
        if (user != null){
            String passwordCheck = encryptor.encoder(password);
            String encryptPassword = user.getPassword();
            if(encryptPassword.equals(passwordCheck)){
                return true;
            } else{
                System.out.println("Password doesn't match");
                return false;
            }
        }else{
            return false;
        }
    }
}
