(function() {

    var GetOneMovieController =  function(movieDal, $stateParams, showingDal) {
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
    
    angular.module('movieApp').controller('getOneMovieController', ['movieDal', '$stateParams', 'showingDal', GetOneMovieController])

}());