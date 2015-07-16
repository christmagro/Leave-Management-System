package com.yobetit.test.entities;

import javax.persistence.*;

/**
 * Created by Christian Magro on 15/07/2015.
 */
@Entity
@Table(name = "tbl_manager")
public class ManagerEntity {
    private int managerId;
    private EmployeeEntity Employee;
    private DepartmentEntity Department;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "manager_id", nullable = false, insertable = true, updatable = true)
    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManagerEntity that = (ManagerEntity) o;

        if (managerId != that.managerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return managerId;
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
    @JoinColumn(name = "department_id", referencedColumnName = "department_id", nullable = false)
    public DepartmentEntity getDepartment() {
        return Department;
    }

    public void setDepartment(DepartmentEntity tblDepartmentByDepartmentId) {
        this.Department = tblDepartmentByDepartmentId;
    }
}
