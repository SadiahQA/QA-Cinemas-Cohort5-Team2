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

        var x = document.getElementById("demo");

		vm.getLocation = function(){
            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(showPosition);
            } else {
                vm.idCinema = 2;
            }
		}
		function showPosition(position){
            vm.latitude = position.coords.latitude;
			vm.longitude = position.coords.longitude;
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

        $('#myModal').modal(focus)

	}
	
	angular.module('movieApp').controller('indexController',['userFactory','cinemaDal','cinemaFactory','$state',IndexController])
}());