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

import com.qa.cinema.persistence.Actor;
import com.qa.cinema.persistence.Movie;
import com.qa.cinema.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class DBActorServiceTest {

	
	@Mock
	private JSONUtil util;
	
	@Mock
	private EntityManager em;
	
	@Mock
	private Date date;
	
	@Mock
	private Query query = Mockito.mock(Query.class);
	
	@Mock
	private Actor actor1;
	
	@InjectMocks 
	private DBActorService actorService;
	
	private  ArrayList actors = new ArrayList<Object>();

	
	@Test
	public void getActorTest(){
		Mockito.when(query.getResultList()).thenReturn(actors);
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(util.getJSONForObject(actors)).thenReturn("Actor String info");
		assertEquals( "Actor String info",  actorService.getActor("1"));
	}
	
}
