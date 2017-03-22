movieApp.factory('manyTicketFactory', function(localStorageService, backUpTicketFactory){
	
	function set(data){
		localStorageService.cookie.set('manyTicketStorageKey', data, 1);
		if (angular.isDefined(data) && data != null){
			backUpTicketFactory.set(data);	
		}	
	}
	
	function get(){
		return localStorageService.cookie.get('manyTicketStorageKey');
	}
	
	return{
		set: set,
		get: get
	}
});
