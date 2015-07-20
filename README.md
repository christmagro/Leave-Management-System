# YoBetit Leave Test
A Leave module project created using Spring MVC &amp; Spring Data

This Application exposes a Rest Layer that accepts and returns messages is JSON format.

##System Main features consist in the following:

- Adding New users including returning random password generation and automated leave allocation based on the remaining days of the year.
- Leave booking and cancellation, with automated leave deduction(leave application) and added (leave cancellation) based on the action. If leave balance is not enough leave entry will not be succesfull.
- Listings of Leave applications for the following criteria per employee:
- Booked leaved that was used leave.
- Booked leave that has not been used.
- Cancelled booked leave.
- Overtaken leave per month.
- Leave listings of all employee leave applications for the current month.


##Availble Actions URLS

###Employee Related Actions

* /v1/employee/getEmployee/{id}  (Method Get) Returns a particular Employee by userID (for testing purposes use 1 as ID).
* /v1/employee/getAll            (Method Get) Returns a complete list of all Employees.
* /v1/employee/add               (Method Post) Accepts a post in JSON format containing all employee Data.

###Sample Add Employee Request (JSON)
'''json
{
    "employeeName": "foo",
    "employeeSurname": "bar",
    "username":"test",
    
    "department": {
        "departmentId": "1"
    },
    "group": {
        "groupId": "1"
    }
}
'''

###Leave Related Actions

* /v1/leave/getAll            (Method Get) Returns a list of leave entries for all users.
* /v1/leave/getAllByManager   (Method Get) Returns a list of leave entries for the current managers department employees ((based on the manager's username)).
* /v1/leave/getPassedLeaveByEmployee (Method Get) Returns a list of leave entries already taken by a particular employee (based on the employee username).
* /v1/leave/getFutureLeaveByEmployee (Method Get) Returns a list of leave entries that are not yet taken by a particular employee (based on the employee username).
* /v1/leave/getCancelledLeaveByEmployee (Method Get) Returns a list of leave entries that were cancelled by a particular employee (based on the employee username).
* /v1/leave/getOverdueLeaveByEmployee (Method Get) Returns a list containing a summary of leave taken per month illustrating any overdue leave taken per month by a particulae employee (based on the employee username).
* /v1/leave/getCurrentMonthLeave (Method Get) Returns a list of all the employees of the current month.
* /v1/leave/delete/{id} (Method Delete) This method flags a particular leave entry as cancelled based on the leave entry id.
* /v1/leave/add (Method Post) This method is used to create a new leave entry for an employee (based on employee username).

Sample
Sample Add Leave Request (JSON)
'''json
{
    "hours": 40,
    "startDate": 1449874800000
   }
'''

Application Properties, are located within the resources folder:
* log4j.properties
* yobetit-database.properties 
* yobetit-general.properties (General system properties such as leave per year, working hors per day & password size)

System can be deployed on Tomcat 7 and can be packaged in WAR file.

Additional Dependecies used:
* Spring Data - Used for querying the DB
* MySql - Requried library to connect with MySQL DB
* Hibernate - used to translate ORM to SQL 

Due to the fact that Spring Security is not implemented current users are set directly within the controllers (for testing purposes) however once spring security is implemented all user details will be automatically injected.

This application does not include a front end layer, however backend was designed to easly plug in a front end such as AngularJS.

SQL Script including all tables and data can be found in the project parent folder named YoBetit_Leave_StructureAndData.sql


