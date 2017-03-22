movieApp.factory('userFactory', function(localStorageService){

	var userSession = {}

	var loginGateCheck = 0;
		
	function set(data){
		localStorageService.cookie.set("User", data);
				
		
	}
	
	function get(){
		return localStorageService.cookie.get("User");
	}
	
	function logOut(){
		localStorageService.cookie.remove("User");
	}
	
	function loggedIn(){

	
	if(localStorageService.cookie.get("User")){
			return true;
		}
		else {
			return false;}
	}
	
	
	return{
		set: set,
		get: get,
		logOut: logOut,
		loggedIn: loggedIn
	}
});
