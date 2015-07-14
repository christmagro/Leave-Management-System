package com.yobetit.test.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Christian Magro on 12/07/2015.
 */
@Entity
@Table(name = "tbl_Groups")
public class GroupEntity {
    private int groupId;
    private String groupName;
    private Collection<EmployeeEntity> employeeEntityList;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "groupId", nullable = false, insertable = true, updatable = true)
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }



    @Basic
    @Column(name = "statusName", nullable = false, insertable = true, updatable = true, length = 45)
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupEntity that = (GroupEntity) o;

        if (groupId != that.groupId) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupId;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        return result;
    }


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="groupId")
    public Collection<EmployeeEntity> getEmployeeEntityList() {
        return employeeEntityList;
    }

    public void setEmployeeEntityList(Collection<EmployeeEntity> employeeEntityList) {
        this.employeeEntityList = employeeEntityList;
    }
}
