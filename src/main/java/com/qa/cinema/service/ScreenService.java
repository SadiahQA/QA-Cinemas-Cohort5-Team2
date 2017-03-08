package com.qa.cinema.service;

public interface ScreenService {

	String listAllScreensByCinema(Cinema cinema);
	
	String listScreensByType(Cinema cinema, String screenType);
	
	String listScreensByDirectorsBox(Cinema cinema, boolean isDirectorsBox);
	
	
}

