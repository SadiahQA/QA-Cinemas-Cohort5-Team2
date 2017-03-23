movieApp.factory('bookingFactory', function(localStorageService){
	var savedData = {}


	function set(data){
		localStorageService.cookie.set('bookingStorageKey', data);	
		savedData = data;
		console.log(savedData.user.idUser);
	}
	
	function get(){

		return localStorageService.cookie.get('bookingStorageKey');
	}
	
	return{
		set: set,
		get: get
	}
});

