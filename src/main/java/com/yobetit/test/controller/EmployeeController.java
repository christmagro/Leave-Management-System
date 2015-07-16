package com.yobetit.test.controller;

import com.yobetit.test.dtos.Employee;
import com.yobetit.test.entities.EmployeeEntity;
import com.yobetit.test.service.EmployeeService;
import com.yobetit.test.ui.EmployeeResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Christian Magro on 15/07/2015.
 */

@RestController
@RequestMapping(value = "v1/employee")
public class EmployeeController {

    public static final Logger log = Logger.getLogger(EmployeeController.class);

    @Autowired
    public EmployeeService employeeService;


    @RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable int id) {

        log.info("Requesting employee details with id: "+ id);
        Employee employee = employeeService.getEmployee(id);

        log.info("Response received containing  " + employee.getEmployeeName() + " " + employee.getEmployeeSurname() + " details");
        return employee;

    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Employee> getEmployee() {

        log.info("Requesting list of all employees ");

        return employeeService.getEmployees();

    }


    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = {"application/json"})
    public EmployeeResponse addEmployee(@RequestBody EmployeeEntity employeeEntity) {

        log.info("Request received to add a New User");

        return employeeService.addEmployee(employeeEntity);

    }
}
