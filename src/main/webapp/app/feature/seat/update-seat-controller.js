
angular.module('movieApp',['ngMaterial', 'ngMessages', 'material.svgAssetsCache'])

    .controller('updateSeatController', function($scope) {

        $scope.items = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17];
        $scope.selected = [];

        $scope.toggle = function (item, list) {
            var idx = list.indexOf(item);
            if (idx > -1) {
                list.splice(idx, 1);
            }
            else {
                list.push(item);
            }
        };

        $scope.exists = function (item, list) {
            return list.indexOf(item) > -1;
        };
    });

