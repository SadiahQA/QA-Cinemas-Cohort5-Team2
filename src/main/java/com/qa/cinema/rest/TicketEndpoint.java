package com.qa.cinema.rest;

/** 
 * @author Tary Andrews
 * @author Denis Kastrati
 * @Version 0.1.1
 * 
 */

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cinema.service.TicketService;

@Path("/ticket")
public class TicketEndpoint {
	
	@Inject
	private TicketService service;
	
	@Path("/json")
	@POST
	
	public String createTicket(String ticket) {
		return service.createTicket(ticket);
	}
	
	@Path("/json/{idTicket}")
	@GET
	@Produces({ "application/json" })
	public String getTicket(@PathParam("idTicket") String idTicket) {
		return service.getTicket(idTicket);
	}
	
		
	@Path("/json/showing/{idShowing}")
	@GET
	@Produces({ "application/json" })
	public String getListTicket(@PathParam("idShowing") String idShowing) {
		return service.getListTicket(idShowing);
	}
	
	
	
	@Path("/json/user/{idUser}")
	@GET
	@Produces({ "application/json" })
	public String getUserTicket(@PathParam("idUser") String idUser) {
		return service.getUserTicket(idUser);
	}
	
	
}
