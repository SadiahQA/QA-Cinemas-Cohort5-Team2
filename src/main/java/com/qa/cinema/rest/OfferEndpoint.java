package com.qa.cinema.rest;

import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.qa.cinema.service.OfferService;

/**
 * @author Alice Thomas
 * @version 0.0.1
 * @since 21/03/2017
 *
 */

@Path("/offer")
public class OfferEndpoint {
	
	@Inject
	private OfferService service;
	
	@Path("/json/{offerCode}")
	@GET
	@Produces({"application/json"})
	public String getDiscountAmount(@PathParam("offerCode") String offerCode) {
		return service.getDiscountAmount(offerCode);
	}
}