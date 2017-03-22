/**
 * @author Alice Thomas
 * @version 0.0.1
 * @since 21/03/2017
 *
 */

"use strict";

(function(){
	angular.module("movieApp").service("offerDal", ["dal", OfferDal]);
	
	function OfferDal(dal) {
		
		this.getDiscountAmount = function(offerCode) {
			return dal.http.GET("rest/offer/json/" + offerCode);
		};
	}
}());
