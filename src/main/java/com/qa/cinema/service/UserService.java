package com.qa.cinema.service;

/**
 * @author Stefan Matykiewicz
 * @version 0.2.0
 */

public interface UserService {

	String findIndividualUser (Long id);
	
	String createNewUser (String user);
	
	String updateUser (Long id, String user);
	
	String findUserIdByEmail(String email);
	
}
