(function() {

	var GetCurrentMovieController =  function($state, userFactory, movieDal, showingDal, bookingFactory, $stateParams, cinemaFactory) {

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
            vm.idCinema = cinemaFactory.get();
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


        vm.saveBooking = function (booking){
            bookingFactory.set(booking);
            
        }
       
    	
		vm.loginCheck = function(){
			
			if(userFactory.loggedIn() === false){
				userFactory.loginGateCheck = 1;
				$state.go("adduser");
				windows.alert("Please ")
			}
			else{
				$state.go("createbooking")}
		}
        
        vm.getShowings = function (theMovieId){
        	
        	vm.showings = [];
        	
        	showingDal.getShowingsForMovie(theMovieId, cinemaFactory.get()).then(function (results){
        		vm.showings[theMovieId]  = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
        	});
        }
    };

    angular.module('movieApp').controller('getCurrentMovieController', ['$state','userFactory','movieDal', 'showingDal', 'bookingFactory', '$stateParams', 'cinemaFactory', GetCurrentMovieController]);

}());
