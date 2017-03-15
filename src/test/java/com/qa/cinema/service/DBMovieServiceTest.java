package com.qa.cinema.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.cinema.persistence.Movie;
import com.qa.cinema.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class DBMovieServiceTest {
	
	
	@Mock
	private JSONUtil util;
	
	@Mock
	private EntityManager em;
	
	@Mock
	private Query query = Mockito.mock(Query.class);
	
	@Mock
	private Movie movie1;
	
	@InjectMocks 
	private DBMovieService movieService;
	
	private  ArrayList<Movie> movies = new ArrayList<>();

	@Test
	public void listCurrentMoviesTest() {
		
		movies.add(movie1);
		
		Mockito.when(query.getResultList()).thenReturn(movies);
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);	
		//this assumes that the query has been written correctly. There is no way to test this step using mockito.
		Mockito.when(util.getJSONForObject(movies)).thenReturn("Movie String info");

		assertEquals( "Movie String info",  movieService.listCurrentMovies());
	}
	@Before
	public void testSetup(){
		movies.clear();
		movies.add(movie1);
		Mockito.when(query.getResultList()).thenReturn(movies);
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(util.getJSONForObject(movies)).thenReturn("Movie String info");
	}
	
	
	@Test
	public void listFutureMoviesTest() {
		assertEquals( "Movie String info",  movieService.listFutureMovies());
	}
	
	
	@Test
	public void getMovieByIdTest() {
		Mockito.when(util.getJSONForObject(movies.iterator().next())).thenReturn("Single Movie String info");
		assertEquals( "Single Movie String info",  movieService.getMovieById(1l));
	}
}
