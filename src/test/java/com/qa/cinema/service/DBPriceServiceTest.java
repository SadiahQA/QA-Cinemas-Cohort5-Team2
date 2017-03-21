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

import com.qa.cinema.persistence.Price;
import com.qa.cinema.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class DBPriceServiceTest {

	@Mock
	private JSONUtil util;

	@Mock
	private EntityManager em;

	@Mock
	private Query query = Mockito.mock(Query.class);

	@Mock
	private Price price1;

	@InjectMocks
	private DBPriceService priceService;
		
	
	@Test
	public void getPriceTest() {
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		Mockito.when(query.getSingleResult()).thenReturn(price1);
		Mockito.when(util.getJSONForObject(price1)).thenReturn("Price String info");
		assertEquals("Price String info", priceService.getPrice("2D", "Adult"));
	}
}
