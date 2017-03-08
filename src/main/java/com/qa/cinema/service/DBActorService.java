package com.qa.cinema.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.Actor;
import com.qa.cinema.util.JSONUtil;

/**
 * 
 * @author Tary Andrews
 * @version 0.2.0
 *
 */

@Stateless
@Default
public class DBActorService implements ActorService {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	public String getActorsFromMovie(String idMovie) {
		Query query = manager.createQuery("Select * FROM Actor a LEFT JOIN Actor_has_movie b ON a.idActor=b.Actor_idActor WHERE b.Movie_idMovie =  " +idMovie);
		Collection<Actor> actors = (Collection<Actor>) query.getResultList();
		return util.getJSONForObject(actors);
	}




}
