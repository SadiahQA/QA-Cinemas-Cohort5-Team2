(function(){

    var GetSpecificTicketController = function(ticketDal, $stateParams){

        var vm = this;
        function findOneTicket(){

                ticketDal.findByTicketID($stateParams.idTicket).then(function (results){
                    vm.ticket = results;
                }, function (error) {
                    vm.error = true;
                    vm.errorMessage = error;
                });

        }
        findOneTicket();
    }
    angular.module('movieApp').controller('getSpecificTicketController',['ticketDal','$stateParams', GetSpecificTicketController]);
}());