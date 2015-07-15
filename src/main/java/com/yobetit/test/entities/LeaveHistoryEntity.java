package com.yobetit.test.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Christian Magro on 15/07/2015.
 */
@Entity
@Table(name = "tbl_leave_history")
public class LeaveHistoryEntity {
    private int leavehistoryId;
    private Timestamp approvalDate;
    private double hours;
    private Timestamp requestDate;
    private Timestamp startDate;
    private StatusEntity Status;
    private EmployeeEntity Employee;
    private ManagerEntity Manager;
    private Byte leaveCancelled;


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "leavehistory_id", nullable = false, insertable = true, updatable = true)
    public int getLeavehistoryId() {
        return leavehistoryId;
    }

    public void setLeavehistoryId(int leavehistoryId) {
        this.leavehistoryId = leavehistoryId;
    }

    @Basic
    @Column(name = "approval_date", nullable = true, insertable = true, updatable = true)
    public Timestamp getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Timestamp approvalDate) {
        this.approvalDate = approvalDate;
    }

    @Basic
    @Column(name = "hours", nullable = true, insertable = true, updatable = true, length = 45)
    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    @Basic
    @Column(name = "request_date", nullable = false, insertable = true, updatable = true)
    public Timestamp getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Timestamp requestDate) {
        this.requestDate = requestDate;
    }

    @Basic
    @Column(name = "start_date", nullable = false, insertable = true, updatable = true)
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "leave_cancelled", nullable = true, insertable = true, updatable = true)
    public Byte getLeaveCancelled() {
        return leaveCancelled;
    }

    public void setLeaveCancelled(Byte leaveCancelled) {
        this.leaveCancelled = leaveCancelled;
    }




    @Override
    public String toString() {
        return "LeaveHistoryEntity{" +
                "leavehistoryId=" + leavehistoryId +
                ", approvalDate=" + approvalDate +
                ", hours='" + hours + '\'' +
                ", requestDate=" + requestDate +
                ", startDate=" + startDate +
                ", Status=" + Status +
                ", Employee=" + Employee +
                ", Manager=" + Manager +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeaveHistoryEntity that = (LeaveHistoryEntity) o;

        if (leavehistoryId != that.leavehistoryId) return false;
        if (approvalDate != null ? !approvalDate.equals(that.approvalDate) : that.approvalDate != null) return false;
        if (requestDate != null ? !requestDate.equals(that.requestDate) : that.requestDate != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = leavehistoryId;
        result = 31 * result + (approvalDate != null ? approvalDate.hashCode() : 0);
        result = 31 * result + (requestDate != null ? requestDate.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);

        return result;
    }

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", nullable = false)
    public EmployeeEntity getEmployee() {
        return Employee;
    }

    public void setEmployee(EmployeeEntity tblEmployeeByEmployeeId) {
        this.Employee = tblEmployeeByEmployeeId;
    }


    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "status_id", nullable = false)
    public StatusEntity getStatus() {
        return Status;
    }

    public void setStatus(StatusEntity status) {
        Status = status;
    }

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "manager_id", nullable = false)
    public ManagerEntity getManager() {
        return Manager;
    }

    public void setManager(ManagerEntity manager) {
        Manager = manager;
    }
}
