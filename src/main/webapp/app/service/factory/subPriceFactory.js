movieApp.factory('subPriceFactory', function(localStorageService){
	var savedData = {}
	
	function set(data){
		localStorageService.cookie.set('subpriceStorageKey', data, 1);
		savedData = data;
	}
	
	function get(){
		return localStorageService.cookie.get('subpriceStorageKey');
	}
	
	return{
		set: set,
		get: get
	}
});
