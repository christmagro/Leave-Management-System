package com.yobetit.test.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Christian Magro on 15/07/2015.
 */
@Entity
@Table(name = "tbl_groups")
public class GroupsEntity {
    private int groupId;
    private String statusName;
   // private Collection<EmployeeEntity> employeeEntityList;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "group_id", nullable = false, insertable = true, updatable = true)
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "status_name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupsEntity that = (GroupsEntity) o;

        if (groupId != that.groupId) return false;
        if (statusName != null ? !statusName.equals(that.statusName) : that.statusName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupId;
        result = 31 * result + (statusName != null ? statusName.hashCode() : 0);
        return result;
    }

}
