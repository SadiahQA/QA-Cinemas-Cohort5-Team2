"use strict";

(function () {

    angular.module('movieApp').config(function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/home");

        $stateProvider.state("homepage", {
            url: "/home",
            templateUrl: "app/feature/home/home.html"
        }).state("seecurrentmovies", {
            url: "/seecurrentmovies/:current",
            templateUrl: "app/feature/movie/get/get-current-movies/get-current-movies.html",
            controller: function ($stateParams){
                $stateParams.current = "default";
            }
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
        	url:"/oneCinema:cinemaCity",
        	templateURL:"app/feature/cinema/get-cinema/get-all-cinemas/get-cinema-by-city.html",
        		controller: function ($stateParams){
                    $stateParams.cinemaCity
        		}

        }).state("contactus",{
        	url:"/contactus", 
        	templateURL: "app/feature/contact/contactus.html"
       

        }).state("bookticket",{
            url: "/bookticket",
            templateUrl: "app/feature/ticket/add-ticket/add-ticket.html"

        }).state("getticket",{
            url: "/getticket/:idTicket",
            templateUrl: "app/feature/ticket/get/get-specific-ticket/get-specific-ticket.html",
            controller: function($stateParams) {
                $stateParams.idTicket
            }
        }).state("getshowingtickets",{
            url: "/getshowingtickets/:idShowing",
            templateUrl: "app/feature/ticket/get/get-ticket-by-showing/get-ticket-by-showing.html",
            controller: function($stateParams) {
                $stateParams.idShowing
            }
        }).state("getusertickets",{
            url: "/getusertickets/:idUser",
            templateUrl: "app/feature/ticket/get/get-ticket-by-user/get-ticket-by-user.html",
            controller: function($stateParams) {
                $stateParams.idUser
            }
        }).state("createbooking", {
        	url: "/createbooking",
        	templateUrl: "app/feature/ticket/create-booking/create-booking.html"
        }).state("confirmation", {
            url:"/confirmation",
            templateUrl: "app/feature/confirmation/confirmation.html"
        }).state("seat", {
            url:"/seat",
            templateUrl: "app/feature/seat/update-seat.html"
        })

        
    });
}());