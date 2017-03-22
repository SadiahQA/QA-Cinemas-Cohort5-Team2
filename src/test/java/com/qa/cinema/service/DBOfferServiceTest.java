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

import com.qa.cinema.persistence.Offer;
import com.qa.cinema.persistence.User;
import com.qa.cinema.util.JSONUtil;

	@RunWith(MockitoJUnitRunner.class)
	public class DBOfferServiceTest {
		@Mock
		private JSONUtil util;
		
		@Mock
		private EntityManager em;
		
		@Mock
		private Query query = Mockito.mock(Query.class);
		
		@Mock
		private Offer offer1;
		
		@InjectMocks 
		private DBOfferService offerService;
		
		private ArrayList<Offer> offers = new ArrayList<>();

		@Before
		public void testSetup(){
			offers.clear();
			offers.add(offer1);
			Mockito.when(query.getResultList()).thenReturn(offers);
			Mockito.when(query.getSingleResult()).thenReturn(offer1);
			Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
			
		}
	
		@Test
		public void getDiscountAmountTest(){
			Mockito.when(query.getSingleResult()).thenReturn(offer1);
			Mockito.when(util.getJSONForObject(offer1)).thenReturn("Discount amount returned");
			assertEquals("Discount amount returned", offerService.getDiscountAmount("offercode"));
		}
		
	}
