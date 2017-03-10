(function(){
	
	var GetAllCinemaController = function(cinemaDal){
		
		var mv = this;
		
		function init(){
			cinemaDal.getAllCinemas().then(function(results){
				vm.movies = results;
			}, function (error){
				vm.error = true;
				vm.errorMessage = error;
			});
			
		}
		init();
	};
	
	angular.module('movieApp').controller('getAllCinemaController',['cinemaDal', GetAllCinemaController]);
}());