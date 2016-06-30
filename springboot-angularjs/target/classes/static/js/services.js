app.service('RoleService',function($http){
	/*findRoles:function(){
		$http.get('http://localhost:8080/roles')
			.then(function(response){
				return response.data;
			});
	};*/
	return{
		findRoles:function(){
			$http.get('http://localhost:8080/roles')
			.then(function(response){
				return response.data;
			});
		}
	}
});