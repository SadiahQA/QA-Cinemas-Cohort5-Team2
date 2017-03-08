package com.qa.cinema.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.qa.cinema.persistence.Cinema;
import com.qa.cinema.service.ScreenService;


/*
 * Author: Joseph Richardson
 * Version: 0.0.1
 */

@Path("/screen")
public class ScreenEndPoint {

	@Inject
	private ScreenService service;

	@Path("/json/{cinema}")
	@GET
	@Produces({ "application/json" })
	public String listAllScreensByCinema(@PathParam("cinema")Cinema cinema) {
		return service.listAllScreensByCinema(cinema);
	}


	@Path("/json/{cinema}/{screenType}")
	@GET
	@Produces({ "application/json" })
	public String listScreensByType(@PathParam("cinema")Cinema cinema, @PathParam("screenType") String screenType) {
		return service.listScreensByType(cinema, screenType);
	}
	
	@Path("/json/{cinema}/{DirectorsBox}")
	@GET
	@Produces({ "application/json" })
	public String listScreensByIsDirectorsBox(@PathParam("cinema")Cinema cinema, @PathParam("directorsBox") boolean isDirectorsBox) {
		return service.listScreensByDirectorsBox(cinema, isDirectorsBox);
	}
	
}