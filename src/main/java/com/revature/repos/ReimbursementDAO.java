package com.revature.repos;

import com.revature.models.Reimbursement;

import java.sql.Timestamp;
import java.util.List;

public interface ReimbursementDAO {

    List<Reimbursement> findAllReimbursement();
    List<Reimbursement> findAllRequest();

    boolean addRequest(Reimbursement reimbursement);
    boolean updateStatus(Reimbursement reimbursement);
    Timestamp addTimeStamp(Timestamp reimbursementTimeStamp);



}
