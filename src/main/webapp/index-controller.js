(function(){
	
	var IndexController = function(userFactory){
		var vm = this;
		
		vm.user = userFactory.get();
	
	vm.isLoggedIn = function(){
		return userFactory.loggedIn();
	};
	
	vm.logout = function(){
		userFactory.logOut();
		window.alert("Logged out successfully")
		vm.loggedIn = userFactory.get();
		vm.compare = (JSON.stringify(vm.loggedIn));
	};	
	}
	
	angular.module('movieApp').controller('indexController',['userFactory',IndexController])
}());