package com.qa.cinema.rest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.cinema.persistence.Offer;
import com.qa.cinema.persistence.User;
import com.qa.cinema.service.OfferService;
import com.qa.cinema.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class OfferEndpointTest {
	
@Mock
private OfferService offerService;
	
@Mock
private Offer offer1;
	
@InjectMocks
private OfferEndpoint offerEndpoint;


@Test
public void getDiscountAmountTest(){
	Mockito.when(offerService.getDiscountAmount("abc")).thenReturn("Offer code found");
	assertEquals("Offer code found", offerEndpoint.getDiscountAmount("abc"));
}

}
