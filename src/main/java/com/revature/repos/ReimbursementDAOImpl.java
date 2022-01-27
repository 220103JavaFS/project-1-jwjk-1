package com.revature.repos;

import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDAOImpl implements ReimbursementDAO{
    @Override
    public List<Reimbursement> findAll() {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM reimbursement;";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<Reimbursement> list = new ArrayList<>();

            while(result.next()){
                Reimbursement reimbursement = new Reimbursement();
                reimbursement.setReimbursementId(result.getInt("reimb_id"));
                reimbursement.setReimbursementAmount(result.getFloat("reimb_amount"));
                reimbursement.setReimbursementSubmitted(result.getTimestamp("reimb_submitted"));
                reimbursement.setReimbursementResolved(result.getTimestamp("reimb_resolved"));
                reimbursement.setReimbursementDescription(result.getString("reimb_description"));
                reimbursement.setReimbursementAuthor(result.getInt("reimb_author"));
                reimbursement.setReimbursementResolver(result.getInt("reimb_resolver"));
                reimbursement.setReimbursementStatusId(result.getInt("reimb_status_id"));
                reimbursement.setReimbursementTypeId(result.getInt("reimb_type_id"));

                list.add(reimbursement);
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public List<Reimbursement> findAllRequest() {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM reimbursement WHERE reimb_status_id = 1;";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<Reimbursement> list = new ArrayList<>();

            while(result.next()){
                Reimbursement request = new Reimbursement();
                request.setReimbursementId(result.getInt("reimb_id"));
                request.setReimbursementAmount(result.getFloat("reimb_amount"));
                request.setReimbursementSubmitted(result.getTimestamp("reimb_submitted"));
                request.setReimbursementResolved(result.getTimestamp("reimb_resolved"));
                request.setReimbursementDescription(result.getString("reimb_description"));
                request.setReimbursementAuthor(result.getInt("reimb_author"));
                request.setReimbursementResolver(result.getInt("reimb_resolver"));
                request.setReimbursementStatusId(result.getInt("reimb_status_id"));
                request.setReimbursementTypeId(result.getInt("reimb_type_id"));

                list.add(request);
        }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }
            return new ArrayList<>();
        }

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
