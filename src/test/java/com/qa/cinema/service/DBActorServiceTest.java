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

import com.qa.cinema.persistence.Actor;
import com.qa.cinema.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class DBActorServiceTest {

	
	@Mock
	private JSONUtil util;
	
	@Mock
	private EntityManager em;
	
	@Mock
	private Query query = Mockito.mock(Query.class);
	
	@Mock
	private Actor actor1;
	
	@InjectMocks 
	private DBActorService actorService;
	
	private ArrayList<Actor> actors = new ArrayList<>();
	
	@Before
	public void testSetup(){
		actors.clear();
		actors.add(actor1);
		Mockito.when(query.getResultList()).thenReturn(actors);
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(util.getJSONForObject(actors)).thenReturn("Actor String info");
	}
	
	
	@Test
	public void getActorTest(){
		assertEquals( "Actor String info",  actorService.getActor("1"));
	}
	
}
