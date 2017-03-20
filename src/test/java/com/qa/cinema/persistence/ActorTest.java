package com.qa.cinema.persistence;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Stefan Matykiewicz  
 * @version 0.1.0
 */

public class ActorTest {
	
	Actor actor1 = new Actor("FirstName","LastName","Gender","DOB");

	@Test
	public void testGetActorId() {
		Actor testActor = new Actor();
		assertNull(testActor.getIdActor());
	}
	
	@Test
	public void testGetFirstNameActor(){
		assertTrue(actor1.getFirstNameActor().equals("FirstName"));
	}
	
	@Test
	public void testSetFirstNameActor() {
		Actor testActor = new Actor();
		testActor.setFirstNameActor("Test");
		assertTrue(testActor.getFirstNameActor().equals("Test"));
	}
	
	@Test
	public void testGetLastNameActor(){
		assertTrue(actor1.getLastNameActor().equals("LastName"));
	}
	
	@Test
	public void testSetLastNameActor() {
		Actor testActor = new Actor();
		testActor.setLastNameActor("Test");
		assertTrue(testActor.getLastNameActor().equals("Test"));
	}
	
	@Test
	public void testGetGenderActor(){
		assertTrue(actor1.getGenderActor().equals("Gender"));
	}
	
	@Test
	public void testSetGenderActor() {
		Actor testActor = new Actor();
		testActor.setGenderActor("Test");
		assertTrue(testActor.getGenderActor().equals("Test"));
	}
	
	@Test
	public void testGetDobActor(){
		assertTrue(actor1.getDobActor().equals("DOB"));
	}
	
	@Test
	public void testSetDobActor() {
		Actor testActor = new Actor();
		testActor.setDobActor("Test");
		assertTrue(testActor.getDobActor().equals("Test"));
	}

}
