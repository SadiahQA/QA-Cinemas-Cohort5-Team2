package com.qa.cinema.persistence;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriceTest {

	Price price1 = new Price(10.50, "ShowingType", "TicketType");

	@Test
	public void testGetPriceID() {
		Price testPrice = new Price();
		assertNull(testPrice.getPriceID());
	}
	
	@Test
	public void testGetPrice(){
		assertEquals(10.50,price1.getPrice(),0);
	}
	
	@Test
	public void testGetShowingType(){
		assertTrue(price1.getShowingType().equals("ShowingType"));
	}
	
	@Test
	public void testGetTicketType(){
		assertTrue(price1.getTicketType().equals("TicketType"));
	}
	
	
	
}
