(function() {

    var AddTicketController =  function($state, ticketDal) {
        var vm = this;

        vm.addTicket = function(ticketToAdd) {
            console.log("This is the ticket to add " + ticketToAdd);
            console.log(ticketToAdd);
            var ticketToJson = JSON.stringify(ticketToAdd);
            console.log(ticketToJson);
            ticketDal.createTicket(ticketToAdd).then(function (results) {
                vm.ticket  = results;
                $state.go('getticket');
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }

    };

    angular.module('movieApp').controller('addTicketController', ['$state','ticketDal',AddTicketController]);
}());