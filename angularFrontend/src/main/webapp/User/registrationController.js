app.controller('registrationController', function($scope,$rootScope,$http,$location)
{	
	$scope.user={userId:0,username:'',emailId:'',firstName:'',lastName:'',password:'',role:'',status:'',isOnline:''}
	$scope.registerUser=function()
	{
		console.log('Entered into registerUser');
		$http.post("http://localhost:8080/angularFrontend/#/regis")
		.then(function(response)
		{
			$scope.user=response.data;
			$location.path("/addUser");
			$http.put("http://localhost:8080/angularFrontend/addUser");
			console.log('Successfully Register User');
		});
	};
});
