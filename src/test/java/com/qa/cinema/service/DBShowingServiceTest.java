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

import com.qa.cinema.persistence.Showing;
import com.qa.cinema.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class DBShowingServiceTest {
	@Mock
	private JSONUtil util;
	
	@Mock
	private EntityManager em;
	
	@Mock
	private Query query = Mockito.mock(Query.class);
	
	@Mock
	private Showing showing1;
	
	@InjectMocks 
	private DBShowingService showingService;
	
	private  ArrayList<Showing> showings = new ArrayList<>();
	
	@Before
	public void testSetup(){
		showings.clear();
		showings.add(showing1);
		Mockito.when(query.getResultList()).thenReturn(showings);
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(util.getJSONForObject(showings)).thenReturn("Showing String info");
	}
	
	@Test
	public void getAllShowingsforMovieTest(){

		assertEquals( "Showing String info",  showingService.getAllShowingsForMovie("1", "1"));
	}

}
