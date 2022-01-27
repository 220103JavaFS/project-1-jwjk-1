package com.revature.models;

import java.util.Objects;

public class ReimbursementStatus {

    private int statusID;
    private String reimbursementStatus;

    public ReimbursementStatus() {
    }

    public ReimbursementStatus(int statusID, String reimbursementStatus) {
        this.statusID = statusID;
        this.reimbursementStatus = reimbursementStatus;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public String getReimbursementStatus() {
        return reimbursementStatus;
    }

    public void setReimbursementStatus(String reimbursementStatus) {
        this.reimbursementStatus = reimbursementStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReimbursementStatus)) return false;
        ReimbursementStatus that = (ReimbursementStatus) o;
        return getStatusID() == that.getStatusID() && Objects.equals(getReimbursementStatus(), that.getReimbursementStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatusID(), getReimbursementStatus());
    }

    @Override
    public String toString() {
        return "ReimbursementStatus{" +
                "statusID=" + statusID +
                ", reimbursementStatus='" + reimbursementStatus + '\'' +
                '}';
    }
}
