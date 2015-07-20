package com.yobetit.test.service;


import com.yobetit.test.dtos.LeaveHistory;
import com.yobetit.test.entities.*;
import com.yobetit.test.repositories.*;
import com.yobetit.test.ui.LeaveOverdue;
import com.yobetit.test.ui.LeaveResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Christian Magro on 14/07/2015.
 */
@Service
public class LeaveHistoryService {
    @Autowired
    private LeaveHistoryRepository leaveHistoryRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private DepartmentRepository departmentRepository;


    @Value("${initial.status}")
    int initialStatus;

    @Value("${cancelled.status}")
    int cancelledStatus;

    @Value("${yobetittest.hours.perday}")
    int hoursPerDay;

    @Value("${yobetittest.max.leave.days.peremployee}")
    int totalLeaveDaysAllowed;


    Byte isCancelled = Byte.parseByte("1");
    Byte isNotCancelled = Byte.parseByte("0");


    public static final Logger log = Logger.getLogger(LeaveHistoryService.class);

    @Transactional(readOnly = true)
    public List<LeaveHistory> getLeave() {

        log.info("Received request to return list of all Leave ");

        try {
            List<LeaveHistory> leaveHistoryList = new ArrayList<LeaveHistory>();
            List<LeaveHistoryEntity> leaveHistoryEntityList = leaveHistoryRepository.findAll();
            for (LeaveHistoryEntity leaveHistoryEntity : leaveHistoryEntityList) {
                StatusEntity statusEntity = statusRepository.findOne(leaveHistoryEntity.getStatus().getStatusId());
                EmployeeEntity employeeEntity = employeeRepository.findOne(leaveHistoryEntity.getEmployee().getEmployeeId());
                ManagerEntity managerEntity = managerRepository.findOne(leaveHistoryEntity.getManager().getManagerId());

                LeaveHistory leaveHistory = new LeaveHistory();
                leaveHistory.setLeavehistoryId(leaveHistoryEntity.getLeavehistoryId());
                leaveHistory.setStartDate(leaveHistoryEntity.getStartDate());
                leaveHistory.setHours(leaveHistoryEntity.getHours());
                leaveHistory.setApprovalDate(leaveHistoryEntity.getApprovalDate());
                leaveHistory.setRequestDate(leaveHistoryEntity.getRequestDate());
                leaveHistory.setEmployee(employeeEntity);
                leaveHistory.setStatus(statusEntity);
                leaveHistory.setManager(managerEntity);
                leaveHistoryList.add(leaveHistory);
            }
            log.info("A total of " + leaveHistoryList.size() + " leave applications were returned ");

            return leaveHistoryList;
        } catch (Exception e) {
            log.error("Leave listing failed, Exception thrown ", e);
        }

        return null;
    }


    @Transactional(readOnly = true)
    public List<LeaveHistory> getLeaveByManager(String username) {

        log.info("Received request to return list of all Leave by Manager ");

        try {
            List<LeaveHistory> leaveHistoryList = new ArrayList<LeaveHistory>();
            EmployeeEntity employeeEntity1 = employeeRepository.findByUsername(username);
            ManagerEntity managerEntity1 = managerRepository.findByEmployee(employeeEntity1);

            List<LeaveHistoryEntity> leaveHistoryEntityList = leaveHistoryRepository.findByManager(managerEntity1);
            for (LeaveHistoryEntity leaveHistoryEntity : leaveHistoryEntityList) {
                StatusEntity statusEntity = statusRepository.findOne(leaveHistoryEntity.getStatus().getStatusId());
                EmployeeEntity employeeEntity = employeeRepository.findOne(leaveHistoryEntity.getEmployee().getEmployeeId());
                ManagerEntity managerEntity = managerRepository.findOne(leaveHistoryEntity.getManager().getManagerId());

                LeaveHistory leaveHistory = new LeaveHistory();

                leaveHistory.setLeavehistoryId(leaveHistoryEntity.getLeavehistoryId());
                leaveHistory.setStartDate(leaveHistoryEntity.getStartDate());
                leaveHistory.setHours(leaveHistoryEntity.getHours());
                leaveHistory.setApprovalDate(leaveHistoryEntity.getApprovalDate());
                leaveHistory.setRequestDate(leaveHistoryEntity.getRequestDate());
                leaveHistory.setEmployee(employeeEntity);
                leaveHistory.setStatus(statusEntity);
                leaveHistory.setManager(managerEntity);
                leaveHistoryList.add(leaveHistory);
            }
            log.info("A total of " + leaveHistoryList.size() + " leave applications were returned ");

            return leaveHistoryList;
        } catch (Exception e) {
            log.error("Leave listing for manager " + username + " failed, Exception thrown ", e);
        }

        return null;
    }


    @Transactional(readOnly = true)
    public List<LeaveHistory> getPassedLeaveByEmployee(String username) {

        log.info("Received request to return list of utilized leave for user: " + username);

        try {
            List<LeaveHistory> leaveHistoryList = new ArrayList<LeaveHistory>();
            EmployeeEntity employeeEntity1 = employeeRepository.findByUsername(username);
            List<LeaveHistoryEntity> leaveHistoryEntityList = leaveHistoryRepository.findByEmployeeAndLeaveCancelled(employeeEntity1, isNotCancelled);
            for (LeaveHistoryEntity leaveHistoryEntity : leaveHistoryEntityList) {
                if (leaveHistoryEntity.getStartDate().before(new Date())) {
                    StatusEntity statusEntity = statusRepository.findOne(leaveHistoryEntity.getStatus().getStatusId());
                    EmployeeEntity employeeEntity = employeeRepository.findOne(leaveHistoryEntity.getEmployee().getEmployeeId());
                    ManagerEntity managerEntity = managerRepository.findOne(leaveHistoryEntity.getManager().getManagerId());

                    LeaveHistory leaveHistory = new LeaveHistory();

                    leaveHistory.setLeavehistoryId(leaveHistoryEntity.getLeavehistoryId());
                    leaveHistory.setStartDate(leaveHistoryEntity.getStartDate());
                    leaveHistory.setHours(leaveHistoryEntity.getHours());
                    leaveHistory.setApprovalDate(leaveHistoryEntity.getApprovalDate());
                    leaveHistory.setRequestDate(leaveHistoryEntity.getRequestDate());
                    leaveHistory.setEmployee(employeeEntity);
                    leaveHistory.setStatus(statusEntity);
                    leaveHistory.setManager(managerEntity);
                    leaveHistoryList.add(leaveHistory);
                }
            }
            log.info("A total of " + leaveHistoryList.size() + " leave applications were utilized by user: " + username);

            return leaveHistoryList;
        } catch (Exception e) {
            log.error("Leave listing for user: " + username + " failed, Exception thrown ", e);
        }

        return null;
    }


    @Transactional(readOnly = true)
    public List<LeaveHistory> getActiveLeaveByEmployee(String username) {

        log.info("Received request to return list of utilized leave for user: " + username);

        try {
            List<LeaveHistory> leaveHistoryList = new ArrayList<LeaveHistory>();
            EmployeeEntity employeeEntity1 = employeeRepository.findByUsername(username);
            List<LeaveHistoryEntity> leaveHistoryEntityList = leaveHistoryRepository.findByEmployeeAndLeaveCancelled(employeeEntity1, isNotCancelled);
            for (LeaveHistoryEntity leaveHistoryEntity : leaveHistoryEntityList) {

                    StatusEntity statusEntity = statusRepository.findOne(leaveHistoryEntity.getStatus().getStatusId());
                    EmployeeEntity employeeEntity = employeeRepository.findOne(leaveHistoryEntity.getEmployee().getEmployeeId());
                    ManagerEntity managerEntity = managerRepository.findOne(leaveHistoryEntity.getManager().getManagerId());

                    LeaveHistory leaveHistory = new LeaveHistory();

                    leaveHistory.setLeavehistoryId(leaveHistoryEntity.getLeavehistoryId());
                    leaveHistory.setStartDate(leaveHistoryEntity.getStartDate());
                    leaveHistory.setHours(leaveHistoryEntity.getHours());
                    leaveHistory.setApprovalDate(leaveHistoryEntity.getApprovalDate());
                    leaveHistory.setRequestDate(leaveHistoryEntity.getRequestDate());
                    leaveHistory.setEmployee(employeeEntity);
                    leaveHistory.setStatus(statusEntity);
                    leaveHistory.setManager(managerEntity);
                    leaveHistoryList.add(leaveHistory);

            }
            log.info("A total of " + leaveHistoryList.size() + " leave applications were applied by user: " + username);

            return leaveHistoryList;
        } catch (Exception e) {
            log.error("Leave listing for user: " + username + " failed, Exception thrown ", e);
        }

        return null;
    }


    @Transactional(readOnly = true)
    public List<LeaveHistory> getCancelledLeaveByEmployee(String username) {

        log.info("Received request to return list of cancelled leave for user: " + username);

        try {
            List<LeaveHistory> leaveHistoryList = new ArrayList<LeaveHistory>();
            EmployeeEntity employeeEntity1 = employeeRepository.findByUsername(username);
            List<LeaveHistoryEntity> leaveHistoryEntityList = leaveHistoryRepository.findByEmployeeAndLeaveCancelled(employeeEntity1, isCancelled);
            for (LeaveHistoryEntity leaveHistoryEntity : leaveHistoryEntityList) {

                StatusEntity statusEntity = statusRepository.findOne(leaveHistoryEntity.getStatus().getStatusId());
                EmployeeEntity employeeEntity = employeeRepository.findOne(leaveHistoryEntity.getEmployee().getEmployeeId());
                ManagerEntity managerEntity = managerRepository.findOne(leaveHistoryEntity.getManager().getManagerId());

                LeaveHistory leaveHistory = new LeaveHistory();

                leaveHistory.setLeavehistoryId(leaveHistoryEntity.getLeavehistoryId());
                leaveHistory.setStartDate(leaveHistoryEntity.getStartDate());
                leaveHistory.setHours(leaveHistoryEntity.getHours());
                leaveHistory.setApprovalDate(leaveHistoryEntity.getApprovalDate());
                leaveHistory.setRequestDate(leaveHistoryEntity.getRequestDate());
                leaveHistory.setEmployee(employeeEntity);
                leaveHistory.setStatus(statusEntity);
                leaveHistory.setManager(managerEntity);
                leaveHistoryList.add(leaveHistory);

            }
            log.info("A total of " + leaveHistoryList.size() + " leave applications were cancelled by user: " + username);

            return leaveHistoryList;
        } catch (Exception e) {
            log.error("Cancelled Leave listing for user: " + username + " failed, Exception thrown ", e);
        }

        return null;
    }


    @Transactional(readOnly = true)
    public List<LeaveHistory> getFutureLeaveByEmployee(String username) {

        log.info("Received request to return list of utilized leave for user: " + username);

        try {
            List<LeaveHistory> leaveHistoryList = new ArrayList<LeaveHistory>();
            EmployeeEntity employeeEntity1 = employeeRepository.findByUsername(username);
            List<LeaveHistoryEntity> leaveHistoryEntityList = leaveHistoryRepository.findByEmployeeAndLeaveCancelled(employeeEntity1, isNotCancelled);
            for (LeaveHistoryEntity leaveHistoryEntity : leaveHistoryEntityList) {
                if (leaveHistoryEntity.getStartDate().after(new Date())) {
                    StatusEntity statusEntity = statusRepository.findOne(leaveHistoryEntity.getStatus().getStatusId());
                    EmployeeEntity employeeEntity = employeeRepository.findOne(leaveHistoryEntity.getEmployee().getEmployeeId());
                    ManagerEntity managerEntity = managerRepository.findOne(leaveHistoryEntity.getManager().getManagerId());

                    LeaveHistory leaveHistory = new LeaveHistory();

                    leaveHistory.setLeavehistoryId(leaveHistoryEntity.getLeavehistoryId());
                    leaveHistory.setStartDate(leaveHistoryEntity.getStartDate());
                    leaveHistory.setHours(leaveHistoryEntity.getHours());
                    leaveHistory.setApprovalDate(leaveHistoryEntity.getApprovalDate());
                    leaveHistory.setRequestDate(leaveHistoryEntity.getRequestDate());
                    leaveHistory.setEmployee(employeeEntity);
                    leaveHistory.setStatus(statusEntity);
                    leaveHistory.setManager(managerEntity);
                    leaveHistoryList.add(leaveHistory);
                }
            }
            log.info("A total of " + leaveHistoryList.size() + " leave applications were utilized by user: " + username);

            return leaveHistoryList;
        } catch (Exception e) {
            log.error("Leave listing for user: " + username + " failed, Exception thrown ", e);
        }

        return null;
    }


    @Transactional
    public LeaveResponse addLeave(LeaveHistoryEntity leaveHistoryEntity, String username) {


        try {


            log.info("Adding " + leaveHistoryEntity.toString());
            EmployeeEntity employeeEntity = employeeRepository.findByUsername(username);

            double leavebalance = employeeEntity.getEmployeeBalance() - leaveHistoryEntity.getHours();
            if (leavebalance >= 0) {
                employeeEntity.setEmployeeBalance(leavebalance);
                employeeRepository.save(employeeEntity);
                DepartmentEntity departmentEntity = departmentRepository.findOne(employeeEntity.getDepartment().getDepartmentId());
                ManagerEntity managerEntity = managerRepository.findByDepartment(departmentEntity);
                StatusEntity statusEntity = statusRepository.findOne(initialStatus);

                leaveHistoryEntity.setManager(managerEntity);
                leaveHistoryEntity.setEmployee(employeeEntity);
                leaveHistoryEntity.setStatus(statusEntity);
                leaveHistoryEntity.setRequestDate(getTimeStamp());
                leaveHistoryEntity.setLeaveCancelled(isNotCancelled);

                leaveHistoryRepository.save(leaveHistoryEntity);
                log.info("Leave added successfully for employee " + employeeEntity.getEmployeeName() + " " + employeeEntity.getEmployeeSurname());

                return new LeaveResponse(leavebalance, true);
            } else {
                log.info("Leave added not successfully for employee " + employeeEntity.getEmployeeName() + " " + employeeEntity.getEmployeeSurname() + " not enough leave balance");
                return new LeaveResponse(leavebalance, false);
            }

        } catch (Exception e) {
            log.error("Leave creation failed for " + username + ", Exception thrown ", e);
        }

        return null;
    }


    @Transactional
    public LeaveResponse cancelLeave(int leaveId, String username) {
        try {
            log.info("Cancelling leave with id: " + leaveId + " for user: " + username);
            LeaveHistoryEntity leaveHistoryEntity = leaveHistoryRepository.findOne(leaveId);
            EmployeeEntity employeeEntity = employeeRepository.findByUsername(username);
            double newLeaveBalance = employeeEntity.getEmployeeBalance() + leaveHistoryEntity.getHours();
            log.info("New Balance " + newLeaveBalance);
            employeeEntity.setEmployeeBalance(newLeaveBalance);
            employeeRepository.save(employeeEntity);
            leaveHistoryEntity.setLeaveCancelled(isCancelled);
            leaveHistoryEntity.setStatus(statusRepository.findOne(cancelledStatus));
            leaveHistoryRepository.save(leaveHistoryEntity);
            log.info("LeaveId: " + leaveId + " succesfully deleted for user: " + username);
            return new LeaveResponse(true, newLeaveBalance);
        } catch (Exception e) {
            log.error("Delete failed for LeaveId: " + leaveId + ", Exception thrown ", e);
            return new LeaveResponse(false);
        }
    }

    @Transactional(readOnly = true)
    public List<LeaveOverdue> getOverdueLeaveByEmployee(String username) {

        log.info("Received request to return list of overdue leave for user: " + username);
        String month = null;

        List<LeaveHistory> leaveHistoryList = getActiveLeaveByEmployee(username);
        HashMap<String, Double> overdueMatrix = new HashMap<String, Double>();

        for (LeaveHistory leaveHistory : leaveHistoryList) {
            Calendar cal = new GregorianCalendar();
            cal.setTime(leaveHistory.getStartDate());

            Double leaveInDays = leaveHistory.getHours() / hoursPerDay;
            month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
            if (overdueMatrix.containsKey(month)) {
                leaveInDays = leaveInDays + overdueMatrix.get(month);
            }

            overdueMatrix.put(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH), leaveInDays);

        }
        List<LeaveOverdue> leaveOverdueList = new ArrayList<LeaveOverdue>();
        int leavePerMonth = totalLeaveDaysAllowed / 12;
        for (Map.Entry<String, Double> map : overdueMatrix.entrySet()) {
            LeaveOverdue leaveOverdue = new LeaveOverdue();
            if (map.getValue() > leavePerMonth) {
                leaveOverdue.setIsOverdue(true);
                leaveOverdue.setTotalOverdueDays(map.getValue() - leavePerMonth);
            } else {
                leaveOverdue.setIsOverdue(false);
                leaveOverdue.setTotalOverdueDays(Double.parseDouble("0"));
            }
            leaveOverdue.setMonth(map.getKey());
            leaveOverdue.setLeaveDays(map.getValue());
            leaveOverdueList.add(leaveOverdue);

        }


        log.info("Leave overdue calculation completed succesfully for user: " + username);

        return leaveOverdueList;

    }


    @Transactional(readOnly = true)
    public List<LeaveHistoryEntity> getCurrentMonthLeave() {
        log.info("Received request to return list dor current month");
        try {
            List<LeaveHistoryEntity> leaveHistoryList = leaveHistoryRepository.findByLeaveCancelled(isNotCancelled);
            List<LeaveHistoryEntity> leaveHistoryList1 = new ArrayList<LeaveHistoryEntity>();
            String currentMonth = null;
            for (LeaveHistoryEntity leaveHistory : leaveHistoryList) {
                Calendar cal = new GregorianCalendar();
                cal.setTime(leaveHistory.getStartDate());

                Calendar cal2 = new GregorianCalendar();
                cal2.setTime(new Date());
                currentMonth = cal2.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);

                if (currentMonth.equals(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH))) {
                    leaveHistoryList1.add(leaveHistory);
                }
            }

            log.info("A total of " + leaveHistoryList.size() + " leave applications for the month of " + currentMonth + " were returned");

            return leaveHistoryList1;
        } catch (Exception e) {
            log.error("Get current month leave list failed, Exception thrown ", e);
            return null;
        }
    }


    private Timestamp getTimeStamp() {
        Date utilDate = new java.util.Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(utilDate);
        cal.set(Calendar.MILLISECOND, 0);
        return new Timestamp(utilDate.getTime());
    }
}
