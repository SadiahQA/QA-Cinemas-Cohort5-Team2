package com.qa.cinema.persistence;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ScreenTest {
	Movie movie = new Movie();
	List<Showing> showinglist = Arrays.asList(
			new Showing(movie,"startTime","ShowingType",50,new Date(2017, 12, 12)));
			
	Screen screen1 = new Screen(10L,10,"ScreenType",true, showinglist);
	
	@Test
	public void testGetId() {
		assertNull(screen1.getId());
	}
	
	@Test
	public void testGetScreenNum(){
		assertEquals(new Long(10L),screen1.getScreenNum());
	}
	
	@Test
	public void testSetScreemNum() {
		Screen testScreen = new Screen();
		testScreen.setScreenNum(1L);
		assertEquals(new Long(1L),testScreen.getScreenNum());
	}
	
	@Test
	public void testGetNoOfSeats(){
		assertEquals(10,screen1.getNoOfSeats());
	}
	
	@Test
	public void testSetNoOfSeats() {
		Screen testScreen = new Screen();
		testScreen.setNoOfSeats(5);
		assertEquals(5,testScreen.getNoOfSeats());
	}

	@Test
	public void testGetScreenType(){
		assertTrue(screen1.getScreenType().equals("ScreenType"));
	}
	
	@Test
	public void testSetScreenType() {
		Screen testScreen = new Screen();
		testScreen.setScreenType("test");
		assertTrue(testScreen.getScreenType().equals("test"));
	}
	
	@Test
	public void testIsDirectorsBox(){
		assertTrue(screen1.isDirectorsBox() == true);
	}
	
	@Test
	public void testSetDirectorsBox() {
		Screen testScreen = new Screen();
		testScreen.setDirectorsBox(false);
		assertFalse(testScreen.isDirectorsBox());
	}
	
	@Test
	public void testGetShowings(){
		assertNotSame(showinglist, (screen1.getShowings()));
	}

}
