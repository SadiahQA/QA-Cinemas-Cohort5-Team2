package com.qa.cinema.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

import com.qa.cinema.persistence.Cinema;


/**
 * 
 * @author Joseph Richardson
 * @version 0.0.2
 *
 */

@ApplicationScoped
@Alternative
public class MapScreenService implements ScreenService{

	@Override
	public String listAllScreensByCinema(Long idCinema) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listScreensByType(Long idCinema, String screenType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listScreensByDirectorsBox(Long idCinema, boolean isDirectorsBox) {
		// TODO Auto-generated method stub
		return null;
	}



}
