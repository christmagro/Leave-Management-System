package com.yobetit.test.repositories;


import com.yobetit.test.entities.EmployeeEntity;
import com.yobetit.test.entities.LeaveHistoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Christian Magro on 12/07/2015.
 */
@Repository
public interface LeaveHistoryRepository extends CrudRepository<LeaveHistoryEntity, Integer> {

    List<LeaveHistoryEntity> findByemployee(EmployeeEntity employeeEntity);

}
