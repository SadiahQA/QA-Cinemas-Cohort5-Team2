package com.qa.cinema.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cinema.service.UserService;

/**
 * 
 * @author Stefan Matykiewicz
 * @version 0.1.0
 */

@Path("/user")
public class UserEndpoint {
	
	@Inject
	private UserService service;
	
	@Path("/json")
	@GET
	@Produces({"application/json"})
	public String findIndividualUser(){
		return service.findIndividualUser();
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String createNewUser(String user) {
		return service.createNewUser(user);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateUser(@PathParam("id") Long idUser, String user) {
		return service.updateUser(idUser, user);
	}
	
	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteUser(@PathParam("id") Long idUser) {
		return service.deleteMovie(idUser);

	}
}
