movieApp.factory('bookingFactory', function(localStorageService){
	var savedData = {}
	
	function set(data){
		localStorageService.cookie.set('bookingStorageKey', data);	
		savedData = data;
	}
	
	function get(){

		return localStorageService.cookie.get('bookingStorageKey');
	}
	
	return{
		set: set,
		get: get
	}
});
