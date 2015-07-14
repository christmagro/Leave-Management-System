package com.yobetit.test.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Christian Magro on 12/07/2015.
 */
@Entity
@Table(name = "tbl_LeaveHistory")
public class LeaveHistoryEntity {
    private int leavehistoryId;
    private String hours;
    private Timestamp startDate;
    private Timestamp endDate;
    private Timestamp requestDate;
    private Timestamp approvalDate;
    private EmployeeEntity employee;
    private StatusEntity status;
    private ManagerEntity manager;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "leavehistoryId", nullable = false, insertable = true, updatable = true)
    public int getLeavehistoryId() {
        return leavehistoryId;
    }

    public void setLeavehistoryId(int leavehistoryId) {
        this.leavehistoryId = leavehistoryId;
    }

    @Basic
    @Column(name = "hours", nullable = true, insertable = true, updatable = true, length = 45)
    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    @Basic
    @Column(name = "startDate", nullable = false, insertable = true, updatable = true)
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "endDate", nullable = false, insertable = true, updatable = true)
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "requestDate", nullable = false, insertable = true, updatable = true)
    public Timestamp getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Timestamp requestDate) {
        this.requestDate = requestDate;
    }

    @Basic
    @Column(name = "approvalDate", nullable = true, insertable = true, updatable = true)
    public Timestamp getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Timestamp approvalDate) {
        this.approvalDate = approvalDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeaveHistoryEntity that = (LeaveHistoryEntity) o;

        if (leavehistoryId != that.leavehistoryId) return false;
        if (hours != null ? !hours.equals(that.hours) : that.hours != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (requestDate != null ? !requestDate.equals(that.requestDate) : that.requestDate != null) return false;
        if (approvalDate != null ? !approvalDate.equals(that.approvalDate) : that.approvalDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = leavehistoryId;
        result = 31 * result + (hours != null ? hours.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (requestDate != null ? requestDate.hashCode() : 0);
        result = 31 * result + (approvalDate != null ? approvalDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId", nullable = false)
    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
    @ManyToOne
    @JoinColumn(name = "statusId", referencedColumnName = "statusId", nullable = false)
    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }
    @ManyToOne
    @JoinColumn(name = "managerId", referencedColumnName = "managerId", nullable = false)
    public ManagerEntity getManager() {
        return manager;
    }

    public void setManager(ManagerEntity manager) {
        this.manager = manager;
    }



}
