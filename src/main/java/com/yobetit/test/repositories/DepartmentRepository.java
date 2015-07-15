package com.yobetit.test.repositories;

import com.yobetit.test.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Christian Magro on 15/07/2015.
 */
@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {


}
