var app = angular.module('myApp', ['ngRoute']);

app.config(function($routeProvider, $locationProvider) {
  $locationProvider.hashPrefix('');
	$routeProvider

		.when('/', {
			templateUrl : 'Home/home.html',
			controller  : 'homeController'
		})
		
		.when('/login', {
			templateUrl : 'User/login.html',
			controller  : 'loginController'
		})
		
		.when('/registration', {
			templateUrl : 'User/registration.html',
			controller  : 'registrationController'
		})
		
		.when('/userHome', {
			templateUrl : 'User/userHome.html',
			controller  : 'userHomeController'
		});
});

app.controller('loginController', function($scope) {	
	$scope.message = 'WELCOME TO login PAGE';
});

app.controller('homeController', function($scope) {
	$scope.message = 'WELCOME TO HOME PAGE';
});

app.controller('loginController', function($scope) {	
	$scope.message = 'WELCOME TO login PAGE';
});

app.controller('userHomeController', function($scope) {	
	$scope.message = 'WELCOME TO User Home PAGE';
});