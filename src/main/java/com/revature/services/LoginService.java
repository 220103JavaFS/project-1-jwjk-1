package com.revature.services;

import com.revature.models.User;
import com.revature.repos.UserDAO;
import com.revature.repos.UserDAOImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;

public class LoginService {
    private static Encryptor encryptor = new Encryptor();
    private UserDAO userDAO = new UserDAOImpl();
    private static final Logger log = LoggerFactory.getLogger(LoginService.class);

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
                log.info(user.getUserName() + " logged in successfully.");
                return true;
            } else{
                log.info(user.getUserName() + " failed to login.");
                return false;
            }
        }else{
            return false;
        }
    }
}
