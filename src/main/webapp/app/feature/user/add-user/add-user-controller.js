(function() {

    var AddUserController =  function($state, userDal) {
        var vm = this;

        vm.addMovie = function(userToAdd) {
            console.log("This is the value of user to add " + userToAdd);
            console.log(userToAdd);
            var movieToJson = JSON.stringify(userToAdd);
            console.log(userToJson);
            userDal.createNewUser(userToAdd).then(function (results) {
                vm.userAddMessage  = results;
                $state.go('getuser');
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        };
    };

    angular.module('movieApp').controller('addUserController', ['$state','userDal',AddUserController]);
}());