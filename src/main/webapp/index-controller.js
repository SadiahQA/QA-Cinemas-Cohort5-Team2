(function(){
	
	var IndexController = function(userFactory, cinemaDal, cinemaFactory, $state){
		var vm = this;
		
		vm.user = userFactory.get();
		vm.cinemas;


        function getCinemas() {
            cinemaDal.getAllCinemas().then(function (results) {
                vm.cinemas = results;
                vm.idCinema = cinemaFactory.get();
                if (navigator.geolocation) {
                    navigator.geolocation.getCurrentPosition(showPosition);
                }
                vm.idCinema = cinemaFactory.get();
                if(!vm.idCinema){
                	vm.idCinema = 2;
                	cinemaFactory.set(vm.idCinema);
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
            var lat = position.coords.latitude;
			var long = position.coords.longitude;

			var shortest = Number.MAX_VALUE
			var closestCinema;
			for(var i in vm.cinemas){
				var difLat = vm.cinemas[i].latitude - lat;
                var difLong = vm.cinemas[i].longitude - long;
                var dif = Math.sqrt((difLat*difLat)+(difLong*difLong));
                if(dif<shortest){
                	shortest = dif;
                	
                	closestCinema = vm.cinemas[i];
				}
				
			}
			
            cinemaFactory.set(closestCinema.idCinema);
            vm.idCinema = closestCinema.idCinema;
            vm.cinema = closestCinema;
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

        $('#myModal').modal(focus)

	}
	
	angular.module('movieApp').controller('indexController',['userFactory','cinemaDal','cinemaFactory','$state',IndexController])
}());
