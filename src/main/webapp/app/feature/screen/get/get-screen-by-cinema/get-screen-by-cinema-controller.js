(function() {

    var GetScreenByCinemaController =  function(screenDal) {
        var vm = this;

        function init() {
            screenDal.getScreensByCinema().then(function (results) {
                vm.screens  = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }
        init();
    };

    angular.module('movieApp').controller('getScreenByCinemaController', ['screenDal', GetScreenByCinemaController]);
}());