package com.revature.service;

import com.revature.models.Reimbursement;
import com.revature.repos.ReimbursementDAO;
import com.revature.services.ReimbursementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReimbursementServiceTest {
    private ReimbursementService testInstance;

    @Mock
    private ReimbursementDAO mockedDAO;

    public Reimbursement testReimb = new Reimbursement();

    @BeforeEach
    public void setUp(){
        testReimb = new Reimbursement(
                1,
                50.0F,
                Timestamp.valueOf("2022-01-03 12:00:00"),
                Timestamp.valueOf("2022-01-03 12:00:00"),
                "I had to do it",
                1,
                2,
                3,
                2
        );
        MockitoAnnotations.openMocks(this);
        List<Reimbursement> list = new ArrayList<Reimbursement>();
        list.add(testReimb);
        testInstance = new ReimbursementService();
        Mockito.when(mockedDAO.findAllReimbursement()).thenReturn(list);
        Mockito.when(mockedDAO.addRequest(testReimb)).thenReturn(true);
        Mockito.when(mockedDAO.updateStatus(testReimb)).thenReturn(true);
    }

    @Test
    public void testFindAllReimbursement(){
        assertEquals(testReimb, testInstance.findAllReimbursement());
    }

    @Test
    public void addRequest(){
        assertTrue(testInstance.addRequest(testReimb));
    }

    @Test
    public void updateRequest(){
        assertTrue(testInstance.updateStatus(testReimb));
    }
}
