"use strict";

(function () {

    angular.module("movieApp").service("movieDal", ["dal", MovieDal]);

    function MovieDal (dal) {

        this.getCurrentMovies = function () {
            return dal.http.GET("rest/movie/json/current");
        };

        this.getFutureMovies = function () {
            return dal.http.GET("rest/movie/json/future");
        };

        this.getMovieById = function (idOfMovieToGet) {
            return dal.http.GET("rest/movie/json/" + idOfMovieToGet);
        };
        
        
    }
}());
