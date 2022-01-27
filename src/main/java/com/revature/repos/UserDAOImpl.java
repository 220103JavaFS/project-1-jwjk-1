package com.revature.repos;

import com.revature.models.User;

import java.util.List;

public class UserDAOImpl implements UserDAO{


    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public boolean updateUsername() {
        return false;
    }

    @Override
    public boolean updatePassword() {
        return false;
    }

    @Override
    public boolean updateEmail() {
        return false;
    }
}
