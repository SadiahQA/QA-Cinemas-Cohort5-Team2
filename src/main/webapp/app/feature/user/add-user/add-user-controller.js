(function() {

	var AddUserController = function($state, userDal, userFactory) {
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

			userDal.createNewUser(userToAdd).then(function(results) {
								vm.userAddMessage = results;
								if (JSON.stringify(results) === '{"message":"User Successfully Added"}') {
									document.cookie = "usercookie = "
											+ hash(userToAdd.email+ userToAdd.password);
									userFactory.set(userToAdd);
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
		
	vm.login = function(useremail, userpassword){
			userDal.getUserByEmailAndPassword(useremail, userpassword).then(function(results){
				vm.userLoginMessage = results;
				if(JSON.stringify(results)) {
					document.cookie = "usercookie = "
						+ hash(useremail+ userpassword);
					userFactory.set(results);
					$state.go('homepage');
					window.alert("Welcome back "+results.firstName)
				}
				else {window.alert("Login failed: please check details and try again.")}
			});
			};
			vm.loggedIn = userFactory.get();
			vm.compare = (JSON.stringify(vm.loggedIn));
	}


	angular.module('movieApp').controller('addUserController',
			[ '$state', 'userDal', 'userFactory', AddUserController ]);
}());