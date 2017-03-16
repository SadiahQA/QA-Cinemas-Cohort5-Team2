package com.qa.cinema.service;


import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.util.JSONUtil;

/**		
 * @author Sadiah Ahmed		
 * @version 0.0.1		
 * @since 16/03/2017		
 *		
 */

public class DBPriceService implements PriceService {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;

	@Override
	public String getPrice(String showingType, String ticketType) {
		Query query = em.createQuery("SELECT p.price FROM Price p WHERE p.showingType= '"+ showingType +"' AND p.ticketType= '" + ticketType +"'" );
		Object price = query.getSingleResult();
		return util.getJSONForObject(price);
	}
	
}