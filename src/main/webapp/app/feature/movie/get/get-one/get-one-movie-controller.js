(function() {

    var GetOneMovieController =  function(movieDal, $stateParams, $sce, bookingFactory, showingDal, cinemaFactory) {
        var vm = this;

        function getOneMovie() {
            movieDal.getMovieById($stateParams.idMovie).then(function (results) {
                vm.movie = results;
                vm.trustedURL = $sce.trustAsResourceUrl(results.trailerURL);
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
            vm.idCinema = cinemaFactory.get();
        }
        getOneMovie();



        vm.saveBooking = function (booking){

            bookingFactory.set(booking);
        }

        function getShowingsforMovie(){
	   showingDal.getShowingsForMovie($stateParams.idMovie,cinemaFactory.get()).then(function (results){
		   vm.showings = results;
	   }, function(error){
                vm.error = true;
                vm.errorMessage = error;
            });
	   }
	   getShowingsforMovie()
   }

    
    angular.module('movieApp').controller('getOneMovieController', ['movieDal', '$stateParams', '$sce', 'bookingFactory', 'showingDal', 'cinemaFactory', GetOneMovieController])

}());