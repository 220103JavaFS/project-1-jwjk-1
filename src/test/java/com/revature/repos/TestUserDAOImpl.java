package com.revature.repos;
import com.revature.models.User;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestUserDAOImpl {

    private static UserDAO userDAO = new UserDAOImpl();

    private static User testUser = new User(
            3, "superman", "6532ab18c681aa654ff29a49446f8227b39d577eb8812fdd210714070c8a69f2", "clark", "kent", "superman@dailyplanet.com", 2
    );

    @Test
    @Order(1)
    void testFindUserByUserName(){
        assertEquals(testUser, userDAO.findUserByUserName(testUser.getUserName()));
    }

    @Test
    @Order(2)
    void testFindUserByUserID(){
        assertEquals(testUser, userDAO.findUserByUserId(testUser.getUserID()));
    }

    @Test
    @Order(3)
    void testFindAllUsers(){
        assertEquals(testUser, userDAO.findAllUsers());
    }

}
