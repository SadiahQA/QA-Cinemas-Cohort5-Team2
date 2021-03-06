
/*
 * @author Joseph Richardson
 * @version 0.0.3
 */
"use strict";

(function () {

    angular.module("movieApp").service("screenDal", ["dal", ScreenDal]);

    function ScreenDal (dal) {

        this.findByCinema = function (idCinema) {
            return dal.http.GET("rest/screen/json/" + idCinema);
        };
        
        this.findByScreenType = function (idCinema, screenType){
        	return dal.http.GET("rest/screen/json/" + idCinema + "/" +screenType);
        }
        
        this.findByDirectorsBox = function (idCinema, isDirectorsBox){
        	return dal.http.GET("rest/screen/json/" + idCinema + "/" + isDirectorsBox);
        }


    }
}());