package com.qa.cinema.service;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.util.JSONUtil;

/**
 * @author Alice Thomas
 * @version 0.0.1
 * @since 21/03/2017
 *
 */

public class DBOfferService implements OfferService {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;
	
	@Override
	public String getDiscountAmount(String offerCode) {
		Query query = em.createQuery("SELECT d.discountAmount FROM Offer d WHERE d.offerCode= '" + offerCode+"'");
		Object offerFound = query.getSingleResult();
		return util.getJSONForObject(offerFound);
	}
	
}