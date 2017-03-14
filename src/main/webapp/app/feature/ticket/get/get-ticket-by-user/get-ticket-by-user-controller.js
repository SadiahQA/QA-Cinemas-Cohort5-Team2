(function(){

    var GetTicketByUserController = function(ticketDal, $stateParams){

        var vm = this;
        function findTicket(){

            ticketDal.findByUserID($stateParams.idUser).then(function (results){
                vm.ticket = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });

        }
        findTicket();
    }
    angular.module('movieApp').controller('getTicketByUserController',['ticketDal','$stateParams', GetTicketByUserController]);
}());
