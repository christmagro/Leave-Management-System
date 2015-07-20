/**
 * The script holds the configs for the client Angular module..
 * Configs include :
 *  - Bean injections
 *  - Routing configurations and mappings
 *
 * @type {module}
 */

var yobetitTestApp = angular.module('yobetitTestApp', ['ngRoute', 'services', 'controllers']);

yobetitTestApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.
            when('/', {
                templateUrl: '/views/leave-future-list.html',
                controller: 'ViewFutureLeaveController'
            }).

            when('/create-employee', {
                templateUrl: '/views/create-employee.html',
                controller: 'Myctrl2Controller'
            }).
            when('/employee-list', {
                templateUrl: '/views/employee-list.html',
                controller: 'Myctrl1Controller'
            }).
            when('/employee-detail/:id', {
                templateUrl: '/views/employee-detail.html',
                controller: 'ViewEmployeeController'
            }).
            when('/employee-credentials/:id', {
                templateUrl: '/views/employee-credentials.html',
                controller: 'ViewEmployeeCredentialsController'
            }).
            when('/employee-personal-details', {
                templateUrl: '/views/employee-detail.html',
                controller: 'ViewEmployeeDetailsController'
            }).

            when('/leave-list', {
                templateUrl: '/views/leave-list.html',
                controller: 'ViewAllLeaveController'
            }).
            when('/leave-manager-list', {
                templateUrl: '/views/leave-manager-list.html',
                controller: 'ViewManagerLeaveController'
            }).
            when('/leave-passed-list', {
                templateUrl: '/views/leave-manager-list.html',
                controller: 'ViewPassedLeaveController'
            }).
            when('/leave-future-list', {
                templateUrl: '/views/leave-future-list.html',
                controller: 'ViewFutureLeaveController'
            }).
            when('/leave-overdue-list', {
                templateUrl: '/views/leave-overdue-list.html',
                controller: 'ViewOverdueLeaveController'
            }).
            when('/leave-cancelled-list', {
                templateUrl: '/views/leave-cancelled-list.html',
                controller: 'ViewCancelledLeaveController'
            }).
            when('/leave-month-list', {
                templateUrl: '/views/leave-month-list.html',
                controller: 'ViewMonthLeaveController'
            }).
            when('/create-leave', {
                templateUrl: '/views/create-leave.html',
                controller: 'CreateLeaveController'
            }).
            otherwise({
                redirectTo: '/'
            });
    }]);



