package com.revature.repos;

import com.revature.models.Reimbursement;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDAOImpl implements ReimbursementDAO{


    @Override
    public List<Reimbursement> findAllReimbursement() {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM reimbursement;";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<Reimbursement> listReimb = new ArrayList<>();

            while(result.next()){
                Reimbursement reimb = new Reimbursement();
                reimb.setReimbursementId(result.getInt("reimb_id"));
                reimb.setReimbursementAmount(result.getFloat("reimb_amount"));
                reimb.setReimbursementSubmitted(result.getTimestamp("reimb_submitted"));
                reimb.setReimbursementResolved(result.getTimestamp("reimb_resolved"));
                reimb.setReimbursementDescription(result.getString("reimb_description"));
                reimb.setReimbursementAuthor(result.getInt("reimb_author"));
                reimb.setReimbursementResolver(result.getInt("reimb_resolver"));
                reimb.setReimbursementStatusId(result.getInt("reimb_status_id"));
                reimb.setReimbursementTypeId(result.getInt("reimb_type_id"));
                listReimb.add(reimb);
            }
            return listReimb;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Reimbursement>();
    }

    @Override
    public List<Reimbursement> findAllRequest() {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM reimbursement WHERE reimb_status_id = 1;";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<Reimbursement> listRequest = new ArrayList<>();

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
                listRequest.add(request);
            }
            return listRequest;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Reimbursement>();
    }

    @Override
    public int findAuthor(int id) { return id; }

    @Override
    public boolean addRequest(Reimbursement reimbursement) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author," +
                    " reimb_status_id, reimb_type_id) VALUES(?, ?, ?, ?, 1, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            int count = 0;
            ps.setFloat(++count, reimbursement.getReimbursementAmount());
            ps.setTimestamp(++count, reimbursement.getReimbursementSubmitted());
            ps.setString(++count, reimbursement.getReimbursementDescription());
            ps.setInt(++count, reimbursement.getReimbursementAuthor());
            ps.setInt(++count, reimbursement.getReimbursementTypeId());
            ps.execute();

            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateStatus(Reimbursement reimbursement) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "UPDATE reimbursement SET reimb_status_id = ? WHERE reimbursement_id = ? ;";

            PreparedStatement ps = conn.prepareStatement(sql);

            int count = 0;
            ps.setInt(++count, reimbursement.getReimbursementStatusId());
            ps.setInt(++count, reimbursement.getReimbursementId());
            ps.execute();

            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
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
