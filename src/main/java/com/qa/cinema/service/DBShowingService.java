package com.qa.cinema.service;

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
 * @version 0.0.3		
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
		Query query = em.createQuery("Select s FROM Cinema c JOIN c.screens sc JOIN sc.showings s WHERE c.id =" + idCinema + " AND s.movie.idMovie  =" + idMovie);
		Collection<Showing> showing = (Collection<Showing>) query.getResultList();
		return util.getJSONForObject(showing); 
	}
}
