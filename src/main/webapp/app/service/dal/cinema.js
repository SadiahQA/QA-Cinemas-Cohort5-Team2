/*
 * Author: Alistair Fenn
 * version: 0.0.1
 */

"use strict";

(function (){

	angular.module("movieApp").service("cinemaDal", ["dal", CinemaDal]);
	
	function CinemaDal (dal){
		
		this.getAllCinemas = function(){
			return dal.http.GET("rest/cinema/json");
		};
		
		this.findByCity = function (city){
			return dal.http.GET("rest/cinema/json/"+ city);
		};
	};
}());