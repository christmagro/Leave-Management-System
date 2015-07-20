package com.yobetit.test.service;

import com.yobetit.test.entities.DepartmentEntity;
import com.yobetit.test.entities.GroupsEntity;
import com.yobetit.test.repositories.DepartmentRepository;
import com.yobetit.test.repositories.GroupRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Christian Magro on 14/07/2015.
 */
@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public static final Logger log = Logger.getLogger(GroupService.class);

    @Transactional(readOnly = true)
    public List<GroupsEntity> getGroups() {

        log.info("Received request to return list of all groups");

        try {

            List<GroupsEntity> groupsEntities = groupRepository.findAll();

            log.info("A total of " + groupsEntities.size() + " groups were returned ");

            return groupsEntities;
        } catch (Exception e) {
            log.error("Exception thrown ", e);
        }

        return null;
    }




}
