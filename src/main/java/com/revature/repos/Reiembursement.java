package com.revature.repos;

import com.revature.models.Reimbursement;

import java.util.List;

public interface ReimbursementDAO {

    List<Reimbursement> findAll();
    int findAuthor(int reimbursementAuthor);
    boolean addDescription(String reimbursementDescription);
    boolean addStatus(int reimbursementStatusId);
    boolean addAmount(float reimbursementAmount);
    boolean addType(int reimbursementTypeId);
    boolean addTimeStamp(int reimbursementTimeStamp);



}
