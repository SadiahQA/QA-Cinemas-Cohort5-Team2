package com.qa.cinema.persistence;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Stefan Matykiewicz  
 * @version 0.1.0
 */

public class UserTest {
	
	User user1 = new User("FirstName", "LastName", "DOB", "email@domain.com", "password",true);

	@Test
	public void testGetIdUser() {
		User testUser = new User();
		assertNull(testUser.getIdUser());
	}
	
	@Test
	public void testGetFirstNameUser(){
		assertTrue(user1.getFirstNameUser().equals("FirstName"));
	}
	
	@Test
	public void testSetFirstNameUser() {
		User testUser = new User();
		testUser.setFirstNameUser("Test");
		assertTrue(testUser.getFirstNameUser().equals("Test"));
	}
	
	@Test
	public void testGetLastNameUser(){
		assertTrue(user1.getLastNameUser().equals("LastName"));
	}
	
	@Test
	public void testSetLastNameUser() {
		User testUser = new User();
		testUser.setLastNameUser("Test");
		assertTrue(testUser.getLastNameUser().equals("Test"));
	}
	
	@Test
	public void testGetDobUser(){
		assertTrue(user1.getDobUser().equals("DOB"));
	}
	
	
	@Test
	public void testSetDobUser() {
		User testUser = new User();
		testUser.setDobUser("Test");
		assertTrue(testUser.getDobUser().equals("Test"));
	}
	
	@Test
	public void testGetEmail(){
		assertTrue(user1.getEmail().equals("email@domain.com"));
	}
	
	@Test
	public void testSetEmail() {
		User testUser = new User();
		testUser.setEmail("Test@test.com");
		assertTrue(testUser.getEmail().equals("Test@test.com"));
	}
	
	@Test
	public void testGetPassword(){
		assertTrue(user1.getPassword().equals("password"));
	}
	
	@Test
	public void testSetPassword() {
		User testUser = new User();
		testUser.setPassword("ABC123abc");
		assertTrue(testUser.getPassword().equals("ABC123abc"));
	}
	
	@Test
	public void testGetActive(){
		assertTrue(user1.getActive() == true);
	}
	
	@Test
	public void testSetActive() {
		User testUser = new User();
		testUser.setActive(true);
		assertTrue(testUser.getActive() == true);
	}

}
