(function() {

	var AddUserController = function($state, userDal) {
		var vm = this;

		var hash = function(str) {

			var hash = 0;
			if (str.length == 0)
				return hash;
			for (var i = 0; i < str.length; i++) {
				var char = str.charCodeAt(i);
				hash = (hash * 31 + char) | 0;

			}
			return hash;

		}

		vm.addUser = function(userToAdd) {

			userDal
					.createNewUser(userToAdd)
					.then(
							function(results) {
								vm.userAddMessage = results;
								if (JSON.stringify(results) === '{"message":"User Successfully Added"}') {
									document.cookie = "usercookie = "
											+ hash(userToAdd.email+ userToAdd.password);
									$state.go('homepage');
									window.alert("New User Created");
								}

								else {
									window.alert("User Creation Failed");
								}
							},

							function(error) {
								vm.error = true;
								vm.errorMessage = error;
							});
		}
	}

	angular.module('movieApp').controller('addUserController',
			[ '$state', 'userDal', AddUserController ]);
}());