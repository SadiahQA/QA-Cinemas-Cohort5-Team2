movieApp.factory('userFactory', function(){
	
	var userSession = {}

	
	
	function set(data){
		userSession = data;
	}
	
	function get(){
		return userSession;
	}
	
	function loggedIn(){

	
		if(JSON.stringify(userSession) !== "{}"){
			return true;
		}
		else {
			return false;}
	}
	
	
	return{
		set: set,
		get: get,
		loggedIn: loggedIn
	}
});