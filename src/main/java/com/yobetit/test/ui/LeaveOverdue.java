package com.yobetit.test.ui;

/**
 * Created by Christian Magro on 15/07/2015.
 */
public class LeaveOverdue {

    private String month;
    private Double leaveDays;
    private boolean isOverdue;
    private Double totalOverdueDays;

    public Double getTotalOverdueDays() {
        return totalOverdueDays;
    }

    public void setTotalOverdueDays(Double totalOverdueDays) {
        this.totalOverdueDays = totalOverdueDays;
    }

    public LeaveOverdue() {

    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Double getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(Double leaveDays) {
        this.leaveDays = leaveDays;
    }

    public boolean isOverdue() {
        return isOverdue;
    }

    public void setIsOverdue(boolean isOverdue) {
        this.isOverdue = isOverdue;
    }
}
