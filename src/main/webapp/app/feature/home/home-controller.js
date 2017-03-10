(function() {

    var HomeController =  function(movieDal) {
        var vm = this;

        function startCarousel(){
            $('#myCarousel').carousel({interval: 3000});
        };

        function init() {
            movieDal.getCurrentMovies().then(function (results) {
                vm.movies  = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
        init();
        startCarousel();
    };

    angular.module('movieApp').controller('homeController', ['movieDal', HomeController]);
}());