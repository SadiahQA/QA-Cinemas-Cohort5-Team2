package com.qa.cinema.rest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.cinema.persistence.Cinema;
import com.qa.cinema.persistence.Ticket;
import com.qa.cinema.service.TicketService;

/**		
 * @author Sadiah Ahmed		
 * @version 0.0.1		
 * @since 16/03/2017		
 *		
 */

@RunWith(MockitoJUnitRunner.class)
public class TicketEndpointTest {
	
	@Mock
	private TicketService ticketService;
	
	@Mock
	private Ticket ticket1;
	
	@InjectMocks
	private TicketEndpoint ticketEndpoint;
	
	private ArrayList<Ticket> tickets = new ArrayList<>();
	
	@Before
	public void testSetup(){
		tickets.clear();
		tickets.add(ticket1);
		Mockito.when(ticketService.createTicket("1")).thenReturn("New ticket string");
		Mockito.when(ticketService.updateTicket(2L)).thenReturn("Ticket update string");	
		Mockito.when(ticketService.getTicket("3")).thenReturn("Get ticket string for specific ticket");
		Mockito.when(ticketService.getListTicket("4")).thenReturn("Ticket list string");
		Mockito.when(ticketService.getUserTicket("1")).thenReturn("User ticket found");
	}
	
	@Test
	public void createTicket() {
		assertEquals("New ticket string", ticketEndpoint.createTicket("1"));
	}
	
	@Test
	public void getTicket() {
		assertEquals("Get ticket string for specific ticket", ticketEndpoint.getTicket("3"));
	}
	
	@Test
	public void getListTicket() {
		assertEquals("Ticket list string", ticketEndpoint.getListTicket("4"));
	}
	
	@Test
	public void getUserTicket() {
		assertEquals("User ticket found", ticketEndpoint.getUserTicket("1"));
	}
}