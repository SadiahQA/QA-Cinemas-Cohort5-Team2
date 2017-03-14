package com.qa.cinema.service;

import java.sql.Date;
import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.Movie;
import com.qa.cinema.persistence.Showing;
import com.qa.cinema.util.JSONUtil;

/**		
 * @author Sadiah Ahmed		
 * @version 0.1.0		
 * @since 08/03/2017		
 *		
 */

@Stateless
@Default
public class DBShowingService implements ShowingService {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;
	
	@SuppressWarnings("unchecked")
	@Override
	public String getAllShowingsForMovie(String idMovie, String idCinema) {
		java.util.Date javaDate = new java.util.Date();
		Date date = new Date(javaDate.getTime());
		Query query = em.createQuery("Select s FROM Cinema c JOIN c.screens sc JOIN sc.showings s WHERE c.id =" + idCinema + " AND s.movie.idMovie  =" + idMovie + "AND"
				+ " s.showingDate >= '" + date + "'");
		Collection<Showing> showing = (Collection<Showing>) query.getResultList();
		return util.getJSONForObject(showing); 
	}
}
