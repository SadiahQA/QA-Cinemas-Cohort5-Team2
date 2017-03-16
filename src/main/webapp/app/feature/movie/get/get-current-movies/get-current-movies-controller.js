(function() {

    var GetCurrentMovieController =  function(movieDal, showingDal, $stateParams) {
        var vm = this;

        function init() {
        	if($stateParams.current === "current"){
                vm.filmTypeTitle = "Currently Showing!"
                movieDal.getCurrentMovies().then(function (results) {
                vm.movies = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            	});
        	}
        	else{
                vm.filmTypeTitle = "Coming Soon!"
                movieDal.getFutureMovies().then(function (results) {
                    vm.movies = results;
                }, function (error) {
                    vm.error = true;
                    vm.errorMessage = error;
                });
            }
        }
        init();
        
        vm.convertDate = function(givenDate){
        	
        	newDate = new Date(givenDate);
        	
        	dayofWeek = newDate.getDay();
        	
        	switch (dayofWeek){
        		case 0: 
        			dayofWeek="Monday";
        			break;
        		case 1:
        			dayofWeek="Tuesday";
        			break;
        		case 2:
        			dayofWeek="Wednesday";
        			break;
        		case 3:
        			dayofWeek="Thursday";
        			break;
        		case 4:
        			dayofWeek="Friday";
        			break;
        		case 5:
        			dayofWeek="Saturday";
        			break;
        		case 6:
        			dayofWeek="Sunday";
        			break;
        	}
        	
        	dayofMonth = newDate.getDate().toString();
        	month = newDate.getMonth();
        	
        	switch (month){
    		case 0: 
    			month="Jan";
    			break;
    		case 1:
    			month="Feb";
    			break;
    		case 2:
    			month="Mar";
    			break;
    		case 3:
    			month="Apr";
    			break;
    		case 4:
    			month="May";
    			break;
    		case 5:
    			month="Jun";
    			break;
    		case 6:
    			month="Jul";
    			break;
    		case 7:
    			month="Aug";
    			break;
    		case 8:
    			month="Sep";
    			break;
    		case 9:
    			month="Oct";
    			break;
    		case 10:
    			month="Nov";
    			break;
    		case 11:
    			month="Dec";
    			break;  			
    	}      	
        	
        	returnDate = dayofWeek + " " + dayofMonth + " " + month; 
        	return returnDate;        	
        	
        }
       
        
        vm.getShowings = function (theMovieId){
        	
        	vm.showings = [];
        	
        	showingDal.getShowingsForMovie(theMovieId, 1).then(function (results){
        		vm.showings[theMovieId]  = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
        	});
        }
    };

    angular.module('movieApp').controller('getCurrentMovieController', ['movieDal', 'showingDal', '$stateParams', GetCurrentMovieController]);
}());