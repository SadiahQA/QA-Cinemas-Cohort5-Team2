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

import com.qa.cinema.persistence.Screen;
import com.qa.cinema.persistence.Showing;
import com.qa.cinema.service.ScreenService;
import com.qa.cinema.service.ShowingService;

/**		
 * @author Sadiah Ahmed		
 * @version 0.0.1		
 * @since 15/03/2017		
 *		
 */

@RunWith(MockitoJUnitRunner.class)
public class ScreenEndPointTest {
	
	@Mock
	private ScreenService screenService;
	
	@Mock
	private Screen screen1;
	
	@InjectMocks
	private ScreenEndPoint screenEndPoint; 
	
	private ArrayList<Screen> screens = new ArrayList<>();
	
	@Before
	public void testSetup(){
		screens.clear();
		screens.add(screen1);
		Mockito.when(screenService.getScreensByCinema(1L)).thenReturn("Screens by cinema string");
		Mockito.when(screenService.getScreensByType(1L,"3D")).thenReturn("Screen type string");
		Mockito.when(screenService.getScreensByDirectorsBox(1L,false)).thenReturn("Screen by directors box string");
	}
	
	@Test
	public void getScreensByCinema() {
		assertEquals("Screens by cinema string", screenEndPoint.getScreensByCinema(1L));
	}	
	
	@Test
	public void getScreensByType() {
		assertEquals("Screen type string", screenEndPoint.getScreensByType(1L,"3D"));
	}
	
	@Test
	public void getScreensByDirectorsBox() {
		assertEquals("Screen by directors box string", screenEndPoint.getScreensByIsDirectorsBox(1L,false));
	}
	
	
}