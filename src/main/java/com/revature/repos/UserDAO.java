package com.revature.repos;

import com.revature.models.User;

import java.util.List;

public interface UserDAO {

    List<User> findAllUsers();
    boolean updateUsername();
    boolean updatePassword();
    boolean updateEmail();

}
