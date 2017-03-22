movieApp.factory('userFactory', function(localStorageService){

	var userSession = {}

	var loginStatus = false;
		
	function set(data){
		localStorageService.cookie.set("User", data);
				
		loginStatus = true;
	}
	
	function get(){
		return localStorageService.cookie.get("User");
	}
	
	function logOut(){
		loginStatus = false;
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
