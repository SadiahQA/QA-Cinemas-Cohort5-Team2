-/*
 - * Author: Stefan Matykiewicz
 - * Version: 0.2.0
 - */
	
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
		this.getUserIdByEmail = function(email){
			return dal.http.GET("rest/user/json/email/"+ email);
		};
	}
}());
