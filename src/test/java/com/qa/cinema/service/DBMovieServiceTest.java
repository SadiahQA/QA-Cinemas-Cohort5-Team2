package com.qa.cinema.service;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.mapping.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
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
	private Date date;
	
	@Mock
	private Query query = Mockito.mock(Query.class);
	
	@Mock
	private Movie movie1;
	
	@InjectMocks 
	private DBMovieService movieService;
	
	private  ArrayList movies = new ArrayList<Object>();

	@Test
	public void testQueryGenerationToString() {
		
		movies.add(movie1);
		
		Mockito.when(query.getResultList()).thenReturn(movies);
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(util.getJSONForObject(movies)).thenReturn("Movie String info");

		assertEquals( "Movie String info",  movieService.listCurrentMovies());
	}

}
