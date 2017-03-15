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

import com.qa.cinema.persistence.Ticket;
import com.qa.cinema.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class DBTicketServiceTest {
	@Mock
	private JSONUtil util;
	
	@Mock
	private EntityManager em;
	
	@Mock
	private Query query = Mockito.mock(Query.class);
	
	@Mock
	private Ticket ticket1;
	
	@InjectMocks 
	private DBTicketService ticketService;
	
	private  ArrayList<Ticket> tickets = new ArrayList<>();
	
	@Before
	public void testSetup(){
		tickets.clear();
		tickets.add(ticket1);
		Mockito.when(query.getResultList()).thenReturn(tickets);
		Mockito.when(query.getSingleResult()).thenReturn(ticket1);
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(util.getJSONForObject(tickets)).thenReturn("Ticket String info");
		Mockito.when(util.getJSONForObject(ticket1)).thenReturn("Single Ticket String info");
	}
	


	@Test
	public void createTicketTest() {
		assertEquals("{\"message\": \"Ticket sucessfully created\"}", ticketService.createTicket("ticket"));
	}
	
	@Test
	public void updateTicketTest() {
		assertNull(ticketService.updateTicket(1l));
	}

	@Test
	public void getTicketTest() {
		assertEquals( "Single Ticket String info",  ticketService.getTicket("1"));
	}
	@Test
	public void getNoTicketTest() {
		Mockito.when(query.getResultList()).thenReturn(new ArrayList<>());
		assertEquals( "Ticket could not be found",  ticketService.getTicket("1"));
	}

	@Test
	public void getListTicketTest() {
		assertEquals( "Ticket String info",  ticketService.getListTicket("1"));
		
	}
	
	@Test
	public void getUserTicketTest() {
		assertEquals( "Ticket String info",  ticketService.getUserTicket("1"));
		
	}
}
