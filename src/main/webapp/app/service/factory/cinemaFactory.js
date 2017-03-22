movieApp.factory('cinemaFactory', function(localStorageService){
	var savedData = {}
	
	function set(data){
		localStorageService.cookie.set('cinemaStorageKey', data);	
		savedData = data;
	}
	
	function get(){

		return localStorageService.cookie.get('cinemaStorageKey');
	}
	
	return{
		set: set,
		get: get
	}
});

