package com.qa.cinema.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.Actor;
import com.qa.cinema.persistence.Movie;
import com.qa.cinema.util.JSONUtil;

/**
 * 
 * @author Tary Andrews
 * @version 0.2.1
 *
 */

@Stateless
@Default
public class DBActorService implements ActorService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	@Override
	public String getActor(String idActor) {
		Query query = em.createQuery("SELECT a FROM Actor a WHERE a.idActor = " + idActor);
		Collection<Actor> actor = (Collection<Actor>) query.getResultList();
		return util.getJSONForObject(actor);
	}




}
