(function(){
	
	var PaymentPageController = function(bookingFactory, priceFactory, $window){
		
		
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
	                        amount: { total: priceFactory.get(), currency: 'GBP' }
	                    }
	                ]
	            });
	        },

	        commit: true, // Optional: show a 'Pay Now' button in the checkout flow

	        onAuthorize: function(data, actions) {
	        
	            // Optional: display a confirmation page here
	        
	            return actions.payment.execute().then(function() {
	            	$window.location = "#/paymentsuccess"
	            });
	        }

	    }, '#paypal-button');
		
		
		
	};
	
	angular.module('movieApp').controller('paymentPageController', ['bookingFactory', 'priceFactory', '$window', PaymentPageController]);
	
}())