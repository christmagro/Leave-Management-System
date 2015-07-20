
controllers.controller('EmployeeController', ['$scope', 'EmployeeFactory', '$location', function($scope, EmployeeFactory){

    $scope.employees = EmployeeFactory.query();

}]);