package com.qa.cinema.service;

import javax.ejb.Stateless;

/*
 * @author Alistair Fenn
 * @version 0.0.1
 */
public interface CinemaService {

	String getAllCinemas();
	
	String findCinemaByCity(String city);
	
	
}
