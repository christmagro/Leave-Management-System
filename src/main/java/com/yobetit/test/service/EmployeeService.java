package com.yobetit.test.service;


import com.yobetit.test.dtos.Employee;
import com.yobetit.test.entities.DepartmentEntity;
import com.yobetit.test.entities.EmployeeEntity;
import com.yobetit.test.entities.GroupsEntity;
import com.yobetit.test.repositories.DepartmentRepository;
import com.yobetit.test.repositories.EmployeeRepository;
import com.yobetit.test.repositories.GroupRepository;
import com.yobetit.test.ui.EmployeeResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class EmployeeService {

    public static final Logger log = Logger.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Value("${yobetittest.max.leave.days.peremployee}")
    int totalLeaveDaysAllowed;


    @Value("${yobetittest.hours.perday}")
    int hoursPerDay;

    @Value("${yobetittest.password.size}")
    int passwordSize;

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static Random rnd = new Random();


    @Transactional(readOnly = true)
    public Employee getEmployee(int employeeId) {

        log.info("Received request to return employee with id: " + employeeId);
        try {
            EmployeeEntity employeeEntity = employeeRepository.findOne(employeeId);
            DepartmentEntity departmentEntity = departmentRepository.findOne(employeeEntity.getDepartment().getDepartmentId());
            GroupsEntity groupsEntity = groupRepository.findOne(employeeEntity.getGroup().getGroupId());
            Employee employee = new Employee();

            employee.setEmployeeId(employeeEntity.getEmployeeId());
            employee.setEmployeeName(employeeEntity.getEmployeeName());
            employee.setEmployeeSurname(employeeEntity.getEmployeeSurname());
            employee.setEmployeeBalance(employeeEntity.getEmployeeBalance());
            employee.setUsername(employeeEntity.getUsername());
            employee.setDepartment(departmentEntity);
            employee.setGroup(groupsEntity);

            log.info("Request for Employee with id: " + employeeId + " was successful");

            return employee;
        } catch (Exception e) {
            log.error("Exception thrown ", e);
        }

        return null;
    }

    @Transactional(readOnly = true)
    public EmployeeResponse getEmployeeCredentials(int employeeId) {

        log.info("Received request to return employee with id: " + employeeId);
        try {
            EmployeeEntity employeeEntity = employeeRepository.findOne(employeeId);
            EmployeeResponse employee = new EmployeeResponse();


            employee.setUsername(employeeEntity.getUsername());
            employee.setPassword(employeeEntity.getPassword());

            log.info("Request for Employee credentials with id: " + employeeId + " was successful");

            return employee;
        } catch (Exception e) {
            log.error("Exception thrown ", e);
        }

        return null;
    }




    @Transactional(readOnly = true)
    public List<Employee> getEmployees() {

        log.info("Received request to return list of all employees");

        try {
            List<Employee> employeeList = new ArrayList<Employee>();
            List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
            for (EmployeeEntity employeeEntity : employeeEntityList) {
                DepartmentEntity departmentEntity = departmentRepository.findOne(employeeEntity.getDepartment().getDepartmentId());
                GroupsEntity groupsEntity = groupRepository.findOne(employeeEntity.getGroup().getGroupId());
                Employee employee = new Employee();


                employee.setEmployeeId(employeeEntity.getEmployeeId());
                employee.setEmployeeName(employeeEntity.getEmployeeName());
                employee.setEmployeeSurname(employeeEntity.getEmployeeSurname());
                employee.setEmployeeBalance(employeeEntity.getEmployeeBalance());
                employee.setUsername(employeeEntity.getUsername());
                employee.setDepartment(departmentEntity);
                employee.setGroup(groupsEntity);
                employeeList.add(employee);
            }
            log.info("A total of " + employeeList.size() + " employees were returned ");

            return employeeList;
        } catch (Exception e) {
            log.error("Exception thrown ", e);
        }

        return null;
    }

    @Transactional(readOnly = true)
    public Employee getEmployeeDetails(String username) {

        log.info("Received request to return employee with id: " + username);
        try {
            EmployeeEntity employeeEntity = employeeRepository.findByUsername(username);
            DepartmentEntity departmentEntity = departmentRepository.findOne(employeeEntity.getDepartment().getDepartmentId());

            Employee employee = new Employee();

            employee.setEmployeeName(employeeEntity.getEmployeeName());
            employee.setEmployeeSurname(employeeEntity.getEmployeeSurname());
            employee.setEmployeeBalance(employeeEntity.getEmployeeBalance());
            employee.setDepartment(departmentEntity);
            employee.setUsername(employeeEntity.getUsername());


            log.info("Request for Employee details with username " + username + " was successful");

            return employee;
        } catch (Exception e) {
            log.error("Exception thrown ", e);
        }

        return null;
    }

    @Transactional
    public EmployeeResponse addEmployee(EmployeeEntity employee) {

        try {

            log.info("Adding " + employee.toString());
            double leaveBalance = calculateInitialLeaveHours(employee.getEmployeeName(), employee.getEmployeeSurname());
            employee.setEmployeeBalance(leaveBalance);

            employee.setPassword(randomPassword(employee.getEmployeeName(), employee.getEmployeeSurname()));

            employeeRepository.save(employee);
            log.info(employee.getEmployeeName() + employee.getEmployeeSurname() + " added successfully");

            return new EmployeeResponse(employee.getEmployeeBalance(), employee.getUsername(), employee.getPassword());
        } catch (Exception e) {
            log.error("Exception thrown ", e);
        }

        return null;
    }

    @Transactional
    public void editEmployeeLeave(int employeeId, double leaveBalance) {

        try {

            log.info("Editing leave balance ");

            EmployeeEntity employeeEntity = employeeRepository.getOne(employeeId);

            employeeEntity.setEmployeeBalance(leaveBalance);



            employeeRepository.save(employeeEntity);
            log.info(employeeEntity.getEmployeeName() + employeeEntity.getEmployeeSurname() + " edited successfully");

      //      return new EmployeeResponse(employee.getEmployeeBalance(), employee.getUsername(), employee.getPassword());
        } catch (Exception e) {
            log.error("Exception thrown ", e);
        }

       // return null;
    }


    private double calculateInitialLeaveHours(String name, String surname) {

        log.info("Calculating Leave for new employee " + name + " " + surname);

        Calendar calendar1 = Calendar.getInstance();
        int currentDayOfYear = calendar1.get(Calendar.DAY_OF_YEAR);

        int year = calendar1.get(Calendar.YEAR);

        Calendar calendar2 = new GregorianCalendar(year, 11, 31);
        int dayDecember31 = calendar2.get(Calendar.DAY_OF_YEAR);

        int days = dayDecember31 - currentDayOfYear;

        double totalRemainingDay = (totalLeaveDaysAllowed * days / 356);
        double totalRemainingHours = totalRemainingDay * hoursPerDay;

        log.info("A total of "+ totalRemainingHours + " hours are allocated to " + name + " " + surname);

        return totalRemainingHours;

    }




    String randomPassword(String name, String surname) {
        StringBuilder sb = new StringBuilder(passwordSize);

        log.info("Received request to generate new password for new employee " + name + " " + surname);

        for (int i = 0; i < passwordSize; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));


        return sb.toString();
    }


}