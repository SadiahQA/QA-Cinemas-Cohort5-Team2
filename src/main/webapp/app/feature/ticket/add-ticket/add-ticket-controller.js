(function() {

    var AddTicketController =  function( ticketDal, showingDal, movieDal) {
        var vm = this;

        vm.addTicket = function(ticketToAdd) {
            var ticketToJson = JSON.stringify(ticketToAdd);
            ticketDal.createTicket(ticketToAdd).then(function (results) {
                vm.ticket  = results;

            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
        vm.getShowings = function (theMovieId) {



            showingDal.getShowingsForMovie(theMovieId, 1).then(function (results) {
                vm.showings = results;

            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
        vm.getMovies = function () {



            movieDal.getCurrentMovies().then(function (results) {
                vm.movies = results;

            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });

        }


    };

    angular.module('movieApp').controller('addTicketController', [ 'ticketDal','showingDal','movieDal', AddTicketController]);
}());