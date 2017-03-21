(function(){
	
	var IndexController = function(userFactory, cinemaDal, cinemaFactory, $state){
		var vm = this;
		
		vm.user = userFactory.get();

        function getCinemas() {
            cinemaDal.getAllCinemas().then(function (results) {
                vm.cinemas = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
        getCinemas();

        vm.setCinema = function(idCinema){
        	console.log(idCinema);
        	cinemaFactory.set(idCinema);
        	$state.reload();
		}
	
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
	
	angular.module('movieApp').controller('indexController',['userFactory','cinemaDal','cinemaFactory','$state',IndexController])
}());