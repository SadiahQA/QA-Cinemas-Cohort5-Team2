package com.qa.cinema.rest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.cinema.persistence.Ticket;
import com.qa.cinema.persistence.User;
import com.qa.cinema.service.TicketService;
import com.qa.cinema.service.UserService;

	@RunWith(MockitoJUnitRunner.class)
	public class UserEndpointTest {
		
	@Mock
	private UserService userService;
		
	@Mock
	private User user1;
		
	@InjectMocks
	private UserEndpoint userEndpoint;
	
	private ArrayList<User> users = new ArrayList<>();
	
	@Before
	public void testSetup(){
		users.clear();
		users.add(user1);
		Mockito.when(userService.findIndividualUser(1l)).thenReturn("Individual user found");
		Mockito.when(userService.createNewUser("")).thenReturn("User Created");	
		Mockito.when(userService.updateUser(1l,"")).thenReturn("User Updated");
		Mockito.when(userService.getUserByEmailAndPassword("","")).thenReturn("Login Successful");
		Mockito.when(userService.findUserIdByEmail("")).thenReturn("User id found by email");
	}
		

	@Test
	public void findIndividualUserTest(){
		assertEquals("Individual user found", userEndpoint.findIndividualUser(1l));
	}
	
	@Test
	public void createNewUserTest(){
		assertEquals("User Created", userEndpoint.createNewUser(""));
	}
	
	@Test
	public void updateUserTest(){
		assertEquals("User Updated", userEndpoint.updateUser(1l, ""));
	}
	
	@Test
	public void getUserByEmailAndPasswordTest(){
		assertEquals("Login Successful",userService.getUserByEmailAndPassword("",""));
		}
	
	@Test
	public void findUserIdByEmailTest(){
		assertEquals("User id found by email", userService.findUserIdByEmail(""));
	}
}
