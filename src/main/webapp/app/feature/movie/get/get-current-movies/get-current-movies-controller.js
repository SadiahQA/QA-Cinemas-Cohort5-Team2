(function() {

    var GetCurrentMovieController =  function(movieDal) {
        var vm = this;

        function init() {
            movieDal.getCurrentMovies().then(function (results) {
                vm.movies  = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
        init();
    };

    angular.module('movieApp').controller('getCurrentMovieController', ['movieDal', GetCurrentMovieController]);
}());