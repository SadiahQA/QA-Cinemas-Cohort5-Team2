(function(){

    var GetTicketByShowingController = function(ticketDal, $stateParams, ticketFactory, manyTicketFactory, seatFactory, priceFactory, $state){

        var vm = this;
        vm.seats;
        vm.selected=[];
        vm.booking=seatFactory.get();
        vm.length = vm.booking.student.quantity+vm.booking.child.quantity+vm.booking.adult.quantity+vm.booking.concession.quantity;
        function findTicket(){

                ticketDal.findByShowingID($stateParams.idShowing).then(function (results){
                    vm.seats = results;
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

        vm.updateSeatNums = function(){
            console.log(0);
            vm.booking.seatNums  = vm.selected;

        };
        vm.saveBooking = function(ticket){
            console.log(1);
            ticketFactory.set(ticket);

            vm.ticketArray = ticketFactory.get();
            ticketDal.createTicket(vm.ticketArray).then(function(response){
                vm.bookingResponse=response;
                manyTicketFactory.set(vm.bookingResponse);
                $state.go('payment');
                if(JSON.stringify(vm.bookingResponse) === "{\"message\": \"No tickets found\"}"){
                    ticketFactory.set(null);
                }
            });
            vm.storePrice(vm.totalPrice);
        }
        vm.storePrice=function(price){
            priceFactory.set(price);
        }

    }
    angular.module('movieApp').controller('getTicketByShowingController',['ticketDal','$stateParams', 'ticketFactory', 'manyTicketFactory','seatFactory','priceFactory', '$state', GetTicketByShowingController]);
}());
