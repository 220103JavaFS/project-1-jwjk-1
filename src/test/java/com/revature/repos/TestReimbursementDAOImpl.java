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

    @Test
    void testFindAuthor() {
        assertEquals(testReimbursement, reimbursementDAO.findAuthor(testReimbursement.getReimbursementAuthor()));
    }

//
//
//    public boolean addDescription(String reimbursementDescription) {
//        return false;
//    }
//
//
//    public boolean addStatus(int reimbursementStatusId) {
//        return false;
//    }
//
//
//    public boolean addAmount(float reimbursementAmount) {
//        return false;
//    }
//
//
//    public boolean addType(int reimbursementTypeId) {
//        return false;
//    }
}
