(function(){
	
	var CreateBookingController = function(bookingFactory, ticketFactory, ticketDal, priceDal){
		


		var vm = this;
		vm.retriveBookingdetails = function(){
			vm.booking = bookingFactory.get();
		}




        vm.studentNum=0;
		vm.childNum=0;
		vm.adultNum=0;
		vm.concessionNum=0;

		vm.incrementNumber = function(number){
            if (vm.totalTicket >= vm.showing.availableSeats) {
                return number;
            }
            else {
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

		vm.saveBooking = function(ticket){
			ticketFactory.set(ticket);
			vm.ticketArray = ticketFactory.get();


			ticketDal.createTicket(vm.ticketArray).then(function(response){
				vm.bookingResponse=response;
				if(JSON.stringify(vm.bookingResponse) === "{\"message\": \"No tickets found\"}"){
					ticketFactory.set(null);
				}
			});
		}
		vm.totalTicket;
		vm.concessionPrice;
		vm.adultPrice;
		vm.childPrice;
		vm.studentPrice
		vm.totalPrice = (0.00).toFixed(2);
		vm.showing;
		vm.getPrice = function(booking){
            vm.showing = JSON.parse(booking.showing);
			console.log(vm.showing);
			console.log(vm.showing.showingType);
			priceDal.getPriceForTicket(vm.showing.showingType,'Student').then(function(response){
				vm.studentPrice = Number(response).toFixed(2);
			});
			console.log(vm.studentPrice);
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
		
		vm.updatePrice = function(){
			vm.totalPrice = vm.concessionPrice * vm.concessionNum +
			vm.adultPrice * vm.adultNum +
			vm.childPrice * vm.childNum +
			vm.studentPrice * vm.studentNum;
			vm.totalPrice = (vm.totalPrice).toFixed(2);
			vm.totalTicket = vm.concessionNum + vm.adultNum + vm.childNum + vm.studentNum;
		}
		
	
	};
	
	angular.module('movieApp').controller('createBookingController', ['bookingFactory', 'ticketFactory', 'ticketDal', 'priceDal', CreateBookingController]);
	
}());