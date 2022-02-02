package com.revature.repos;

import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;
import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestReimbursementDAOImpl {

//    private ReimbursementService testService;
//    private List<Reimbursement> list = new ArrayList<Reimbursement>();
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
//
//    @Mock
//    private ReimbursementDAO mockDAO;
//
//    @BeforeEach
//    public void setMockDAO(){
//        List<Reimbursement> mockList = new ArrayList<Reimbursement>();
//        mockList.add(testReimbursement);
//        list = mockList;
//
//        testReimbursement.setReimbursementId(1);
//        testReimbursement.setReimbursementAmount(5.0F);
//        MockitoAnnotations.openMocks(this);
//        testService = new ReimbursementService();
//        Mockito.when(mockDAO.ge)
//
//    }

    @Test
    @Order(1)
    void testFindALLReimbursement(){
        assertFalse(reimbursementDAO.findAllReimbursement().isEmpty());
    }


}


