package com.qa.cinema.service;

/**
 * @author Stefan Matykiewicz
 * @version 0.1.1
 */

public interface UserService {

	String findIndividualUser (Long id);
	
	String createNewUser (String user);
	
	String updateUser (Long id, String user);
	
	String deleteUser (Long id);
	
	
}
