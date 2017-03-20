(function() {

    var GetOneMovieController =  function(movieDal, $stateParams, bookingFactory, showingDal) {
        var vm = this;

        function getOneMovie() {
            movieDal.getMovieById($stateParams.idMovie).then(function (results) {
                vm.movie = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
        getOneMovie();

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

    
    angular.module('movieApp').controller('getOneMovieController', ['movieDal', '$stateParams','bookingFactory', 'showingDal', GetOneMovieController])

}());