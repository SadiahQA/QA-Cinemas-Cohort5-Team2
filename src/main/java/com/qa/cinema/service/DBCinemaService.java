package com.qa.cinema.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.qa.cinema.persistence.Cinema;
import com.qa.cinema.util.JSONUtil;

/*
 * Author: Alistair Fenn
 * Version: 0.0.1
 */

@Stateless
@Default
public class DBCinemaService implements CinemaService{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;
	
	@Override
	public String getAllCinemas() {
		Query query = em.createQuery("Select c FROM Cinema c");
		Collection<Cinema> cinemas = (Collection<Cinema>) query.getResultList();
		return util.getJSONForObject(cinemas);
	}

	@Override
	public String findCinemaByCity(String city) {
		Query query = em.createQuery("Select c FROM Cinema c where c.city = " + city);
		Collection<Cinema> cinemas = (Collection<Cinema>) query.getResultList();
		return util.getJSONForObject(cinemas);
	}

}
