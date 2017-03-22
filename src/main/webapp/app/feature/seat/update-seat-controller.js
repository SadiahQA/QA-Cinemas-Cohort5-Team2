
(function() {

    var items = [1,2,3,4,5,6,7,8,9,10];
    var selected = [];

    var updateSeatController =  function(items,selected) {
        var vm = this;

        var toggle = function (item, list) {
            var idx = list.indexOf(item);
            if (idx > -1) {
                list.splice(idx, 1);
            }
            else {
                list.push(item);
            }
        };

        var exists = function (item, list) {
            return list.indexOf(item) > -1;
        };

    };

    angular.module('movieApp').controller('updateSeatController', ['screenDal', GetScreenByCinemaController]);
}());


