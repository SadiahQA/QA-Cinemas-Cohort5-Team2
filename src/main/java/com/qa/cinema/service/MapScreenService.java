package com.qa.cinema.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;


/**
 * 
 * @author Joseph Richardson
 * @version 0.0.1
 *
 */

@ApplicationScoped
@Alternative
public class MapScreenService implements ScreenService{

	@Override
	public String listAllScreensByCinema(Cinema cinema) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listScreensByType(Cinema cinema, String screenType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listScreensByDirectorsBox(Cinema cinema, boolean isDirectorsBox) {
		// TODO Auto-generated method stub
		return null;
	}



}
