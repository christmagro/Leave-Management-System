package com.yobetit.test.repositories;

import com.yobetit.test.entities.DepartmentEntity;
import com.yobetit.test.entities.EmployeeEntity;
import com.yobetit.test.entities.ManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Christian Magro on 15/07/2015.
 */
@Repository
public interface ManagerRepository extends JpaRepository<ManagerEntity, Integer> {

    public ManagerEntity findByDepartment(DepartmentEntity departmentEntity);
    public ManagerEntity findByEmployee(EmployeeEntity employeeEntity);
}
