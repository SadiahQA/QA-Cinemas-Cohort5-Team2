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
            vm.idCinema = cinemaFactory.get();
        }
        getCinemas();

        vm.setCinema = function(idCinema){
        	cinemaFactory.set(idCinema);
            vm.idCinema = cinemaFactory.get();
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
	window.alert("To enhance your user experience this website uses cookies.")

	}
	
	angular.module('movieApp').controller('indexController',['userFactory','cinemaDal','cinemaFactory','$state',IndexController])
}());