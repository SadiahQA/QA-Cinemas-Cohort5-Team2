(function() {

    var AddTicketController =  function( ticketDal, showingDal, movieDal, userDal) {
        var vm = this;

        vm.addTicket = function(ticketToAdd) {
            console.log("This is the ticket to add " + ticketToAdd);
            console.log(ticketToAdd);
            var ticketToJson = JSON.stringify(ticketToAdd);
            console.log(ticketToJson);
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

        vm.getUser = function (userEmail) {

            userDal.getUserIdByEmail(userEmail).then(function(results) {
                console.log("runs this far");
                vm.idUser = results;

            }, function(error){
                vm.error = true;
                vm.errorMessage = error;
            })

        }


    };

    angular.module('movieApp').controller('addTicketController', [ 'ticketDal','showingDal','movieDal','userDal', AddTicketController]);
}());