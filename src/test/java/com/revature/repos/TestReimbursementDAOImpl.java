package com.revature.repos;

import com.revature.models.Reimbursement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestReimbursementDAOImpl {

    private static ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();
    private static Reimbursement testReimbursement = new Reimbursement(
            3,
            7469,
            1234,
            567,
            "Jimmy's whatever",
            678,
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
    void testAddAmount() {
        assertTrue(reimbursementDAO.addAmount(testReimbursement.getReimbursementAmount()));
        }

     @Test
    void addType(){
        assertTrue(reimbursementDAO.addType(testReimbursement.getReimbursementTypeId()));
     }

}


