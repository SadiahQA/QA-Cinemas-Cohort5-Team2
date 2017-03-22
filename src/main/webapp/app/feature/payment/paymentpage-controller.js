(function(){
	
	var PaymentPageController = function(manyTicketFactory, priceFactory, createBookingController, localStorageService, $window, ticketDal){
		
		var vm = this;
		
		vm.getBooking = function(){
			vm.booking = manyTicketFactory.get();
			vm.totalPrice = priceFactory.get();
		}
		
	};
	
	angular.module('movieApp').controller('paymentPageController', ['manyTicketFactory', 'priceFactory', 'localStorageService', 'ticketDal', PaymentPageController]);
	
}())