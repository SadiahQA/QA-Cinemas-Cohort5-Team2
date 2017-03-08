package com.qa.cinema.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.Cinema;
import com.qa.cinema.persistence.Screen;
import com.qa.cinema.util.JSONUtil;

/**
 * 
 * @author Joseph Richardson
 * @version 0.1.3
 *
 */

@Stateless
@Default
public class DBScreenService implements ScreenService{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;
	
	
	@Override
	public String listAllScreensByCinema(Long idCinema) {
		Query query = em.createQuery("SELECT s FROM Screen s WHERE s.Cinema_idCinema =" + idCinema);
		Collection<Screen> screens = (Collection<Screen>) query.getResultList();
		return util.getJSONForObject(screens);
	}

	@Override
	public String listScreensByType(Long idCinema, String screenType) {
		Query query = em.createQuery("SELECT s FROM Screen s WHERE s.Cinema_idCinema =" + idCinema + "AND"
				+ "s.screenType = " + screenType );
		Collection<Screen> screens = (Collection<Screen>) query.getResultList();		
		return util.getJSONForObject(screens);
	}

	@Override
	public String listScreensByDirectorsBox(Long idCinema, boolean isDirectorsBox) {
		Query query = em.createQuery("SELECT s FROM Screen s WHERE s.Cinema_idCinema =" + idCinema + "AND"
				+ "s.isDirectorsBox =" + isDirectorsBox);
		Collection<Screen> screens = (Collection<Screen>) query.getResultList();		
		return util.getJSONForObject(screens);
	}



}
