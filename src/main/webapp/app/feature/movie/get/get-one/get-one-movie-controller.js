(function() {

    var GetOneMovieController =  function($state, userFactory, movieDal, $stateParams, $sce, bookingFactory, showingDal) {
        var vm = this;

        function getOneMovie() {
            movieDal.getMovieById($stateParams.idMovie).then(function (results) {
                vm.movie = results;
                vm.trustedURL = $sce.trustAsResourceUrl(results.trailerURL);
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
        getOneMovie();

        vm.getTrailer = function getTrailer(src, $sce){
        }

vm.loginCheck = function(){
			
			console.log(userFactory.loggedIn())
			if(userFactory.loggedIn() === false){
				userFactory.loginGateCheck = 1;
				$state.go("adduser");
			}
			else{
				$state.go("createbooking")}
		}

        vm.saveBooking = function (booking){

            bookingFactory.set(booking);
        }

        function getShowingsforMovie(){
	   showingDal.getShowingsForMovie($stateParams.idMovie,1).then(function (results){
		   vm.showings = results;
	   }, function(error){
                vm.error = true;
                vm.errorMessage = error;
            });
	   }
	   getShowingsforMovie()
   }

    
    angular.module('movieApp').controller('getOneMovieController', ['$state','userFactory','movieDal', '$stateParams', '$sce', 'bookingFactory', 'showingDal', GetOneMovieController])

}());