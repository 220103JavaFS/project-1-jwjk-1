package com.revature.repos;

import com.revature.models.Reimbursement;
<<<<<<< HEAD
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.User;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;
=======
import com.revature.services.ReimbursementService;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
>>>>>>> cec312df3bb6da6e27df2258654eb9d1a4c62ae8
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.*;
import java.sql.Timestamp;
<<<<<<< HEAD
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

public class TestReimbursementDAOImpl {

    @Mock
    private static ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();
    private static Reimbursement testReimbursement = new Reimbursement(
            2,
            500.0f,
            0000000,
            0000000,
            "car rental to report on the meteroplis football playoffs game",
            1,
            2,
            2,
            1
            );

    @Test
    @Order(1)
    public void testFindAllReimbursement(){

        assertEquals(reimbursementDAO.findAllReimbursement(), testReimbursement);
=======
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestReimbursementDAOImpl {

//    private ReimbursementService testService;
    private List<Reimbursement> list = new ArrayList<Reimbursement>();
    private static ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();
    private static Reimbursement testReimbursement = new Reimbursement(

            1,
            5.0F,
            Timestamp.valueOf("2022-01-21 07:40:00.0"),
            Timestamp.valueOf("2022-01-21 07:45:00.0"),
            "coffee on my way to a story",
            2,
            1,
            2,
            1

    );

    @Test
    @Order(1)
    void testFindALLReimbursement(){
        assertFalse(reimbursementDAO.findAllReimbursement().isEmpty());
    }

    @Test
    @Order(2)
    void testAddRequest(){
        assertTrue(reimbursementDAO.addRequest(testReimbursement));
    }

    @Test
    @Order(4)
    void testUpdateRequest(){
        assertTrue(reimbursementDAO.updateStatus(testReimbursement));
>>>>>>> cec312df3bb6da6e27df2258654eb9d1a4c62ae8
    }

}

    @Test
    @Order(2)
    public void testFindAllRequest(){
        assertEquals(reimbursementDAO.findAllRequest(),testReimbursement);
}

    @Test
    @Order(3)
    public void testViewPastRequests(){
        assertEquals(reimbursementDAO.viewPastRequests(),testReimbursement);
}

    @Test
    @Order(4)
    public void testAddRequest(){
        assertEquals(reimbursementDAO.addRequest(), testReimbursement);
    }

    @Test
    @Order(5)
    public void testUpdateStatus(){
        assertEquals(reimbursementDAO.updateStatus(),testReimbursement);
    }

}


