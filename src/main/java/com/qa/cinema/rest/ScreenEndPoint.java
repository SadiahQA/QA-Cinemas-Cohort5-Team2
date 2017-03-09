package com.qa.cinema.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.qa.cinema.service.ScreenService;


/*
 * Author: Joseph Richardson
 * Version: 0.0.3
 */

@Path("/screen")
public class ScreenEndPoint {

	@Inject
	private ScreenService service;

	@Path("/json/{id}")
	@GET
	@Produces({ "application/json" })
	public String listAllScreensByCinema(@PathParam("id")Long idCinema) {
		return service.listAllScreensByCinema(idCinema);
	}


	@Path("/json/{id}/{screenType}")
	@GET
	@Produces({ "application/json" })
	public String listScreensByType(@PathParam("id")Long idCinema, @PathParam("screenType") String screenType) {
		return service.listScreensByType(idCinema, screenType);
	}
	
	@Path("/json/{id}/{DirectorsBox}")
	@GET
	@Produces({ "application/json" })
	public String listScreensByIsDirectorsBox(@PathParam("id")Long idCinema, @PathParam("directorsBox") boolean isDirectorsBox) {
		return service.listScreensByDirectorsBox(idCinema, isDirectorsBox);
	}
	
}