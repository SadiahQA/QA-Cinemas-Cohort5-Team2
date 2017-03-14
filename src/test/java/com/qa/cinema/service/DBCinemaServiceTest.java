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

import com.qa.cinema.persistence.Cinema;
import com.qa.cinema.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class DBCinemaServiceTest {


	
	@Mock
	private JSONUtil util;
	
	@Mock
	private EntityManager em;
	
	@Mock
	private Date date;
	
	@Mock
	private Query query = Mockito.mock(Query.class);
	
	@Mock
	private Cinema cinema1;
	
	@InjectMocks 
	private DBCinemaService cinemaService;
	
	private  ArrayList cinemas = new ArrayList<Object>();

	@Test
	public void getAllCinemasTest() {
		
		cinemas.add(cinema1);
		
		Mockito.when(query.getResultList()).thenReturn(cinemas);
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(util.getJSONForObject(cinemas)).thenReturn("Cinema String info");

		assertEquals( "Cinema String info",  cinemaService.getAllCinemas());
	}

	@Test
	public void findCinemaByCityTest() {
		
		cinemas.add(cinema1);
		
		Mockito.when(query.getResultList()).thenReturn(cinemas);
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(util.getJSONForObject(cinemas)).thenReturn("Cinema String info");
		assertEquals( "Cinema String info",  cinemaService.findCinemaByCity("CityName"));
	}
	
}
