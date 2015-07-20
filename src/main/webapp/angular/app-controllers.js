'use strict';
angular.module('controllers', ['services']).
    controller('Myctrl1Controller', ['$scope', 'Employees', '$location', function ($scope, Employees, $location) {
        $scope.allemployees = Employees.query();

        $scope.viewEmployee = function (employeeId) {
            $location.path('/employee-detail/' + employeeId);
        };
        $scope.viewEmployeeCredentials = function (employeeId) {
            $location.path('/employee-credentials/' + employeeId);
        };


    }]).
    controller('Myctrl2Controller', ['$scope', 'AddEmployee', 'Departments', 'Groups', '$location',
        function ($scope, AddEmployee, Departments, Groups, $location) {

            $scope.allDepartments = Departments.query();
            $scope.allGroups = Groups.query();

            $scope.createNewUser = function () {
                AddEmployee.create($scope.employee);
                $location.path('/employee-list');
            }


        }]).
    controller('UsernameController', ['$scope', 'Username', function ($scope, Username) {
        $scope.user = Username.show();

    }]).
    controller('ViewEmployeeController', ['$scope', 'EmployeeById', '$routeParams',
        function ($scope, EmployeeById, $routeParams) {
            $scope.employee = EmployeeById.show({id: $routeParams.id});

        }]).

    controller('ViewEmployeeCredentialsController', ['$scope', 'EmployeeCredentials', '$routeParams',
        function ($scope, EmployeeCredentials, $routeParams) {
            $scope.employee = EmployeeCredentials.show({id: $routeParams.id});

        }]).
    controller('ViewAllLeaveController', ['$scope', 'LeaveList',
        function ($scope, LeaveList) {
            $scope.leaveentries = LeaveList.query();

        }]).
    controller('ViewManagerLeaveController', ['$scope', 'LeaveManagerList',
        function ($scope, LeaveList) {
            $scope.leaveentries = LeaveList.query();

        }]).
    controller('ViewPassedLeaveController', ['$scope', 'LeavePassedList',
        function ($scope, LeaveList) {
            $scope.leaveentries = LeaveList.query();

        }]).
    controller('ViewFutureLeaveController', ['$scope', 'LeaveFutureList', 'LeaveCancel',
        function ($scope, LeaveList, LeaveCancel) {
            $scope.leaveentries = LeaveList.query();
            $scope.cancelLeave = function (leavehistoryId) {
                LeaveCancel.cancel({id: leavehistoryId});
                $scope.leaveentries = LeaveList.query();
                $scope.apply;
                $location.path('/leave-future-list.html');
            }

        }]).
    controller('ViewOverdueLeaveController', ['$scope', 'LeaveOverdueList',
        function ($scope, LeaveList) {
            $scope.leaveentries = LeaveList.query();

        }]).
    controller('ViewCancelledLeaveController', ['$scope', 'LeaveCancelledList',
        function ($scope, LeaveList) {
            $scope.leaveentries = LeaveList.query();

        }]).
    controller('ViewMonthLeaveController', ['$scope', 'LeaveMonthList',
        function ($scope, LeaveList) {
            $scope.leaveentries = LeaveList.query();

        }]).
    controller('CreateLeaveController', ['$scope', 'AddLeave', '$location',
        function ($scope, AddLeave, $location) {

             $scope.createNewLeave = function () {
                AddLeave.create($scope.leave);
                $location.path('/leave-future-list.html');
            }
       }]).

controller('ViewEmployeeDetailsController', ['$scope', 'EmployeeDetails',
    function ($scope, EmployeeDetails) {
        $scope.employee = EmployeeDetails.show();


    }]);












