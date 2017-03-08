package com.qa.cinema.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cinema.service.MovieService;

/**
 * 
 * @author Alex Mercer
 * @version 0.1.0
 */
@Path("/movie")
public class MovieEndpoint {

	@Inject
	private MovieService service;

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllMovies() {
		return service.listAllMovies();
	}


	@Path("/json/{id}")
	@GET
	@Produces({ "application/json" })
	public String getMovieByID(@PathParam("id") Long moviedId) {
		return service.getMovieById(moviedId);
	}
}
