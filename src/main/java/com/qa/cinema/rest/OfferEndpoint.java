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
	
	@Path("/json/{offerID}")
	@GET
	@Produces({"application/json"})
	public double getDiscountAmount(@PathParam("offerID") int offerID) {
		return service.getDiscountAmount(offerID);
	}
}