package com.qa.cinema.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.qa.cinema.service.ScreenService;


/**
 * @author Joseph Richardson
 * @version 0.0.5
 **/

@Path("/screen")
public class ScreenEndPoint {

	@Inject
	private ScreenService service;

	@Path("/json/{id}")
	@GET
	@Produces({ "application/json" })
	public String getScreensByCinema(@PathParam("id")Long idCinema) {
		return service.getScreensByCinema(idCinema);
	}


	@Path("/json/{id}/{screenType}")
	@GET
	@Produces({ "application/json" })
	public String getScreensByType(@PathParam("id")Long idCinema, @PathParam("screenType") String screenType) {
		return service.getScreensByType(idCinema, screenType);
	}
	
	@Path("/json/{id}/{directorsBox}")
	@GET
	@Produces({ "application/json" })
	public String getScreensByIsDirectorsBox(@PathParam("id")Long idCinema, @QueryParam("directorsBox") boolean isDirectorsBox) {
		return service.getScreensByDirectorsBox(idCinema, isDirectorsBox);
	}
	
}