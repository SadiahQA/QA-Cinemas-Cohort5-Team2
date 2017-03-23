(function(){

    var GetTicketByShowingController = function(ticketDal, $stateParams, ticketFactory, manyTicketFactory, seatFactory, priceFactory, $state, localStorageService, backUpTicketFactory, userFactory){

        var vm = this;
        vm.seats;
        vm.selected=[];
        vm.booking=seatFactory.get();
        vm.getLength = function() {
            vm.length = vm.booking.student.quantity + vm.booking.child.quantity + vm.booking.adult.quantity + vm.booking.concession.quantity;
        }
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
            }
        };
        vm.exists=function(item, list){
            return list.indexOf(item)>-1;
        };

        vm.updateSeatNums = function(){

            vm.booking.seatNums  = vm.selected;

        };
        vm.saveBooking = function(ticket){
            ticket.booking.idUser=userFactory.get().idUser;
            ticketFactory.set(ticket);
            userFactory.loginGate=0;

            vm.ticketArray = ticketFactory.get();
            ticketDal.createTicket(vm.ticketArray).then(function(response){
                vm.bookingResponse=response;
                manyTicketFactory.set(vm.bookingResponse);
                $state.go('payment');
                if(JSON.stringify(vm.bookingResponse) === "{\"message\": \"No tickets found\"}"){
                    ticketFactory.set(null);
                }
            });
            
        }
        vm.storePrice=function(price){
            priceFactory.set(price);
        }
        vm.clearPreviousInfo = function(){
            localStorageService.cookie.remove('manyTicketStorageKey');
            localStorageService.cookie.remove('seatStorageKey');
            localStorageService.cookie.remove('ticketArrayKey');
        }

        vm.checkBookingExists = function(){

            if (seatFactory.get() === null){
                if (backUpTicketFactory.get() != null){
                    ticketDal.removeTickets(backUpTicketFactory.get());
                }
                backUpTicketFactory.set(null);

                $state.go('homepage');
            }
        }


    }
    angular.module('movieApp').controller('getTicketByShowingController',['ticketDal','$stateParams', 'ticketFactory', 'manyTicketFactory','seatFactory','priceFactory', '$state','localStorageService', 'backUpTicketFactory','userFactory', GetTicketByShowingController]);
}());
