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

import com.qa.cinema.persistence.User;
import com.qa.cinema.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class DBUserServiceTest {
	@Mock
	private JSONUtil util;
	
	@Mock
	private EntityManager em;
	
	@Mock
	private Query query = Mockito.mock(Query.class);
	
	@Mock
	private User user1;
	
	@InjectMocks 
	private DBUserService userService;
	
	private  ArrayList<User> users = new ArrayList<>();
	
	@Before
	public void testSetup(){
		users.clear();
		users.add(user1);
		Mockito.when(query.getResultList()).thenReturn(users);
		Mockito.when(query.getSingleResult()).thenReturn(user1);
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(em.find(User.class, 1l)).thenReturn(user1);
		Mockito.when(util.getJSONForObject(users)).thenReturn("User String info");
		Mockito.when(util.getJSONForObject(user1)).thenReturn("Single User String info");
		Mockito.when(user1.getEmail()).thenReturn("email");
		Mockito.when(user1.getPassword()).thenReturn("pass");
	}
	

	@Test
	public void findIndividualUserTest() {
		assertEquals("Single User String info", userService.findIndividualUser(1l));
	}

	@Test
	public void findNoIndividualUserTest(){
		Mockito.when(query.getResultList()).thenReturn(new ArrayList<>());
		assertEquals("User could not be found", userService.findIndividualUser(1l));
	}

	@Test
	public void createNewUserTest() {
		Mockito.when(util.getObjectForJSON("", User.class)).thenReturn(user1);
		Mockito.when(query.getResultList()).thenReturn(new ArrayList<>());
		assertEquals("{\"message\": \"User Successfully Added\"}", userService.createNewUser(""));
	}
	@Test
	public void createNewUserUserAlreadyExistsTest(){
		Mockito.when(util.getObjectForJSON("", User.class)).thenReturn(user1);
		assertEquals("{\"message\": \"User Already Exists!\"}", userService.createNewUser(""));
	}
	
	@Test
	public void updateUserTest() {
		Mockito.when(util.getObjectForJSON("", User.class)).thenReturn(user1);
		assertEquals("{\"message\": \"User Successfully Updated\"}", userService.updateUser(1l, ""));
	}
	@Test
	public void updateUserTestFail() {
		Mockito.when(util.getObjectForJSON("", User.class)).thenReturn(user1);
		Mockito.when(em.find(User.class, 1l)).thenReturn(null);
		assertEquals("{\"message\": \"User Update Failed\"}", userService.updateUser(1l, ""));
	}

}
