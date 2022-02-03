package com.revature.service;

import com.revature.models.User;
import com.revature.repos.UserDAO;
import com.revature.services.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginServiceTest {

    private LoginService testInstance;

    @Mock
    private UserDAO mockedDAO;

    private User testUser = new User();

    @BeforeEach
    public void setUp(){
        testUser = new User(
          1, "USER", "64cb2cfd465ade22bd017da594b40f8722171417732fdc05e7dc7e681f9f8961", "Why", "Not", "now@gmail.com",2
        );
        MockitoAnnotations.openMocks(this);
        testInstance = new LoginService(mockedDAO);
        Mockito.when(mockedDAO.findUserByUserName("USER")).thenReturn(testUser);
    }

    @Test
    public void testLogin() throws NoSuchAlgorithmException {
        assertTrue(testInstance.login("USER", "planetmanager156"));
    }
    @Test
    public void testUserNameFail() throws NoSuchAlgorithmException {
        assertFalse(testInstance.login("USERFaield", "planetmanager156"));
    }

    @Test
    public void testPasswordFail() throws NoSuchAlgorithmException {
        assertFalse(testInstance.login("USER", "password"));
    }

}
