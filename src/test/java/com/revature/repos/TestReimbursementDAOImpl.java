package com.revature.repos;

import com.revature.models.Reimbursement;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;


public class TestReimbursementDAOImpl {

    private static ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();
    private static Reimbursement testReimbursement = new Reimbursement(
            3,
            Timestamp.valueOf("2022/01/27 07:20:20"),
            Timestamp.valueOf("2022/01/28 08:10:00"),
            "Jimmy's whatever",
            4,
            1,
            1,
            1
    );

    @Test
    void testFindALLReimbursement() {
        assertNull(reimbursementDAO.findAll());
    }

  //  @Test
  //  void testFindAuthor() {
  //  assertEquals(reimbursementDAO.findAuthor(testReimbursement.getReimbursementAuthor()));
  //  }

    @Test
    void testAddDescriptionTrue() {
        assertTrue(reimbursementDAO.addDescription(testReimbursement.getReimbursementDescription()));
    }

    @Test
    void testAddStatus() {

        assertFalse(reimbursementDAO.addStatus(testReimbursement.getReimbursementStatusId()));
    }

    @Test
    void testUpdateReimbursementStatus(){;
    }

    @Test
    void testAddAmount() {
        assertTrue(reimbursementDAO.addAmount(testReimbursement.getReimbursementAmount()));
        }

     @Test
    void addType(){
        assertTrue(reimbursementDAO.addType(testReimbursement.getReimbursementTypeId()));
     }

     @Test
    void addTimeStampResolved(){

     }

}


