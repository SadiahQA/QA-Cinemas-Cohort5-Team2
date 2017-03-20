(function(){
	
	var IndexController = function(userFactory){
		var vm = this;
		
		vm.user = userFactory.get();
	
	vm.isLoggedIn = function(){
		return userFactory.loggedIn();
	};
	}
	
	
	
	angular.module('movieApp').controller('indexController',['userFactory',IndexController])
}());