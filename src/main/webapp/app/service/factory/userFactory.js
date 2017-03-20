movieApp.factory('userFactory', function(){
	
	var userSession = {}
	console.log(userSession);
	console.log(JSON.stringify(userSession));
	
	
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