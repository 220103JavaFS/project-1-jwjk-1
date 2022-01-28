package com.revature.repos;

import com.revature.models.Reimbursement;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.*;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class TestReimbursementDAOImpl {

    private static ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();
    private static Reimbursement testReimbursement = new Reimbursement(
            3,
            Timestamp.valueOf("2022-01-27 07:20:20.0"),
            Timestamp.valueOf("2022-01-28 08:10:00.0"),
            "Jimmy's whatever",
            4,
            1,
            1,
            1
    );
    // Timestamp causes testing problems because it is asked for when all is searched for
    // Other issues include ExceptionInInitializerError, Optional. or ElseGet, ArrayList,
    // ArrayList x2, and IlleagalArguemtExeception.  What is strange is I remember this test
    // passing yesterday or a few days ago.
    @Test
    void testFindALLReimbursement(){
        assertNull(reimbursementDAO.findAll());
        assertNotNull(reimbursementDAO.findAll());
    }

  //  @Test
  //  void testFindAuthor() {
  //  assertEquals(reimbursementDAO.findAuthor(testReimbursement.getReimbursementAuthor()));
  //  }
// This test sites the same issues as the first test.
    @Test
    void testAddDescriptionTrue() {
        assertTrue(reimbursementDAO.addDescription(testReimbursement.getReimbursementDescription()));
    }
// This test sites the same issues as the first test.
    @Test
    void testAddStatus() {

        assertFalse(reimbursementDAO.addStatus(testReimbursement.getReimbursementStatusId()));
    }
// This test sites the same issues as the first test.
    @Test
    void testAddAmount() {
        assertTrue(reimbursementDAO.addAmount(testReimbursement.getReimbursementAmount()));
        }
// This test sites the same issues as the first test.
     @Test
    void addType() {
         assertTrue(reimbursementDAO.addType(testReimbursement.getReimbursementTypeId()));
     }

}


