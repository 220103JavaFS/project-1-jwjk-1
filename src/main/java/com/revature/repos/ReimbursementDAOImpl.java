package com.revature.repos;

import com.revature.models.Reimbursement;

import java.util.List;

public class ReimbursementDAOImpl implements ReimbursementDAO{
    @Override
    public List<Reimbursement> findAll() {
        return null;
    }

    @Override
    public Reimbursement findAuthor( int id) {
        return null;
    }

    @Override
    public boolean addDescription(String description) {
        return false;
    }

    @Override
    public boolean addStatus(int Status) {
        return false;
    }

    @Override
    public boolean addAmount(float reimbursementAmount) {
        return false;
    }

    @Override
    public boolean addType(int reimbursementTypeId) {
        return false;
    }
}
