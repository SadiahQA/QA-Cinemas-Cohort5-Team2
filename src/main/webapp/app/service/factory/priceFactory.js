movieApp.factory('priceFactory', function(localStorageService){
	var savedData = {}
	
	function set(data){
		localStorageService.cookie.set('priceStorageKey', data);
		savedData = data;
	}
	
	function get(){
		return localStorageService.cookie.get('priceStorageKey');
	}
	
	return{
		set: set,
		get: get
	}
});
