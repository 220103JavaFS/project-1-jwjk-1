package com.revature.repos;

import com.revature.models.Reimbursement;

import java.util.List;

public class ReimbursementDAOImpl implements ReimbursementDAO{
    @Override
    public List<Reimbursement> findAll() {
        return null;
    }

    @Override
    public int findAuthor(int id) { return id; }

    @Override
    public boolean addDescription (String description) {return true; }

    @Override
    public boolean addStatus(int Status) {
        return false;
    }

    @Override
    public boolean addAmount(float reimbursementAmount) {
        return true;
    }

    @Override
    public boolean addType(int reimbursementTypeId) {
        return true;
    }
}
