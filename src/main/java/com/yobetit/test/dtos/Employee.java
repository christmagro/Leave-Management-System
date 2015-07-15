package com.yobetit.test.dtos;

import com.yobetit.test.entities.DepartmentEntity;
import com.yobetit.test.entities.GroupsEntity;

/**
 * Created by Christian Magro on 15/07/2015.
 */
public class Employee {

    private int employeeId;
    private double employeeBalance;
    private String employeeName;
    private String employeeSurname;
    private String password;
    private String username;
    private DepartmentEntity Department;
    private GroupsEntity Group;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getEmployeeBalance() {
        return employeeBalance;
    }

    public void setEmployeeBalance(double employeeBalance) {
        this.employeeBalance = employeeBalance;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public DepartmentEntity getDepartment() {
        return Department;
    }

    public void setDepartment(DepartmentEntity department) {
        Department = department;
    }

    public GroupsEntity getGroup() {
        return Group;
    }

    public void setGroup(GroupsEntity group) {
        Group = group;
    }
}
