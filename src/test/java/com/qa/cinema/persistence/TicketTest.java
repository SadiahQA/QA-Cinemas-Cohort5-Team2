package com.qa.cinema.persistence;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TicketTest {
	
	List<Actor> actorlist = Arrays.asList(
			new Actor("FirstName","LastName","Gender","DOB"),
			new Actor("FirstName2","LastName2","Gender2","DOB2")
			);
	
	Movie movie1 = new Movie("Title","Genre","URL", "Duration",new Date(2017, 12, 12),"Cert","description", actorlist);
	Showing showing1 = new Showing(movie1,"StartTime","ShowingType",50,new Date(2017, 12, 12));
	User user1 = new User("FirstName", "LastName", "DOB", "email@domain.com", "password",true);
	Ticket ticket1 = new Ticket(showing1, user1, "TicketType", 1);

	@Test
	public void testGetIdTicket() {
		assertNull(ticket1.getIdTicket());
	}
	
	@Test
	public void testGetShowing(){
		assertTrue(ticket1.getShowing().equals(showing1));
	}
	
	@Test
	public void testSetShowing() {
		Ticket testTicket = new Ticket();
		Showing testShowing = new Showing();
		testTicket.setShowing(testShowing);
		assertTrue(testTicket.getShowing().equals(testShowing));
	}
	
	@Test
	public void testGetUser(){
		assertTrue(ticket1.getUser().equals(user1));
	}
	
	@Test
	public void testSetUser() {
		Ticket testTicket = new Ticket();
		User testUser = new User();
		testTicket.setUser(testUser);
		assertTrue(testTicket.getUser().equals(testUser));
	}
	
	@Test
	public void testGetTicketType(){
		assertTrue(ticket1.getTicketType().equals("TicketType"));
	}
	
	@Test
	public void testSetTicketType() {
		Ticket testTicket = new Ticket();
		testTicket.setTicketType("test");
		assertTrue(testTicket.getTicketType().equals("test"));
	}

}
