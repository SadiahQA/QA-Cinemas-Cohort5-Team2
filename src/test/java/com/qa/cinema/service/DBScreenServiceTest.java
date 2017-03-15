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

import com.qa.cinema.persistence.Screen;
import com.qa.cinema.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class DBScreenServiceTest {
	@Mock
	private JSONUtil util;
	
	@Mock
	private EntityManager em;
	
	@Mock
	private Query query = Mockito.mock(Query.class);
	
	@Mock
	private Screen screen1;
	
	@InjectMocks 
	private DBScreenService screenService;
	
	private  ArrayList<Screen> screens = new ArrayList<>();
	
	@Before
	public void testSetup(){
		screens.clear();
		screens.add(screen1);
		Mockito.when(query.getResultList()).thenReturn(screens);
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(util.getJSONForObject(screens)).thenReturn("Screen String info");
	}
	

	@Test
	public void getScreensByCinemaTest() {
		assertEquals( "Screen String info",  screenService.getScreensByCinema(1l));
		
	}
	
	@Test
	public void getScreensByTypeTest() {
		assertEquals( "Screen String info",  screenService.getScreensByType(1l,""));
		
	}

	@Test
	public void getScreensByDirectorsBoxTest() {
		assertEquals( "Screen String info",  screenService.getScreensByDirectorsBox(1l,true));
		
	}
}
