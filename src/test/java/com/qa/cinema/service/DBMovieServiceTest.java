package com.qa.cinema.service;

import static org.junit.Assert.*;

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
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.cinema.persistence.Movie;
import com.qa.cinema.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class DBMovieServiceTest {
	
	@Mock
	private JSONUtil util;
	
	@Mock
	private EntityManager em;
	@InjectMocks private DBMovieService movieService;
	
	@Mock
	private Query query;
	
	@Mock
	private Movie movie1;
	
	private  ArrayList movies = new ArrayList<Object>();

	@Test
	public void testQueryGenerationToString() {
		
		Mockito.when(query.getResultList()).thenReturn((List) movies);
		movies.add(movie1);
		Mockito.when(util.getJSONForObject(movies)).thenReturn("Movie String info");
		assertEquals( "Movie String info",  util.getJSONForObject(query.getResultList()));
	}

}
