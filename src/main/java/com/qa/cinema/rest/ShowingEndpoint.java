package com.qa.cinema.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cinema.persistence.Movie;
import com.qa.cinema.persistence.Showing;
import com.qa.cinema.service.ShowingService;

/**		
 * @author Sadiah Ahmed		
 * @version 0.0.3		
 * @since 10/03/2017		
 *		
 */

@Path("/showing")    
public class ShowingEndpoint {
	
	@Inject
	//this i s a comment
	private ShowingService service;
	
	@Path("/json/{idMovie}/{idCinema}")
	@GET
	@Produces({ "application/json" })
	public String getAllShowingsForMovie(@PathParam("idMovie") String showingMovieId, @PathParam("idCinema") String cinemaId) {
		return service.getAllShowingsForMovie(showingMovieId, cinemaId);
	}
	
}
