package com.qa.cinema.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.Screen;
import com.qa.cinema.util.JSONUtil;

/**
 * 
 * @author Joseph Richardson
 * @version 0.1.4
 *
 */

@Stateless
@Default
public class DBScreenService implements ScreenService{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public String getScreensByCinema(Long idCinema) {
		Query query = em.createQuery("SELECT c.screens FROM Cinema c WHERE c.idCinema =" + idCinema);
		Collection<Screen> screens = (Collection<Screen>) query.getResultList();
		return util.getJSONForObject(screens);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getScreensByType(Long idCinema, String screenType) {
		Query query = em.createQuery("SELECT sc FROM Cinema c JOIN c.screens sc WHERE c.idCinema =" + idCinema + "AND "
				+ "sc.screenType = '" + screenType + "'" );
		Collection<Screen> screens = (Collection<Screen>) query.getResultList();		
		return util.getJSONForObject(screens);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getScreensByDirectorsBox(Long idCinema, boolean isDirectorsBox) {
		Query query = em.createQuery("SELECT sc FROM Cinema c JOIN c.screens sc WHERE c.idCinema = " + idCinema + " AND "
				+ "sc.isDirectorsBox = " + isDirectorsBox);
		Collection<Screen> screens = (Collection<Screen>) query.getResultList();		
		return util.getJSONForObject(screens);
	}



}
