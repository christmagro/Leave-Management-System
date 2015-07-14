package com.yobetit.test.entities;

import javax.persistence.*;
import java.util.Collection;


/**
 * Created by Christian Magro on 12/07/2015.
 */
@Entity
@Table(name = "tbl_Employee")
public class EmployeeEntity {
    private int employeeId;
    private String employeeName;
    private String employeeSurname;
    private DepartmentEntity department;
    private float employeeBalance;
    private String username;
    private String password;
    private Collection<LeaveHistoryEntity> leaveHistoryEntityList;
    private GroupEntity group;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "employeeId", nullable = false, insertable = true, updatable = true)
    public int getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    
    @Basic
    @Column(name = "employeeName", nullable = false, insertable = true, updatable = true, length = 45)
    public String getEmployeeName() {
        return employeeName;
    }
    
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    
    @Basic
    @Column(name = "employeeSurname", nullable = false, insertable = true, updatable = true, length = 45)
    public String getEmployeeSurname() {
        return employeeSurname;
    }
    
    
    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }
    
    @Basic
    @Column(name = "employeeBalance", nullable = true, insertable = true, updatable = true)
    public float getEmployeeBalance() {
        return employeeBalance;
    }
    
    public void setEmployeeBalance(float employeeBalance) {
        this.employeeBalance = employeeBalance;
    }

    @Basic
    @Column(name = "username", nullable = false, insertable = true, updatable = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, insertable = true, updatable = true)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        EmployeeEntity that = (EmployeeEntity) o;
        
        if (employeeId != that.employeeId) return false;
        if (employeeName != null ? !employeeName.equals(that.employeeName) : that.employeeName != null) return false;
        if (employeeSurname != null ? !employeeSurname.equals(that.employeeSurname) : that.employeeSurname != null)
            return false;
        
        return true;
    }
    
    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + (employeeName != null ? employeeName.hashCode() : 0);
        result = 31 * result + (employeeSurname != null ? employeeSurname.hashCode() : 0);
        return result;
    }
    
    @ManyToOne
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId", nullable = false)
    public DepartmentEntity getDepartment() {
        return department;
    }
    
    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="employeeId")
    public Collection<LeaveHistoryEntity> getLeaveHistoryEntityList() {
        return leaveHistoryEntityList;
    }
    
    public void setLeaveHistoryEntityList(Collection<LeaveHistoryEntity> leaveHistoryEntityList) {
        this.leaveHistoryEntityList = leaveHistoryEntityList;
    }

    @ManyToOne
    @JoinColumn(name = "groupId", referencedColumnName = "groupId", nullable = false)
    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }
}
