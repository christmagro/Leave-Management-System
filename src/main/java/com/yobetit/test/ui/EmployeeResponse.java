package com.yobetit.test.ui;

/**
 * Created by Christian Magro on 15/07/2015.
 */
public class EmployeeResponse {

    private double leaveBalance;
    private String username;
    private String password;

    public EmployeeResponse(double leaveBalance, String username, String password) {
        this.leaveBalance = leaveBalance;
        this.username = username;
        this.password = password;
    }

    public EmployeeResponse() {
    }

    public double getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(double leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
