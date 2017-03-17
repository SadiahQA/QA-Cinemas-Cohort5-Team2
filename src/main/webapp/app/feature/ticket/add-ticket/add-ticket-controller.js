(function() {

    var AddTicketController =  function( ticketDal, showingDal, movieDal, userDal, bookingFactory) {
        var vm = this;

        vm.addTicket = function(ticketToAdd) {
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
                console.log(vm.idUser);

            }, function(error){
                vm.error = true;
                vm.errorMessage = error;
            })

        }
        
        vm.saveBooking = function (booking){
        	
        	bookingFactory.set(booking);
        }


    };

    angular.module('movieApp').controller('addTicketController', [ 'ticketDal','showingDal','movieDal','userDal', 'bookingFactory', AddTicketController]);
}());