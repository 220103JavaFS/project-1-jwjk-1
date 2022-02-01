package com.revature.models;

import java.util.Objects;

public class User {

    private int userID;
    private String userName;
    private String password;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private UserRole userRoleId;

    public User() {

    }

    public User(int userID, String userName, String password, String userFirstName, String userLastName, String userEmail,
                UserRole userRoleId) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userRoleId = userRoleId;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public UserRole getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(UserRole userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUserID() == user.getUserID() && getUserRoleId() == user.getUserRoleId() && Objects.equals(getUserName(), user.getUserName()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getUserFirstName(), user.getUserFirstName()) && Objects.equals(getUserLastName(), user.getUserLastName()) && Objects.equals(getUserEmail(), user.getUserEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserID(), getUserName(), getPassword(), getUserFirstName(), getUserLastName(), getUserEmail(), getUserRoleId());
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userRoleId=" + userRoleId +
                '}';
    }
}
