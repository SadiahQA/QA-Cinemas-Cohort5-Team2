(function() {

    var GetFutureMovieController =  function(movieDal) {
        var vm = this;

        function goToMoviePage(targetId){
            $state.go('getonemovie', {movieId : targetId })
        }

        function init() {
            movieDal.getFutureMovies().then(function (results) {
                vm.movies  = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
        init();
    };

    angular.module('movieApp').controller('getFutureMovieController', ['movieDal', GetFutureMovieController]);
}());