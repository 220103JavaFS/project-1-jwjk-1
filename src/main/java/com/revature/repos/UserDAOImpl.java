package com.revature.repos;

import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{


    @Override
    public List<User> findAllUsers() {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM users;";

            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            List<User> list = new ArrayList<>();

            while (rs.next()) {
                User user = new User();
                user.setUserID(rs.getInt("user_id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setUserFirstName(rs.getString("user_first_name"));
                user.setUserLastName(rs.getString("user_last_name"));
                user.setUserEmail(rs.getString("user_email"));
                user.setUserRoleId(rs.getInt("user_role_id"));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<User>();
    }

    @Override
    public User findUserByUserName(String userName) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userName );
            ResultSet rs = ps.executeQuery();

            User user = new User();
            while (rs.next()) {
                user.setUserID(rs.getInt("user_id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setUserFirstName(rs.getString("user_first_name"));
                user.setUserLastName(rs.getString("user_last_name"));
                user.setUserEmail(rs.getString("user_email"));
                user.setUserRoleId(rs.getInt("user_role_id"));
            }
            return user;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return new User();
    }

    @Override
    public User findUserByUserId(int userID) {
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM users WHERE user_id = ? ";

            PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1,userID);
                    ResultSet rs = ps.executeQuery();

            User user = new User();

            while(rs.next()){
                user.setUserID(rs.getInt("user_id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setUserFirstName(rs.getString("user_first_name"));
                user.setUserLastName(rs.getString("user_last_name"));
                user.setUserEmail(rs.getString("user_email"));
                user.setUserRoleId(rs.getInt("user_role_id"));
            }
            return user;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return new User();
    }

}
