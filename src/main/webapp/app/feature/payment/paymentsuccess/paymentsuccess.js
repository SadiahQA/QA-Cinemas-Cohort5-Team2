(function(){
	
	var PaymentSuccessController = function(){
		
		var vm = this;
		
		
		vm.reference = function()
		{
			console.log("function run");
		    var text = "";
		    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

		    for( var i=0; i < 5; i++ )
		        text += possible.charAt(Math.floor(Math.random() * possible.length));

		    return text;
		}
		
		
	}
	angular.module('movieApp').controller('paymentSuccessController',[PaymentSuccessController]);
}());