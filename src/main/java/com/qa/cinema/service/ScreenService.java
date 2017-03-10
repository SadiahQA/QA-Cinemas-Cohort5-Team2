package com.qa.cinema.service;

/**
 * 
 * @author Joseph Richardson
 * @version 0.0.3
 *
 */

public interface ScreenService {

	String getAllScreensByCinema(Long idCinema);
	
	String getScreensByType(Long idCinema, String screenType);
	
	String getScreensByDirectorsBox(Long idCinema, boolean isDirectorsBox);
	
	
}

