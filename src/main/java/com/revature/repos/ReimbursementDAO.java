package com.revature.repos;

import com.revature.models.User;

import java.util.List;

public interface ReimbursementDAO {

    List<User> findAll();
    User findAuthor(int id);
    boolean addDescription(String description);
    boolean addStatus(int Status);



}
