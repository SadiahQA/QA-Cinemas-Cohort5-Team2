"use strict";

(function () {

    angular.module('movieApp').config(function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/home");

        $stateProvider.state("seecurrentmovies", {
            url: "/seecurrentmovies",
            templateUrl: "app/feature/movie/get/get-current/get-current-movies.html"
        }).state("seefuturemovies",{
            url:"/seefuturemovies",
            templateUrl: "app/feature/movie/get/get-future/get-future-movies.html"
        }).state("seeonemovie",{
            url:"/seeonemovie",
            params:['movieId'],
            templateUrl: "app/feature/move/get/get-one/get-one-movie.html"
        }).state("homepage", {
            url: "/home",
            templateUrl: "app/feature/home/home.html"
        })
    });
}());