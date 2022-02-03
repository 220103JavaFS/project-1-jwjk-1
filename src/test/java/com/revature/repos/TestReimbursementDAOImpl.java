package com.revature.repos;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.User;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.*;
import java.sql.Timestamp;
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


