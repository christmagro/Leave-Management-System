'use strict';
var services = angular.module('services', ['ngResource']);

services.factory('Employees', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/v1/employee/getAll', {}, {
        query: {method: 'GET', isArray: true}

    });
}]);


services.factory('AddEmployee', ['$resource', function ($resource) {

    var saveEmployee = $resource('http://localhost:8080/v1/employee/add', {}, {
        create: {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            }
        }
    });

    return saveEmployee;
}]);


services.factory('Departments', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/v1/department/getAll', {}, {
        query: {method: 'GET', isArray: true}

    });
}]);

services.factory('Groups', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/v1/group/getAll', {}, {
        query: {method: 'GET', isArray: true}

    });
}]);


services.factory('Username', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/v1/employee/username', {}, {
        show: {method: 'GET'}

    });
}]);

services.factory('EmployeeById', ['$resource', function ($resource) {
    return $resource('/v1/employee/getEmployee/:id', {}, {
        show: {method: 'GET', params: {id: '@id'}}

    });
}]);


services.factory('EmployeeCredentials', ['$resource', function ($resource) {
    return $resource('/v1/employee/getEmployeePassword/:id', {}, {
        show: {method: 'GET', params: {id: '@id'}}

    });
}]);


services.factory('LeaveList', ['$resource', function ($resource) {
    return $resource('/v1/leave/getAll', {}, {
        show: {method: 'GET'}

    });
}]);

services.factory('LeaveManagerList', ['$resource', function ($resource) {
    return $resource('/v1/leave/getAllByManager', {}, {
        show: {method: 'GET'}
    });
}]);
services.factory('LeavePassedList', ['$resource', function ($resource) {
    return $resource('/v1/leave/getPassedLeaveByEmployee', {}, {
        show: {method: 'GET'}
    });
}]);

services.factory('LeaveFutureList', ['$resource', function ($resource) {
    return $resource('/v1/leave/getFutureLeaveByEmployee', {}, {
        show: {method: 'GET'}
    });
}]);

services.factory('LeaveOverdueList', ['$resource', function ($resource) {
    return $resource('/v1/leave/getOverdueLeaveByEmployee', {}, {
        show: {method: 'GET'}
    });
}]);

services.factory('LeaveCancelledList', ['$resource', function ($resource) {
    return $resource('/v1/leave/getCancelledLeaveByEmployee', {}, {
        show: {method: 'GET'}
    });
}]);
services.factory('LeaveMonthList', ['$resource', function ($resource) {
    return $resource('/v1/leave/getCurrentMonthLeave', {}, {
        show: {method: 'GET'}
    });
}]);

services.factory('AddLeave', ['$resource', function ($resource) {

    var saveLeave = $resource('http://localhost:8080/v1/leave/add', {}, {
        create: {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            }
        }
    });

    return saveLeave;
}]);

services.factory('LeaveCancel', ['$resource', function ($resource) {
    return $resource('/v1/leave/delete/:id', {}, {
        cancel: {
            method: 'DELETE',
            params: {id: '@id'}
        }
    });
}]);

services.factory('EmployeeDetails', ['$resource', function ($resource) {
    return $resource('v1/employee/getEmployeeByUsername', {}, {
        show: {method: 'GET'}

    });
}]);








