movieApp.factory('userFactory', function(){
	
<<<<<<< HEAD
	var userSession = {}

	
=======
	var userSession = {}	
>>>>>>> f9b72cddbc067d349d14fcc8fcf43c2632bb7fc6
	
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
