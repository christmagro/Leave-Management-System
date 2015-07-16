package com.yobetit.test.repositories;

import com.yobetit.test.entities.GroupsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Christian Magro on 15/07/2015.
 */
@Repository
public interface GroupRepository extends JpaRepository<GroupsEntity, Integer> {
}
