/**		
 * @author Sadiah Ahmed		
 * @version 0.0.1		
 * @since 13/03/2017		
 *		
 */

"use strict";

(function(){
	angular.module("movieApp").service("showingDal",["dal",ShowingDal]);
	
	function ShowingDal(dal) {
		this.getShowingsForMovie = function(idMovie,idCinema) {
			return dal.http.GET("rest/showing/json/" + idMovie + "/" +idCinema);
		};
	}
}());
