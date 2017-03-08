package com.qa.cinema.service;

/**
 * @author Stefan Matykiewicz
 * @version 0.1.0
 */

public interface UserService {

	String getUser (Long idUser);
	
	String createNewUser (String user);
	
	String updateUser (Long idUser, String user);
	
	String deleteUser (Long idUser);
	
	
}
