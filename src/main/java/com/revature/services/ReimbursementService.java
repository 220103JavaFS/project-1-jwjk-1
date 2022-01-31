package com.revature.services;

import com.revature.models.Reimbursement;
import com.revature.repos.ReimbursementDAO;
import com.revature.repos.ReimbursementDAOImpl;

import java.util.List;

public class ReimbursementService {
    private ReimbursementDAO reimbursementDAO = new ReimbursementDAOImpl();

    public List<Reimbursement> findAllReimbursement(){
        return reimbursementDAO.findAllReimbursement();
    }

    public List<Reimbursement> findAllRequest(){
        return reimbursementDAO.findAllRequest();
    }

    public List<Reimbursement> viewPastRequests(int authorId) {
        return reimbursementDAO.viewPastRequests(authorId);
    }

    public boolean addRequest(Reimbursement reimbursement) {
        return reimbursementDAO.addRequest(reimbursement);
    }

    public boolean updateStatus(Reimbursement reimbursement){
        return reimbursementDAO.updateStatus(reimbursement);
    }
}
