(function(){
	
	var CreateBookingController = function(bookingFactory, ticketFactory, ticketDal){
		
		var vm = this;
		
		vm.retriveBookingdetails = function(){
			vm.booking = bookingFactory.get();
		}
		
		vm.studentNum=0;
		vm.childNum=0;
		vm.adultNum=0;
		vm.concessionNum=0;
		
		vm.incrementNumber = function(number){
			number = number + 1;
			return number;
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
			ticketDal.createTicket(vm.ticketArray);
		}
	
	};
	
	angular.module('movieApp').controller('createBookingController', ['bookingFactory', 'ticketFactory', 'ticketDal', CreateBookingController]);
	
}());