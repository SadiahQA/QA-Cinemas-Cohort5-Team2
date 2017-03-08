package com.qa.cinema.service;

import com.qa.cinema.persistence.Cinema;

public interface ScreenService {

	String listAllScreensByCinema(Cinema cinema);
	
	String listScreensByType(Cinema cinema, String screenType);
	
	String listScreensByDirectorsBox(Cinema cinema, boolean isDirectorsBox);
	
	
}

