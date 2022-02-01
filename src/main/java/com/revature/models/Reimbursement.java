package com.revature.models;

import java.sql.Timestamp;
import java.util.Objects;

public class Reimbursement {

    private int reimbursementId;
    private float reimbursementAmount;
    private Timestamp reimbursementSubmitted;
    private Timestamp reimbursementResolved;
    private String reimbursementDescription;
    private User reimbursementAuthor;
    private User reimbursementResolver;
    private ReimbursementStatus reimbursementStatusId;
    private ReimbursementType reimbursementTypeId;

    public Reimbursement(int i, Timestamp timestamp, Timestamp valueOf, String s, int i1, int i2, int i3, int i4) {

    }

    public Reimbursement(int reimbursementId, float reimbursementAmount, Timestamp reimbursementSubmitted,
                         Timestamp reimbursementResolved, String reimbursementDescription, User reimbursementAuthor,
                         User reimbursementResolver, ReimbursementStatus reimbursementStatusId, ReimbursementType reimbursementTypeId) {
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

    public Reimbursement() {

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

    public User getReimbursementAuthor() {

        return reimbursementAuthor;
    }

    public void setReimbursementAuthor(User reimbursementAuthor) {

        this.reimbursementAuthor = reimbursementAuthor;
    }

    public User getReimbursementResolver() {

        return reimbursementResolver;
    }

    public void setReimbursementResolver(User reimbursementResolver) {
        this.reimbursementResolver = reimbursementResolver;
    }

    public ReimbursementStatus getReimbursementStatusId() {
        return reimbursementStatusId;
    }

    public void setReimbursementStatusId(ReimbursementStatus reimbursementStatusId) {
        this.reimbursementStatusId = reimbursementStatusId;
    }

    public ReimbursementType getReimbursementTypeId() {
        return reimbursementTypeId;
    }

    public void setReimbursementTypeId(ReimbursementType reimbursementTypeId) {
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
