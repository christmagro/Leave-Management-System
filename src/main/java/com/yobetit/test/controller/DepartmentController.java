package com.yobetit.test.controller;

import com.yobetit.test.entities.DepartmentEntity;
import com.yobetit.test.service.DepartmentService;
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
@RequestMapping(value = "v1/department")
public class DepartmentController {

    public static final Logger log = Logger.getLogger(DepartmentController.class);

    @Autowired
    public DepartmentService departmentService;


    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<DepartmentEntity> getDepartment() {

        log.info("Requesting list of all departments ");

        return departmentService.getDepartments();

    }
}
