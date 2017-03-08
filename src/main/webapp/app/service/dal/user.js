/*
 * Author: Stefan Matykiewicz
 * Version: 0.1.0
 */
"use strict";

(function() {

	angular.module("movieApp").service("userDal", [ "dal", UserDal ]);

	function UserDal(dal) {

		this.findIndividualUser = function(id) {
			return dal.http.GET("rest/user/json/"+ id);
		};

		this.createNewUser = function(user) {
			return dal.http.POST("rest/user/json", user);
		};

		this.updateUser = function(id, user) {
			return dal.http.PUT("rest/user/json/" + id, user);
		};

		this.deleteUser = function(id) {
			return dal.http.DELETE("/rest/user/json/" + id);
		};

	}
}());
