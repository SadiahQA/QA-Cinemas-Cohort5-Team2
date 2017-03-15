(function() {

	
	
    var AddUserController =  function($state, userDal) {
        var vm = this;
        
        var hash = function(str){
            
            var hash = 0;
            if (str.length == 0) return hash;
            for (i = 0; i < str.length; i++) {
                char = str.charCodeAt(i);
                hash = ((hash<<5)-hash)+char;
                hash = hash & hash; // Convert to 32bit integer
            }
            return hash;
        
    }

        
     
        vm.addUser = function(userToAdd) {
            console.log("This is the value of user to add " + userToAdd);
            console.log(userToAdd);
            var userToJson = JSON.stringify(userToAdd);
            console.log(userToJson);
            userDal.createNewUser(userToAdd).then(function (results) {
                vm.userAddMessage  = results;
             
                document.cookie = hash(userToAdd.email);
                $state.go('getuser');
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
    }
    

    angular.module('movieApp').controller('addUserController', ['$state','userDal',AddUserController]);
}());