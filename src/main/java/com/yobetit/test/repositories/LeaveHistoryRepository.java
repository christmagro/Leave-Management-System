package com.yobetit.test.repositories;

import com.yobetit.test.entities.EmployeeEntity;
import com.yobetit.test.entities.LeaveHistoryEntity;
import com.yobetit.test.entities.ManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Christian Magro on 15/07/2015.
 */
@Repository
public interface LeaveHistoryRepository extends JpaRepository<LeaveHistoryEntity, Integer> {


    List<LeaveHistoryEntity> findByManager(ManagerEntity manager);
    List<LeaveHistoryEntity> findByEmployeeAndLeaveCancelled(EmployeeEntity employee, Byte cancelled);
    List<LeaveHistoryEntity> findByLeaveCancelled(Byte cancelled);

}
