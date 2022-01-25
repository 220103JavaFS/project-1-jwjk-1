package com.revature.repos;

import com.revature.models.Reimbursement;

import java.util.List;

public interface ReimbursementDAO {

    List<Reimbursement> findAll();
    Reimbursement findAuthor(int reimbursementAuthor);
    boolean addDescription(String reimbursementDescription);
    boolean addStatus(int reimbursementStatusId);
    boolean addAmount(float reimbursementAmount);
    boolean addType(int reimbursementTypeId);



}
