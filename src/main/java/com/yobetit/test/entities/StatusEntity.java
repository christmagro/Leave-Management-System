package com.yobetit.test.entities;





import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Christian Magro on 15/07/2015.
 */
@Entity
@Table(name = "tbl_status")
public class StatusEntity {
    private int statusId;
    private String statusName;
   // private Collection<LeaveHistoryEntity> leaveHistoryEntityList;

    @Id
    @Column(name = "status_id", nullable = false, insertable = true, updatable = true)
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
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

}
