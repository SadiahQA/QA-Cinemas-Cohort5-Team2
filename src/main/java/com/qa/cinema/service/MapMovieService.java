package com.qa.cinema.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

/**
 * 
 * @author Alex Mercer
 * @version 0.1.0
 */
@ApplicationScoped
@Alternative
public class MapMovieService implements MovieService {

	@Override
	public String getMovieById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listCurrentMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String listFutureMovies() {
		// TODO Auto-generated method stub
		return null;
	}


}
