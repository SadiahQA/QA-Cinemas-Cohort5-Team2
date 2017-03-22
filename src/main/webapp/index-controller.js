(function(){
	
	var IndexController = function(userFactory, cinemaDal, cinemaFactory, $state){
		var vm = this;
		
		vm.user = userFactory.get();


        function getCinemas() {
            cinemaDal.getAllCinemas().then(function (results) {
                vm.cinemas = results;
                vm.idCinema = cinemaFactory.get();
                if(!vm.idCinema){
                	vm.idCinema = 2;
                	cinemaFactory.set(vm.idCinema);
				}
				if (navigator.geolocation) {
                	navigator.geolocation.getCurrentPosition(showPosition);
				}
                for(var i in vm.cinemas){
                	if(vm.cinemas[i].idCinema == vm.idCinema){
                		vm.cinema = vm.cinemas[i];
					}
				}
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
        getCinemas();

        vm.setCinema = function setCinema(cinema){
        	var cinemaObject = JSON.parse((cinema));
        	cinemaFactory.set(cinemaObject.idCinema);
            vm.idCinema = cinemaObject.idCinema;
            vm.cinema = cinemaObject;
        	$state.reload();
		}

		function getLocation(){
            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(showPosition);
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