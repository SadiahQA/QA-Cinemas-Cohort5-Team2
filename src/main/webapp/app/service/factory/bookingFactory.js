movieApp.factory('bookingFactory', function(localStorageService){
	var savedData = {}
	
	function set(data){
		localStorageService.cookie.set('bookingStorageKey', data);
		console.log(localStorageService.cookie.get('bookingStorageKey'));
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
