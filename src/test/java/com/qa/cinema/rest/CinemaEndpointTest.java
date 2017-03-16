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
import com.qa.cinema.persistence.Screen;
import com.qa.cinema.service.CinemaService;

/**		
 * @author Sadiah Ahmed		
 * @version 0.0.1		
 * @since 15/03/2017		
 *		
 */

@RunWith(MockitoJUnitRunner.class)
public class CinemaEndpointTest {
	
	@Mock
	private CinemaService cinemaService;
	
	@Mock
	private Cinema cinema1;
	
	@InjectMocks
	private CinemaEndpoint cinemaEndpoint;
	
	private ArrayList<Cinema> cinemas = new ArrayList<>();
	
	@Before
	public void testSetup(){
		cinemas.clear();
		cinemas.add(cinema1);
		Mockito.when(cinemaService.getAllCinemas()).thenReturn("Cinema string");
		Mockito.when(cinemaService.findCinemaByCity("City")).thenReturn("Cinema by city string");	
	}
	
	@Test
	public void getAllCinemas() {
		assertEquals("Cinema string", cinemaEndpoint.getAllCinemas());
	}
	
	@Test
	public void findCinemaByCity() {
		assertEquals("Cinema by city string", cinemaEndpoint.findCinemasByCity("City"));
	}
	
}