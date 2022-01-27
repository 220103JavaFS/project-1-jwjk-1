package com.revature.repos;

import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
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

    public int updateStatus(int Status) {
        return Status;

    }

    @Override
    public boolean addAmount(float reimbursementAmount) {
        return true;
    }

    @Override
    public boolean addType(int reimbursementTypeId) {
        return true;
    }

    @Override
    public Timestamp addTimeStamp(Timestamp reimbursementTimeStamp) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT reimbursement_resolved FROM reimbursement WHERE reimbursement_id = ? ;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setTimestamp(1, reimbursementTimeStamp);
        } catch (SQLException e) {
            e.printStackTrace();

            Reimbursement reimbursement = new Reimbursement();


        }

        return reimbursementTimeStamp;
    }

}
