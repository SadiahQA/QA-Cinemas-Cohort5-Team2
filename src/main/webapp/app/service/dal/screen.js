
/*
 * @author Joseph Richardson
 * @version 0.0.1 
 */
"use strict";

(function () {

    angular.module("movieApp").service("screenDal", ["dal", ScreenDal]);

    function ScreenDal (dal) {

        this.findByCinema = function (idCinema) {

        }


    }
}());