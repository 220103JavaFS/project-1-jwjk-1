package com.revature.repos;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDAOImpl implements ReimbursementDAO{
    private UserDAO userDAO = new UserDAOImpl();

    //Manager gets to see all the list of reimbursements.
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
                int author = result.getInt("reimb_author");
                if(author != 0){
                    User userAuthor = userDAO.findUserByUserId(author);
                    reimb.setReimbursementAuthor(userAuthor);
                }
                int resolver = result.getInt("reimb_resolver");
                if(resolver != 0){
                    User userResolver = userDAO.findUserByUserId(author);
                    reimb.setReimbursementResolver(userResolver);
                }
                ReimbursementStatus status = new ReimbursementStatus(result.getInt("reimb_status_id"),
                        result.getString("reimb_status"));
                reimb.setReimbursementStatusId(status);
                ReimbursementType type = new ReimbursementType(result.getInt("reimb_type_id"),
                        result.getString("reimb_type"));
                reimb.setReimbursementTypeId(type);
                listReimb.add(reimb);
            }
            return listReimb;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Reimbursement>();
    }

    //Manager can see the list of reimbursement that are on 'requested' phase.
    @Override
    public List<Reimbursement> findAllRequest() {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM reimbursement AS r LEFT JOIN reimbursement_type t ON  t.reimb_type_id =" +
                    " r.reimb_type_id LEFT JOIN reimbursement_status s ON s.reimb_status_id = r.reimb_status_id WHERE r.reimb_status_id = 1;";

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
                int author = result.getInt("reimb_author");
                if(author != 0){
                    User userAuthor = userDAO.findUserByUserId(author);
                    request.setReimbursementAuthor(userAuthor);
                }
                int resolver = result.getInt("reimb_resolver");
                if(resolver != 0){
                    User userResolver = userDAO.findUserByUserId(author);
                    request.setReimbursementResolver(userResolver);
                }
                ReimbursementStatus status = new ReimbursementStatus(result.getInt("reimb_status_id"),
                        result.getString("reimb_status"));
                request.setReimbursementStatusId(status);
                ReimbursementType type = new ReimbursementType(result.getInt("reimb_type_id"),
                        result.getString("reimb_type"));
                request.setReimbursementTypeId(type);
                listRequest.add(request);
            }
            return listRequest;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Reimbursement>();
    }

    //Employee can see the list of past reimbursement.
    @Override
    public List<Reimbursement> viewPastRequests(int authorId) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM reimbursement WHERE reimb_author = ?;";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,authorId);

            ResultSet result = ps.executeQuery();

            List<Reimbursement> list = new ArrayList<>();

            while(result.next()){
                Reimbursement reimb = new Reimbursement();
                reimb.setReimbursementId(result.getInt("reimb_id"));
                reimb.setReimbursementAmount(result.getFloat("reimb_amount"));
                reimb.setReimbursementSubmitted(result.getTimestamp("reimb_submitted"));
                reimb.setReimbursementResolved(result.getTimestamp("reimb_resolved"));
                reimb.setReimbursementDescription(result.getString("reimb_description"));
                int author = result.getInt("reimb_author");
                if(author != 0){
                    User userAuthor = userDAO.findUserByUserId(author);
                    reimb.setReimbursementAuthor(userAuthor);
                }
                int resolver = result.getInt("reimb_resolver");
                if(resolver != 0){
                    User userResolver = userDAO.findUserByUserId(author);
                    reimb.setReimbursementResolver(userResolver);
                }
                ReimbursementStatus status = new ReimbursementStatus(result.getInt("reimb_status_id"),
                        result.getString("reimb_status"));
                reimb.setReimbursementStatusId(status);
                ReimbursementType type = new ReimbursementType(result.getInt("reimb_type_id"),
                        result.getString("reimb_type"));
                reimb.setReimbursementTypeId(type);
                list.add(reimb);
            }
            return list;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    //Employee adds request.
    @Override
    public boolean addRequest(Reimbursement reimbursement) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author," +
                    " reimb_status_id, reimb_type_id) VALUES(?, (SELECT CURRENT_TIMESTAMP), ?, ?, 1, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            int count = 0;
            ps.setFloat(++count, reimbursement.getReimbursementAmount());
            ps.setString(++count, reimbursement.getReimbursementDescription());
            ps.setInt(++count, reimbursement.getReimbursementAuthor().getUserID());
            ps.setInt(++count, reimbursement.getReimbursementTypeId().getTypeId());
            ps.execute();

            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    //Manager can accept or deny requests.
    @Override
    public boolean updateStatus(Reimbursement reimbursement) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "UPDATE reimbursement SET reimb_status_id = ?, reimb_resolved = (SELECT CURRENT_TIMESTAMP), reimb_resolver = ? WHERE reimb_id = ? ;";

            PreparedStatement ps = conn.prepareStatement(sql);

            int count = 0;
            ps.setInt(++count, reimbursement.getReimbursementStatusId().getStatusID());
            ps.setTimestamp(++count, reimbursement.getReimbursementResolved());
            ps.setInt(++count,reimbursement.getReimbursementResolver().getUserID());
            ps.setInt(++count, reimbursement.getReimbursementId());
            ps.execute();

            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


//    @Override
//    public Timestamp addTimeStamp(Timestamp reimbursementTimeStamp) {
//        try (Connection conn = ConnectionUtil.getConnection()) {
//            String sql = "SELECT reimbursement_resolved FROM reimbursement WHERE reimbursement_id = ? ;";
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setTimestamp(1, reimbursementTimeStamp);
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//            Reimbursement reimbursement = new Reimbursement();
//
//
//        }
//
//        return reimbursementTimeStamp;
//    }

}
