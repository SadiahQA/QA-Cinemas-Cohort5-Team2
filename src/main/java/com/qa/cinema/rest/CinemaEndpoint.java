package com.qa.cinema.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cinema.service.CinemaService;

/*
 * Author: Alistair Fenn
 * Version: 0.0.1
 */
@Path("/cinema")
public class CinemaEndpoint {

	@Inject
	private CinemaService service;
	
	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllCinemas() {
		return service.getAllCinemas();
	}
	
	@Path("/json/{city}")
	@GET
	@Produces({ "application/json" })
	public String findCinemasByCity(@PathParam("city") String city) {
		return service.findCinemaByCity(city);
	}
	
	
}
