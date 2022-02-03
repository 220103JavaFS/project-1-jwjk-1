package com.revature.service;

import com.revature.models.User;
import com.revature.repos.UserDAO;
import com.revature.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {

    private UserService testInstance;

    @Mock
    private UserDAO mockedDAO;

    private User testUser = new User();

    @BeforeEach
    public void setUp(){
        testUser = new User(
                1, "user", "password", "first", "last", "email@email.com", 1
        );
        MockitoAnnotations.openMocks(this);
        testInstance = new UserService();
        Mockito.when(mockedDAO.findUserByUserName("user")).thenReturn(testUser);
    }

    @Test
    public void testFindUserByUserName(){
        assertEquals(testUser, testInstance.findUserByUserName(testUser.getUserName()));
    }
}
