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

	@Mock
	private Showing showing;
	

	
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
		Mockito.when(util.getObjectForJSON("ticket",ArrayList.class)).thenReturn(tickets);
		Mockito.when(tickets.get(0).getShowing()).thenReturn(showing);
		Mockito.when(showing.getAvailableSeats()).thenReturn(2);
		Mockito.when(ticket1.getShowing()).thenReturn(showing);
		Mockito.when(ticket1.getSeatNumber()).thenReturn(1);
		Mockito.when(em.find(Showing.class,tickets.get(0).getShowing().getIdShowing())).thenReturn(showing);
	}
	


	@Test
	public void createTicketTest() {
		//assertEquals("{\"message\": \"Tickets successfully created\"}", ticketService.createTickets(""));
	}
	
	@Test
	public void createTicketTestNoSeats() {
		Mockito.when(showing.getAvailableSeats()).thenReturn(0);
		//assertEquals("{\"message\": \"Not enough available seats\"}", ticketService.createTickets("[{\"ticketType\":\"Student\",\"showing\":{\"idShowing\":\"11\"},\"user\":{\"idUser\":\"1\"}}]"));
	}
	
	@Test
	public void createTicketTestNoTickets() {
		assertEquals("{\"message\": \"No tickets found\"}", ticketService.createTickets("[]"));
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
		Mockito.when(util.getJSONForObject(Mockito.any())).thenReturn("Ticket String info");
		assertEquals( "Ticket String info",  ticketService.getListTicket("1"));
		
	}
	
	@Test
	public void getUserTicketTest() {
		
		assertEquals( "Ticket String info",  ticketService.getUserTicket("1"));
		
	}
}
