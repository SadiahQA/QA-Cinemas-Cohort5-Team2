movieApp.factory('userFactory', function(){
	
	var userSession = {}
	
	
	function set(data){
		userSession = data;
	}
	
	function get(){
		return userSession;
	}
	
	return{
		set: set,
		get: get
	}
});