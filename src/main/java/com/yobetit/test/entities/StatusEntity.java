package com.yobetit.test.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Christian Magro on 12/07/2015.
 */
@Entity
@Table(name = "tbl_Status")
public class StatusEntity {
    private int statusId;
    private String statusName;
    private Collection<LeaveHistoryEntity> leaveHistoryEntityList;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "statusId", nullable = false, insertable = true, updatable = true)
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "statusName", nullable = false, insertable = true, updatable = true, length = 45)
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

        StatusEntity that = (StatusEntity) o;

        if (statusId != that.statusId) return false;
        if (statusName != null ? !statusName.equals(that.statusName) : that.statusName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = statusId;
        result = 31 * result + (statusName != null ? statusName.hashCode() : 0);
        return result;
    }


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="statusId")
    public Collection<LeaveHistoryEntity> getLeaveHistoryEntityList() {
        return leaveHistoryEntityList;
    }

    public void setLeaveHistoryEntityList(Collection<LeaveHistoryEntity> leaveHistoryEntityList) {
        this.leaveHistoryEntityList = leaveHistoryEntityList;
    }
}
