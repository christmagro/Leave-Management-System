package com.yobetit.test.controller;

import com.yobetit.test.service.HelloService;
import com.yobetit.test.service.EmployeeService;
import com.yobetit.test.ui.HelloMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "hello")
public class HelloController {

    public static final Logger log = Logger.getLogger(HelloController.class);

    @Autowired
    public HelloService helloService;
    @Autowired
    public EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public HelloMessage printMessage(){
        log.error("About to print a message.");
        int totalEmployeesAvailable = employeeService.getTotalEmployeesAvailable();
        log.error(String.format("Total employees available is : %d", totalEmployeesAvailable));
        return helloService.getHelloMessage();
    }

}
