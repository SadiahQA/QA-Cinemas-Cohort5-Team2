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

import com.qa.cinema.persistence.Cinema;
import com.qa.cinema.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class DBCinemaServiceTest {


	
	@Mock
	private JSONUtil util;
	
	@Mock
	private EntityManager em;
	
	@Mock
	private Query query = Mockito.mock(Query.class);
	
	@Mock
	private Cinema cinema1;
	
	@InjectMocks 
	private DBCinemaService cinemaService;
	
	private  ArrayList<Cinema> cinemas = new ArrayList<>();
	
	@Before
	public void testSetup(){
		cinemas.clear();
		cinemas.add(cinema1);
		Mockito.when(query.getResultList()).thenReturn(cinemas);
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(util.getJSONForObject(cinemas)).thenReturn("Cinema String info");
	}
	

	@Test
	public void getAllCinemasTest() {
		assertEquals( "Cinema String info",  cinemaService.getAllCinemas());
	}

	@Test
	public void findCinemaByCityTest() {
		assertEquals( "Cinema String info",  cinemaService.findCinemaByCity("CityName"));
	}
	
}
