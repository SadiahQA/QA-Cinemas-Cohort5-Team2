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
	public String getAllShowingsForMovie(String idMovie) {
		Query query = em.createQuery("Select s FROM Showing s where s.movie.idMovie =" + idMovie);
		Collection<Showing> showing = (Collection<Showing>) query.getResultList();
		return util.getJSONForObject(showing); 
	}
}
