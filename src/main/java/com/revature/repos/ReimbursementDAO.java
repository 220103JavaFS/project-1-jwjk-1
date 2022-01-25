package com.revature.repos;

import com.revature.models.Reimbursement;

import java.util.List;

public interface ReimbursementDAO {

    List<Reimbursement> findAll();
    Reimbursement findAuthor(int id);
    boolean addDescription(String description);
    boolean addStatus(int Status);

}
