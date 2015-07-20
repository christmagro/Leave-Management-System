package com.yobetit.test.controller;

import com.yobetit.test.entities.DepartmentEntity;
import com.yobetit.test.entities.GroupsEntity;
import com.yobetit.test.service.DepartmentService;
import com.yobetit.test.service.GroupService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Christian Magro on 18/07/2015.
 */
@RestController
@RequestMapping(value = "v1/group")
public class GroupController {

    public static final Logger log = Logger.getLogger(GroupController.class);

    @Autowired
    public GroupService groupService;


    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<GroupsEntity> getDepartment() {

        log.info("Requesting list of all departments ");

        return groupService.getGroups();

    }
}
