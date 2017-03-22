movieApp.factory('seatFactory', function(localStorageService){
    var savedData = {}

    function set(data){
        localStorageService.cookie.set('seatStorageKey', data);
        savedData = data;
    }

    function get(){

        return localStorageService.cookie.get('seatStorageKey');
    }

    return{
        set: set,
        get: get
    }
});

