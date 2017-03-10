(function() {

    var GetOneMovieController =  function(movieDal, $stateParams) {
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
    };

    angular.module('movieApp').controller('getOneMovieController', ['movieDal', '$stateParams', GetOneMovieController]);
}());