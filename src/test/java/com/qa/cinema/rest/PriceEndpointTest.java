package com.qa.cinema.rest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.cinema.persistence.Price;
import com.qa.cinema.persistence.User;
import com.qa.cinema.service.PriceService;
import com.qa.cinema.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class PriceEndpointTest {

	@Mock
	private PriceService priceService;

	@Mock
	private Price price1;

	@InjectMocks
	private PriceEndpoint priceEndpoint;

	@Test
	public void getPriceForTicketTest() {
		Mockito.when(priceService.getPrice("", "")).thenReturn("Price of Ticket");
		assertEquals("Price of Ticket", priceEndpoint.getPriceForTicket("", ""));
	}
}