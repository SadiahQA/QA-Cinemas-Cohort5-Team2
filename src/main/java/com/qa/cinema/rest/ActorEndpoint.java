package com.qa.cinema.rest;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cinema.service.ActorService;

@Path("/actor")
public class ActorEndpoint {


	@Inject
	private ActorService service;
	
	
	@Path("/json/{idActor}")
	@GET
	@Produces({ "application/json" })
	public String getActor(@PathParam("idActor") String actor) {
		return service.getActor(actor);
	}
	
	
}
