"use strict";

(function () {

    angular.module('movieApp').config(function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/home");

        $stateProvider.state("homepage", {
            url: "/home",
            templateUrl: "app/feature/home/home.html"
        }).state("seecurrentmovies", {
            url: "/seecurrentmovies",
            templateUrl: "app/feature/movie/get/get-current-movies/get-current-movies.html"
        }).state("seefuturemovies",{
            url:"/seefuturemovies",
            templateUrl: "app/feature/movie/get/get-future-movies/get-future-movies.html"
        }).state("seeonemovie",{
            url:"/seeonemovie/:idMovie",
            templateUrl: "app/feature/movie/get/get-one/get-one-movie.html",
            controller: function ($stateParams){
                $stateParams.idMovie
            }
            //params:['movieId']
        })
        .state("adduser",{
            url:"/adduser",
            templateUrl: "app/feature/user/add-user/add-user.html"
        })
        .state("cinemas",{
        	url:"/cinemas", 
        	templateURL: "app/feature/cinema/get-cinema/get-all-cinemas/get-all-cinemas.html"
        }).state("oneCinema",{
        	url:"/oneCinema:city",
        	templateURL:"app/feature/cinema/get-cinema/get-all-cinemas/get-cinema-by-city.html"
        })
       
        
    });
}());