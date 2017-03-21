movieApp.factory('manyTicketFactory', function(localStorageService){
	
	function set(data){
		localStorageService.cookie.set('manyTicketStorageKey', data);	
	}
	
	function get(){
		return localStorageService.cookie.get('manyTicketStorageKey');
	}
	
	return{
		set: set,
		get: get
	}
});
