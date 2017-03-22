package com.qa.cinema.rest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.cinema.persistence.Movie;
import com.qa.cinema.persistence.User;
import com.qa.cinema.service.MovieService;
import com.qa.cinema.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class MovieEndpointTest {

	@Mock
	private MovieService movieService;

	@Mock
	private Movie movie1;

	@InjectMocks
	private MovieEndpoint movieEndpoint;

	private ArrayList<Movie> movies = new ArrayList<>();

	@Before
	public void testSetup() {
		movies.clear();
		movies.add(movie1);
		Mockito.when(movieService.listFutureMovies()).thenReturn("List of Future Movies");
		Mockito.when(movieService.listCurrentMovies()).thenReturn("List of Current Movies");
		Mockito.when(movieService.getMovieById(1l)).thenReturn("Movie found by Id");
	}
	
	@Test
	public void listFutureMoviesTest() {
		assertEquals("List of Future Movies", movieEndpoint.getAllMovies());
	}
	
	@Test
	public void listCurrentMoviesTest() {
		assertEquals("List of Current Movies", movieEndpoint.getCurrentMovies());
	}

	@Test
	public void getMovieByIdTest() {
		assertEquals("Movie found by Id", movieEndpoint.getMovieByID(1l));
	}
}
