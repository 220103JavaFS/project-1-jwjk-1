package com.revature.repos;

import com.revature.models.User;

import java.util.List;

public interface UserDAO {

    List<User> findAllUsers();
    User findUserByUserName(String userName);
    boolean updateUsername();
    boolean updatePassword();
    boolean updateEmail();

}
