package com.revature.repos;

import com.revature.models.Reimbursement;
import org.junit.jupiter.api.*;

import java.sql.Timestamp;
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
    }


}