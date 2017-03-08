(function() {

    var GetOneMovieController =  function(movieDal) {
        var vm = this;

        vm.movie = movieDal.getMovieById($stateParams.movieId)
        function getOneMovie() {
            movieDal.getMovieById().then(function (results) {
                vm.movie  = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
    };

    angular.module('movieApp').controller('getOneMovieController', ['movieDal', GetOneMovieController]);
}());