(function(){
	
	var PaymentPageController = function(manyTicketFactory, priceFactory, createBookingController, localStorageService, $window){
		
		window.addEventListener('beforeunload', function(){
			localStorageService.cookie.remove('manyTicketStorageKey');
			localStorageService.cookie.remove('bookingStorageKey');
			localStorageService.cookie.remove('ticketArrayKey');
		});
		
		var vm = this;
		
		vm.getBooking = function(){
			vm.booking = manyTicketFactory.get();
		}
		
	};
	
	angular.module('movieApp').controller('paymentPageController', ['manyTicketFactory', 'priceFactory', 'localStorageService', PaymentPageController]);
	
}())