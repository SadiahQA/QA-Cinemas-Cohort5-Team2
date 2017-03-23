(function(){

    var GetTicketByShowingController = function(ticketDal, $stateParams){

        var vm = this;
        function findTicket(){

            ticketDal.findByShowingID($stateParams.idShowing).then(function (results){
                vm.ticket = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });

        }
        findTicket();
    }
    angular.module('movieApp').controller('getTicketByShowingController',['ticketDal','$stateParams', GetTicketByShowingController]);
}());
