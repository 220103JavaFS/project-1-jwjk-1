package com.revature.models;

import java.sql.Timestamp;
import java.util.Objects;

public class Reimbursement {

    private int reimbursementId;
    private float reimbursementAmount;
    private Timestamp reimbursementSubmitted;
    private Timestamp reimbursementResolved;
    private String reimbursementDescription;
    private int reimbursementAuthor;
    private int reimbursementResolver;
    private int reimbursementStatusId;
    private int reimbursementTypeId;

    public Reimbursement() {

    }

    public Reimbursement(int reimbursementId, float reimbursementAmount, Timestamp reimbursementSubmitted,
                         Timestamp reimbursementResolved, String reimbursementDescription, int reimbursementAuthor,
                         int reimbursementResolver, int reimbursementStatusId, int reimbursementTypeId) {
        this.reimbursementId = reimbursementId;
        this.reimbursementAmount = reimbursementAmount;
        this.reimbursementSubmitted = reimbursementSubmitted;
        this.reimbursementResolved = reimbursementResolved;
        this.reimbursementDescription = reimbursementDescription;
        this.reimbursementAuthor = reimbursementAuthor;
        this.reimbursementResolver = reimbursementResolver;
        this.reimbursementStatusId = reimbursementStatusId;
        this.reimbursementTypeId = reimbursementTypeId;
    }


    public int getReimbursementId() {
        return reimbursementId;
    }

    public void setReimbursementId(int reimbursementId) {
        this.reimbursementId = reimbursementId;
    }

    public float getReimbursementAmount() {
        return reimbursementAmount;
    }

    public void setReimbursementAmount(float reimbursementAmount) {
        this.reimbursementAmount = reimbursementAmount;
    }

    public Timestamp getReimbursementSubmitted() {
        return reimbursementSubmitted;
    }

    public void setReimbursementSubmitted(Timestamp reimbursementSubmitted) {
        this.reimbursementSubmitted = reimbursementSubmitted;
    }

    public Timestamp getReimbursementResolved() {
        return reimbursementResolved;
    }

    public void setReimbursementResolved(Timestamp reimbursementResolved) {
        this.reimbursementResolved = reimbursementResolved;
    }

    public String getReimbursementDescription() {
        return reimbursementDescription;
    }

    public void setReimbursementDescription(String reimbursementDescription) {
        this.reimbursementDescription = reimbursementDescription;
    }

    public int getReimbursementAuthor() {

        return reimbursementAuthor;
    }

    public void setReimbursementAuthor(int reimbursementAuthor) {

        this.reimbursementAuthor = reimbursementAuthor;
    }

    public int getReimbursementResolver() {

        return reimbursementResolver;
    }

    public void setReimbursementResolver(int reimbursementResolver) {
        this.reimbursementResolver = reimbursementResolver;
    }

    public int getReimbursementStatusId() {
        return reimbursementStatusId;
    }

    public void setReimbursementStatusId(int reimbursementStatusId) {
        this.reimbursementStatusId = reimbursementStatusId;
    }

    public int getReimbursementTypeId() {
        return reimbursementTypeId;
    }

    public void setReimbursementTypeId(int reimbursementTypeId) {
        this.reimbursementTypeId = reimbursementTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reimbursement)) return false;
        Reimbursement that = (Reimbursement) o;
        return getReimbursementId() == that.getReimbursementId() && getReimbursementAmount() == that.getReimbursementAmount() && getReimbursementSubmitted() == that.getReimbursementSubmitted() && getReimbursementResolved() == that.getReimbursementResolved() && getReimbursementAuthor() == that.getReimbursementAuthor() && getReimbursementResolver() == that.getReimbursementResolver() && getReimbursementStatusId() == that.getReimbursementStatusId() && getReimbursementTypeId() == that.getReimbursementTypeId() && Objects.equals(getReimbursementDescription(), that.getReimbursementDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReimbursementId(), getReimbursementAmount(), getReimbursementSubmitted(), getReimbursementResolved(), getReimbursementDescription(), getReimbursementAuthor(), getReimbursementResolver(), getReimbursementStatusId(), getReimbursementTypeId());
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbursementId=" + reimbursementId +
                ", reimbursementAmount=" + reimbursementAmount +
                ", reimbursementSubmitted=" + reimbursementSubmitted +
                ", reimbursementResolved=" + reimbursementResolved +
                ", reimbursementDescription='" + reimbursementDescription + '\'' +
                ", reimbursementAuthor=" + reimbursementAuthor +
                ", reimbursementResolver=" + reimbursementResolver +
                ", reimbursementStatusId=" + reimbursementStatusId +
                ", reimbursementTypeId=" + reimbursementTypeId +
                '}';
    }
}