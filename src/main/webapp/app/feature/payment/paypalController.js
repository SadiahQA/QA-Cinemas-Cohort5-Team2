(function(){
	
	var PaypalController = function(bookingFactory, priceFactory, $state, localStorageService, ticketDal, manyTicketFactory){
		
		paypal.Button.render({
		    
	        env: 'sandbox', // Optional: specify 'sandbox' environment
	    
	        client: {
	            sandbox:    'AWch3-xv2pO6AGIZHlI0p8e5RE7YtKcsAwv8otikmWkVSS0Q0tlJOXDwsn84wSf3Zoavk6OwZh5tX3dx',
	        },

	        payment: function() {
	        
	            var env    = this.props.env;
	            var client = this.props.client;
	        
	            return paypal.rest.payment.create(env, client, {
	                transactions: [
	                    {
	                        amount: { total: priceFactory.get() , currency: 'GBP' }
	                    }
	                ]
	            });
	        },

	        commit: true, // Optional: show a 'Pay Now' button in the checkout flow

	        onAuthorize: function(data, actions) {
	        
	            return actions.payment.execute().then(function() {
	            	$state.go('paymentsuccess');
	            	localStorageService.remove(manyTicketStorageKey, bookingStorageKey);
	            });
	        },
	        
	        onError : function(err){
	        	$state.go('homepage');
	        	console.log(JSON.stringify(manyTicketFactory.get()));
	        	ticketDal.removeTickets(manyTicketFactory.get()).then(function(){
	        		localStorageService.cookie.remove('manyTicketStorageKey', 'bookingStorageKey', 'ticketArrayKey');
	        	});       	
	        },
	        
	        onCancel : function(data, actions){ 
	        	$state.go('homepage');
	        	console.log(JSON.stringify(manyTicketFactory.get()));
	        	ticketDal.removeTickets(manyTicketFactory.get()).then(function(){
	        		localStorageService.cookie.remove('manyTicketStorageKey', 'bookingStorageKey', 'ticketArrayKey');
	        	});
	        }
	    }, '#paypal-button');
		
		
	};
	
	angular.module('movieApp').controller('paypalController', ['bookingFactory', 'priceFactory', '$state', 'localStorageService', 'ticketDal', 'manyTicketFactory', PaypalController]);
	
}())