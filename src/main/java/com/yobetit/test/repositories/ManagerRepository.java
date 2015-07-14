package com.yobetit.test.repositories;


import com.yobetit.test.entities.ManagerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Christian Magro on 12/07/2015.
 */
@Repository
public interface ManagerRepository extends CrudRepository<ManagerEntity, Integer> {


}
