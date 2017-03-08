package com.qa.cinema.service;

/**
 * 
 * @author Joseph Richardson
 * @version 0.0.2
 *
 */

public interface ScreenService {

	String listAllScreensByCinema(Long idCinema);
	
	String listScreensByType(Long idCinema, String screenType);
	
	String listScreensByDirectorsBox(Long idCinema, boolean isDirectorsBox);
	
	
}

