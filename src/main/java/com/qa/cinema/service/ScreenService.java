package com.qa.cinema.service;

/**
 * 
 * @author Joseph Richardson
 * @version 0.0.4
 *
 */

public interface ScreenService {

	String getScreensByCinema(Long idCinema);
	
	String getScreensByType(Long idCinema, String screenType);
	
	String getScreensByDirectorsBox(Long idCinema, boolean isDirectorsBox);

	
	
}

