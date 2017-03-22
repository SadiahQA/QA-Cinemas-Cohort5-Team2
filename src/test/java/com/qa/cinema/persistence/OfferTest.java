package com.qa.cinema.persistence;

import static org.junit.Assert.*;

import org.junit.Test;

public class OfferTest {
	
	Offer offer = new Offer("qwe","name",0.9);
	
	Offer offerX = new Offer();

	@Test
	public void testGetOfferId() {
		assertNull(offer.getOfferID());
	}
	
	@Test
	public void testGetOfferCode(){
		assertTrue(offer.getOfferCode().equals("qwe"));
	}
	
	@Test
	public void testGetOfferName(){
		assertTrue(offer.getOfferName().equals("name"));
	}
	
	@Test
	public void testGetDiscountAmount(){
		assertTrue(offer.getDiscountAmount() == 0.9);
	}

}
