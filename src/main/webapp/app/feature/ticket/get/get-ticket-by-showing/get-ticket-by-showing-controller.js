(function(){

    var GetTicketByShowingController = function(ticketDal, $stateParams){

        var vm = this;
        vm.tickets;
        vm.selected=[];
        function findTicket(){

                ticketDal.findByShowingID($stateParams.idShowing).then(function (results){
                    vm.tickets = results;
                }, function (error) {
                    vm.error = true;
                    vm.errorMessage = error;
                });

        }
        findTicket();
        vm.toggle = function(item, list){
            vm.idx=list.indexOf(item);
            if(vm.idx > -1) {
                list.splice(vm.idx, 1);
            }
            else{
                list.push(item);
                console.log(item);
            }
        };
        vm.exists=function(item, list){
            return list.indexOf(item)>-1;
        };
    }
    angular.module('movieApp').controller('getTicketByShowingController',['ticketDal','$stateParams', GetTicketByShowingController]);
}());
