package com.qa.cinema.persistence;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

public class ShowingTest {
	Movie movie = new Movie();
	Showing showing1 = new Showing(movie,"StartTime","ShowingType",50,new Date(2017, 12, 12));
	
	@Test
	public void testGetIdShowing() {
		assertNull(showing1.getIdShowing());
	}
	
	@Test
	public void testGetStartTime(){
		assertTrue(showing1.getStartTime().equals("StartTime"));
	}
	
	@Test
	public void testSetStartTime() {
		Showing testShowing = new Showing();
		testShowing.setStartTime("test");
		assertTrue(testShowing.getStartTime().equals("test"));
	}
	
	@Test
	public void testGetShowingType(){
		assertTrue(showing1.getShowingType().equals("ShowingType"));
	}
	
	@Test
	public void testSetShowingType() {
		Showing testShowing = new Showing();
		testShowing.setShowingType("test");
		assertTrue(testShowing.getShowingType().equals("test"));
	}
	
	@Test
	public void testGetAvailableSeats(){
		assertEquals(50,showing1.getAvailableSeats());
	}
	
	@Test
	public void testSetAvailableSeats() {
		Showing testShowing = new Showing();
		testShowing.setAvailableSeats(10);
		assertEquals(10,testShowing.getAvailableSeats());;
	}
	
	@Test
	public void testGetShowingDate(){
		assertTrue(showing1.getShowingDate().equals(new Date(2017, 12, 12)));
	}
	
	@Test
	public void testSetShowingDate() {
		Showing testshowing = new Showing();
		testshowing.setShowingDate(new Date(2017, 01, 01));
		assertTrue(testshowing.getShowingDate().equals(new Date(2017, 01, 01)));
	}

}
