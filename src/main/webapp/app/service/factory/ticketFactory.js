movieApp.factory('ticketFactory', function(){
	var savedData = {}
	var ticketArray = [];
	
	function set(data){
		savedData = data;
		createTicketObjects();
	}
	
	function get(){
		return ticketArray;
	}
	
	function  createTicketObjects(){
		
		arrayPosition = 0;
		
		while (savedData.student.quantity > 0){
			ticket = '{ "ticketType":"Student", "showing":{"idShowing":"' +
			savedData.booking.showing.idShowing + '"}, "user":{"idUser":"' + 
			savedData.booking.user.idUser + '"}}';
			var fix = JSON.parse(ticket);
			ticketArray[arrayPosition] = fix;
			arrayPosition = arrayPosition + 1;
			savedData.student.quantity = savedData.student.quantity - 1;
		}
		
		while (savedData.adult.quantity > 0){
			ticket = '{ "ticketType":"Adult", "showing":{"idShowing":"' +
			savedData.booking.showing.idShowing + '"}, "user":{"idUser":"' + 
			savedData.booking.user.idUser + '"}}';
			var fix = JSON.parse(ticket);
			ticketArray[arrayPosition] = fix;
			arrayPosition = arrayPosition + 1;
			savedData.adult.quantity = savedData.adult.quantity - 1;
		}
		
		while (savedData.child.quantity > 0){
			ticket = '{ "ticketType":"Child", "showing":{"idShowing":"' +
			savedData.booking.showing.idShowing + '"}, "user":{"idUser":"' + 
			savedData.booking.user.idUser + '"}}';
			var fix = JSON.parse(ticket);
			ticketArray[arrayPosition] = fix;
			arrayPosition = arrayPosition + 1;
			savedData.child.quantity = savedData.child.quantity - 1;
		}
		
		while (savedData.concession.quantity > 0){
			ticket = '{ "ticketType":"Concession", "showing":{"idShowing":"' +
			savedData.booking.showing.idShowing + '"}, "user":{"idUser":"' + 
			savedData.booking.user.idUser + '"}}';
			var fix = JSON.parse(ticket);
			ticketArray[arrayPosition] = fix;
			arrayPosition = arrayPosition + 1;
			savedData.concession.quantity = savedData.concession.quantity - 1;
		}
		
	}
	
	return{
		set: set,
		get: get
	}
});