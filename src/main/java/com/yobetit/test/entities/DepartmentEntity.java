package com.yobetit.test.entities;

import javax.persistence.*;

/**
 * Created by Christian Magro on 12/07/2015.
 */
@Entity
@Table(name = "tbl_Department")
public class DepartmentEntity {
    private int departmentId;
    private String departmentName;
    private String departmentDetails;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "departmentId", nullable = false, insertable = true, updatable = true)
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "departmentName", nullable = false, insertable = true, updatable = true, length = 45)
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Basic
    @Column(name = "departmentDetails", nullable = true, insertable = true, updatable = true, length = 45)
    public String getDepartmentDetails() {
        return departmentDetails;
    }

    public void setDepartmentDetails(String departmentDetails) {
        this.departmentDetails = departmentDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentEntity that = (DepartmentEntity) o;

        if (departmentId != that.departmentId) return false;
        if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
            return false;
        if (departmentDetails != null ? !departmentDetails.equals(that.departmentDetails) : that.departmentDetails != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = departmentId;
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        result = 31 * result + (departmentDetails != null ? departmentDetails.hashCode() : 0);
        return result;
    }


}
