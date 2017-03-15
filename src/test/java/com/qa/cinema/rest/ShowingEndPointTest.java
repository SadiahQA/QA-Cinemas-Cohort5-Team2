package com.qa.cinema.rest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.cinema.persistence.Actor;
import com.qa.cinema.persistence.Showing;
import com.qa.cinema.service.ShowingService;

/**		
 * @author Sadiah Ahmed		
 * @version 0.0.1		
 * @since 15/03/2017		
 *		
 */

@RunWith(MockitoJUnitRunner.class)
public class ShowingEndPointTest {
	

	@Mock
	private Showing showing1;
	
	@InjectMocks
	private ShowingEndpoint showingEndPoint; 
	
	private ArrayList<Showing> showings = new ArrayList<>();
	
	@Before
	public void testSetup(){
		showings.clear();
		showings.add(showing1);
	}
	
	@Test
	public void getAllShowingsForMovie() {
		assertEquals( "Showing string",  showingEndPoint.getAllShowingsForMovie("1","1"));
	}	
	
	
}
