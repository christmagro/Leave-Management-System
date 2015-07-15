package com.yobetit.test.dtos;

import com.yobetit.test.entities.EmployeeEntity;
import com.yobetit.test.entities.ManagerEntity;
import com.yobetit.test.entities.StatusEntity;

import java.sql.Timestamp;

/**
 * Created by Christian Magro on 15/07/2015.
 */
public class LeaveHistory {

    private int leavehistoryId;
    private Timestamp approvalDate;
    private double hours;
    private Timestamp requestDate;
    private Timestamp startDate;
    private StatusEntity Status;
    private EmployeeEntity Employee;
    private ManagerEntity Manager;

    public int getLeavehistoryId() {
        return leavehistoryId;
    }

    public void setLeavehistoryId(int leavehistoryId) {
        this.leavehistoryId = leavehistoryId;
    }

    public Timestamp getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Timestamp approvalDate) {
        this.approvalDate = approvalDate;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public Timestamp getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Timestamp requestDate) {
        this.requestDate = requestDate;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public StatusEntity getStatus() {
        return Status;
    }

    public void setStatus(StatusEntity status) {
        Status = status;
    }

    public EmployeeEntity getEmployee() {
        return Employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        Employee = employee;
    }

    public ManagerEntity getManager() {
        return Manager;
    }

    public void setManager(ManagerEntity manager) {
        Manager = manager;
    }
}
