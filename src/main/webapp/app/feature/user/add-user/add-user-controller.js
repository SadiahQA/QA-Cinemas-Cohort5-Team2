(function() {

	var AddUserController = function($state, userDal, userFactory,
			bookingFactory) {
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
		vm.isLoggedIn = function() {
			return userFactory.loggedIn();
		}

		vm.addUser = function(userToAdd) {
			userToAdd.password = hash(userToAdd.password);

			userDal
					.createNewUser(userToAdd)
					.then(
							function(results) {
								vm.userAddMessage = results;
								if (JSON.stringify(results) === '{"message":"User Successfully Added"}') {
									document.cookie = "usercookie = "
											+ hash(userToAdd.email
													+ userToAdd.password);

									window.alert("New User Created");
								}

								else {
									window.alert("User Creation Failed");
								}
								userDal
										.getUserByEmailAndPassword(
												userToAdd.email,
												userToAdd.password)
										.then(
												function(returns) {
													userFactory.set(returns);

													if (userFactory.loginGateCheck === 0) {
														$state.go('homepage');
													} else {
														$state.go('createbooking')
													}

												})
							},

							function(error) {
								vm.error = true;
								vm.errorMessage = error;
							});

		}

		vm.login = function(useremail, userpassword) {
			if (JSON.stringify(userDal.getUserByEmailAndPassword(useremail,
					hash(userpassword))) === '{"message": "login failed"}') {
				{
					window
							.alert("Login failed: please check details and try again.");
				}
			} else {
				userDal
						.getUserByEmailAndPassword(useremail,
								hash(userpassword)).then(
								function(results) {
									vm.userLoginMessage = results;
									document.cookie = "usercookie = "
											+ hash(useremail + userpassword);
									userFactory.set(results);
									$state.go('homepage');
									window.alert("Welcome back "
											+ results.firstName)
								})
			}
			vm.loggedIn = userFactory.get();
			vm.compare = (JSON.stringify(vm.loggedIn));
		};
	}
	angular.module('movieApp').controller(
			'addUserController',
			[ '$state', 'userDal', 'userFactory', 'bookingFactory',
					AddUserController ]);
}());