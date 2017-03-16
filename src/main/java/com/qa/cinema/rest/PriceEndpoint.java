package com.qa.cinema.rest;

import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.qa.cinema.service.PriceService;

/**		
 * @author Sadiah Ahmed		
 * @version 0.0.1		
 * @since 16/03/2017		
 *		
 */

@Path("/price")
public class PriceEndpoint {
	
	@Inject
	private PriceService service;
	
	@Path("/json/{showingType}/{screenType}")
	@GET
	@Produces({"application/json"})
	public String getPriceForTicket(@PathParam("showingType") String showingType, @PathParam("ticketType") String ticketType) {
		return service.getPrice(showingType,ticketType);
	}
	
}