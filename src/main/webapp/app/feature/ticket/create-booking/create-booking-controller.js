(function(){



    var CreateBookingController = function(userFactory, bookingFactory, ticketFactory, ticketDal, priceDal, priceFactory, manyTicketFactory, $state, localStorageService, ticketDal, backUpTicketFactory, offerDal,seatFactory){


        var vm = this;



        vm.retriveBookingdetails = function(){

            vm.booking = bookingFactory.get();
            console.log(vm.booking);

        }


        var initVal = "Promo-code";
        $(document).ready(function(){
            $(".codeButton").attr("disabled", "true");
        });

        $('.voucher').on("keyup", action);
        function action(){
            if ($(this).val() != initVal && $(this).val() != "") {
                $(".codeButton").removeAttr("disabled");
            } else {
                $(".codeButton").attr("disabled", "true");
            }
        };

        vm.studentNum=0;

        vm.childNum=0;
        vm.adultNum=0;
        vm.concessionNum=0;
        vm.totalTicket=0;

        vm.concessionPrice;
        vm.adultPrice;
        vm.childPrice;
        vm.studentPrice
        vm.totalPrice = (0.00).toFixed(2);

        vm.incrementNumber = function(number){

            if (vm.totalTicket >= vm.showing.availableSeats) {
                 window.alert("No remaining seats available for this showing.");

                return number;
            }
            else {
              if(vm.totalTicket >= 15){		
                     window.alert("Maximum number of tickets for this booking reached.");		
                     return number;		
 				}
                number = number + 1;
                return number;
            }

        }

        vm.decreaseNumber = function(number){
            if (number > 0){
                number = number - 1;
                return number;
            }
            else{
                return number;
            }
        }


        vm.saveBooking=function(ticket){
            seatFactory.set(ticket);


        }



        vm.showing;

        vm.getPrice = function(booking){
            if (booking){
                vm.showing = booking.showing;
                if(!vm.showing.idShowing){
                    vm.showing = JSON.parse(booking.showing);
                    booking.showing = JSON.parse(booking.showing);
                }
                priceDal.getPriceForTicket(vm.showing.showingType,'Student').then(function(response){
                    vm.studentPrice = Number(response).toFixed(2);
                });
                priceDal.getPriceForTicket(vm.showing.showingType,'Child').then(function(response){
                    vm.childPrice = Number(response).toFixed(2);
                });
                priceDal.getPriceForTicket(vm.showing.showingType,'Adult').then(function(response){
                    vm.adultPrice = Number(response).toFixed(2);
                });
                priceDal.getPriceForTicket(vm.showing.showingType,'Concession').then(function(response){
                    vm.concessionPrice = Number(response).toFixed(2);
                });
            }
        }

        vm.updatePrice = function(){
            vm.totalPrice = vm.concessionPrice * vm.concessionNum +
                vm.adultPrice * vm.adultNum +
                vm.childPrice * vm.childNum +
                vm.studentPrice * vm.studentNum;
            vm.totalPrice = (vm.totalPrice).toFixed(2);
            vm.totalTicket = vm.concessionNum + vm.adultNum + vm.childNum + vm.studentNum;
        }

        vm.discountPrice = function(offerCode){
            offerDal.getDiscountAmount(offerCode).then(function (results){
                vm.offerFound = results;
                vm.totalPrice = ((vm.totalPrice)*(vm.offerFound)).toFixed(2);
                document.getElementById('codeButton').setAttribute("disabled","disabled");
            }, function(error){
                vm.error = true;
                vm.errorMessage = error;
                window.alert("Invalid Code");
            });
        }

        vm.storePrice = function(price){
            priceFactory.set(price);
        }
        vm.clearPreviousInfo = function(){
            localStorageService.cookie.remove('manyTicketStorageKey');
            localStorageService.cookie.remove('bookingStorageKey');
            localStorageService.cookie.remove('ticketArrayKey');
        }

        vm.checkBookingExists = function(){

            if (bookingFactory.get() === null){
                if (backUpTicketFactory.get() != null){
                    ticketDal.removeTickets(backUpTicketFactory.get());
                }
                backUpTicketFactory.set(null);

                $state.go('homepage');
            }
        }

    };

    angular.module('movieApp').controller('createBookingController', ['userFactory','bookingFactory', 'ticketFactory', 'ticketDal', 'priceDal', 'priceFactory', 'manyTicketFactory', '$state', 'localStorageService', 'ticketDal', 'backUpTicketFactory', 'offerDal','seatFactory', CreateBookingController]);



}());

