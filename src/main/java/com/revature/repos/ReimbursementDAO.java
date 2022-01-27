package com.revature.repos;

import com.revature.models.Reimbursement;

import java.sql.Timestamp;
import java.util.List;

public interface ReimbursementDAO {

    List<Reimbursement> findAll();

    int findAuthor(int reimbursementAuthor);
    boolean addDescription(String reimbursementDescription);
    boolean addStatus(int reimbursementStatusId);
    int updateStatus(int reimbursementStatusId);
    boolean addAmount(float reimbursementAmount);
    boolean addType(int reimbursementTypeId);
    Timestamp addTimeStamp(Timestamp reimbursementTimeStamp);



}
