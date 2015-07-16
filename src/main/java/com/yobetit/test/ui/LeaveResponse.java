package com.yobetit.test.ui;

/**
 * Created by Christian Magro on 15/07/2015.
 */
public class LeaveResponse {

    private double updatedLeaveBalance;
    private boolean leaveSuccesfull;
    private boolean leaveDelete;

    public LeaveResponse(boolean leaveSuccesfull) {
        this.leaveSuccesfull = leaveSuccesfull;
    }

    public LeaveResponse(double updatedLeaveBalance, boolean leaveSuccesfull) {
        this.updatedLeaveBalance = updatedLeaveBalance;
        this.leaveSuccesfull = leaveSuccesfull;
    }

    public LeaveResponse(boolean leaveDelete, double updatedLeaveBalance) {
        this.leaveDelete = leaveDelete;
        this.updatedLeaveBalance = updatedLeaveBalance;
    }

    public double getUpdatedLeaveBalance() {
        return updatedLeaveBalance;
    }

    public void setUpdatedLeaveBalance(double updatedLeaveBalance) {
        this.updatedLeaveBalance = updatedLeaveBalance;
    }

    public boolean isLeaveSuccesfull() {
        return leaveSuccesfull;
    }

    public void setLeaveSuccesfull(boolean leaveSuccesfull) {
        this.leaveSuccesfull = leaveSuccesfull;
    }

    public boolean isLeaveDelete() {
        return leaveDelete;
    }

    public void setLeaveDelete(boolean leaveDelete) {
        this.leaveDelete = leaveDelete;
    }
}
