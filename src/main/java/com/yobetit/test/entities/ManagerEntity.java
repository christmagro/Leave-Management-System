package com.yobetit.test.entities;

import javax.persistence.*;

/**
 * Created by Christian Magro on 12/07/2015.
 */
@Entity
@Table(name = "tbl_Manager")
public class ManagerEntity {
    private int managerId;
    private EmployeeEntity employee;
    private DepartmentEntity department;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "managerId", nullable = false, insertable = true, updatable = true)
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
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId", nullable = false)
    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    @ManyToOne
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId", nullable = false)
    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }


}
