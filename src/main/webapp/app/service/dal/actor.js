"use strict";

(function () {

    angular.module("movieApp").service("actorDal", ["dal", ActorDal]);

    function ActorDal (dal) {

        this.getActor = function () {
            return dal.http.GET("rest/actor/json");
        };



    }
}());
