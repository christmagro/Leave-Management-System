package com.yobetit.test.entities;



import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Christian Magro on 15/07/2015.
 */
@Entity
@Table(name = "tbl_employee")
public class EmployeeEntity {
    private int employeeId;
    private double employeeBalance;
    private String employeeName;
    private String employeeSurname;
    private String password;
    private String username;
    private DepartmentEntity Department;
    private GroupsEntity Group;
    //private Collection<LeaveHistoryEntity> leaveHistoryEntityList;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "employee_id", nullable = false, insertable = true, updatable = true)
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "employee_balance", nullable = true, insertable = true, updatable = true, precision = 0)
    public double getEmployeeBalance() {
        return employeeBalance;
    }

    public void setEmployeeBalance(double employeeBalance) {
        this.employeeBalance = employeeBalance;
    }

    @Basic
    @Column(name = "employee_name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Basic
    @Column(name = "employee_surname", nullable = false, insertable = true, updatable = true, length = 45)
    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    @Basic
    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "username", nullable = false, unique = true, insertable = true, updatable = true, length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeId;
        result = 31 * result + (employeeName != null ? employeeName.hashCode() : 0);
        result = 31 * result + (employeeSurname != null ? employeeSurname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id", nullable = false)
    public DepartmentEntity getDepartment() {
        return Department;
    }

    public void setDepartment(DepartmentEntity tblDepartmentByDepartmentId) {
        this.Department = tblDepartmentByDepartmentId;
    }

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "group_id", nullable = false)
    public GroupsEntity getGroup() {
        return Group;
    }

    public void setGroup(GroupsEntity group) {
        Group = group;
    }



    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "employeeId=" + employeeId +
                ", employeeBalance=" + employeeBalance +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSurname='" + employeeSurname + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", Department=" + Department +
                ", Group=" + Group +
                '}';
    }
}
