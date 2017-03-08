package com.qa.cinema.service;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import com.qa.cinema.persistence.Cinema;

/**
 * 
 * @author Joseph Richardson
 * @version 0.0.1
 *
 */

@Stateless
@Default
public class DBScreenService implements ScreenService{

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
