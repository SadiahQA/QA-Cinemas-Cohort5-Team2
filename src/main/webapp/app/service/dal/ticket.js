"use strict";

(function () {

    angular.module("movieApp").service("ticketDal", ["dal", TicketDal]);

    function TicketDal (dal) {

        this.createTicket = function(ticket) {
            return dal.http.POST("rest/ticket/json", ticket);
        };

        this.findByTicketID = function (idTicket) {
            return dal.http.GET("rest/ticket/json/" + idTicket);
        };

        this.findByShowingID = function (idShowing){
            return dal.http.GET("rest/ticket/json/showing/" + idShowing);
        };

        this.findByUserID = function (idUser){
            return dal.http.GET("rest/ticket/json/user/" + idUser);
        };


    }
}());
