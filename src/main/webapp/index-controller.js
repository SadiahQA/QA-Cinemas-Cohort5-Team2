(function(){
	
	var IndexController = function(userFactory){
	var vm = this;
	
	vm.loggedIn = userFactory.get();
	}
	
	
	
	angular.module('movieApp').controller('indexController',['userFactory',IndexController])
}());