app.controller('usersController', function($scope) {
    $scope.headingTitle = "User List";
});

app.controller('rolesController',function($scope,RoleService) {
    $scope.headingTitle = "Roles List";
    $scope.roles = RoleService.findRoles();
    console.log(RoleService.findRoles());
});
