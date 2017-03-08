package com.qa.cinema.service;

/**
 * 
 * @author Alex Mercer
 * @version 0.1.0
 */
public interface MovieService {

	String listCurrentMovies();

	String listFutureMovies();
	
	String getMovieById(Long id);
}
