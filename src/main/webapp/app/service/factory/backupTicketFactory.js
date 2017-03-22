movieApp.factory('backUpTicketFactory', function(localStorageService){
	
	function set(data){
		
		localStorageService.cookie.set('backUpTicketStorageKey', data, 1);	
	}
	
	function get(){
		return localStorageService.cookie.get('backUpTicketStorageKey');
	}
	
	return{
		set: set,
		get: get
	}
});
