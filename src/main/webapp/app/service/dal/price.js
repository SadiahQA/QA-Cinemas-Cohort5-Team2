/**		
 * @author Sadiah Ahmed		
 * @version 0.0.1		
 * @since 16/03/2017		
 *		
 */

"use strict";

(function(){
	angular.module("movieApp").service("priceDal",["dal",PriceDal]);
	
	function PriceDal(dal) {
		this.getPriceForTicket = function(showingType,ticketType) {
			return dal.http.GET("rest/price/json/" + showingType + "/" + ticketType);
		};
	}
}());