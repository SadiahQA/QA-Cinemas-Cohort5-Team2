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
 * @version 0.2.0
 */

@Path("/user")
public class UserEndpoint {
	
	@Inject
	private UserService service;
	
	@Path("/json/{id}")
	@GET
	@Produces({"application/json"})
	public String findIndividualUser(@PathParam("id") Long id){
		return service.findIndividualUser(id);
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
	public String updateUser(@PathParam("id") Long id, String user) {
		return service.updateUser(id, user);
	}
	
	@Path("/json/email/{email}/{password}")
	@GET
	@Produces({"application/json"})
	public String getUserByEmailAndPassword(@PathParam("email") String email, @PathParam("password")String password){
		return service.getUserByEmailAndPassword(email, password);
		
	}
	@Path("/json/email/{email}")
	@GET
	@Produces({"application/json"})
	public String findUserIdByEmail(@PathParam("email") String email){
		return service.findUserIdByEmail(email);
	}

}
