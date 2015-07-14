package com.yobetit.test.repositories;

import com.yobetit.test.entities.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Christian Magro on 14/07/2015.
 */
public interface GroupsRepository extends JpaRepository<GroupEntity, Integer> {
}
