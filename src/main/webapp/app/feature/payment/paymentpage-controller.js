(function(){
	
	var PaymentPageController = function(manyTicketFactory, priceFactory, createBookingController, localStorageService, $window, ticketDal){
		
		var vm = this;
		
		vm.getBooking = function(){
			vm.booking = manyTicketFactory.get();
			vm.totalPrice = priceFactory.get();
		}
		
		vm.studentNum=0;
		vm.adultNum=0;
		vm.childNum=0;
		vm.concessionNum=0;
		
		vm.getQuantities = function(){
			for (var i in vm.booking){
				if (vm.booking[i].ticketType === "Student"){
					vm.studentNum = vm.studentNum + 1;
				}
				if (vm.booking[i].ticketType === "Concession"){
					vm.concessionNum = vm.concessionNum + 1;
				}
				if (vm.booking[i].ticketType === "Adult"){
					vm.adultNum = vm.adultNum + 1;
				}
				if (vm.booking[i].ticketType === "Child"){
					vm.childNum = vm.childNum + 1;
				}
			}
		}
		
	};
	
	angular.module('movieApp').controller('paymentPageController', ['manyTicketFactory', 'priceFactory', 'localStorageService', 'ticketDal', PaymentPageController]);
	
}())