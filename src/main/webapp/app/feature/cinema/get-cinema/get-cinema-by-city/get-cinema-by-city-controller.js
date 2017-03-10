(function(){
	
	var GetCinemaByCityController = function(cinemaDal, $stateParams){
		
		var vm = this;
		function findOneCinema(){
		vm.cinema = cinemaDal.getCinemaByCity($stateParams.cinemaCity)
		function getCinemaByCity(){
		cinemaDal.findByCity(cinemaToGet).then(function (results){
			vm.cinemaMessage = results;
		}, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
		}
		}
		findOneCinema();
	}
	angular.module('movieApp').controller('getCinemaByCityController',['cinemaDal', GetCinemaByCityController]);
}());