(function() {

    var HomeController =  function($state, movieDal, ticketDal, showingDal,  userDal, cinemaDal, bookingFactory, userFactory, cinemaFactory) {

        var vm = this;

        function init() {
            movieDal.getCurrentMovies().then(function (results) {
                vm.movies  = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
            vm.idCinema = cinemaFactory.get();
        }
        init();

        vm.addTicket = function(ticketToAdd) {
            ticketDal.createTicket(ticketToAdd).then(function (results) {
                vm.ticket  = results;

            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }


        vm.getShowings = function (idMovie){

            showingDal.getShowingsForMovie(idMovie, cinemaFactory.get()).then(function (results){
                vm.showings  = results;
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

            var loginGate = function(){
    			if (userFactory.loggedIn() === false){
    				userFactory.loginGateCheck = 1;
    				$state.go('adduser');
    			}
    			else{$state.go('createbooking')}
    		}
    		loginGate();
        }

        vm.user = userFactory.get();
    };





    angular.module('movieApp').controller('homeController', ['$state','movieDal','ticketDal','showingDal','userDal', 'cinemaDal', 'bookingFactory', 'userFactory', 'cinemaFactory', HomeController]);

}());