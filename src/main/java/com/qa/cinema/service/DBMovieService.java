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
/**
 * 
 * @author Alex Mercer
 * @version 0.2.1
 */
import com.qa.cinema.util.JSONUtil;
@Stateless
@Default
public class DBMovieService implements MovieService {
	
	@PersistenceContext(unitName = "primary") 
	EntityManager em;

	@Inject
	private JSONUtil util;


	@SuppressWarnings("unchecked")
	@Override

	public String listCurrentMovies() {
		
		java.util.Date javaDate = new java.util.Date();
		Date date = new Date(javaDate.getTime());
		Query query = em.createQuery("SELECT m FROM Movie m WHERE m.releaseDate <= '" + date + "'");
		Collection<Movie> movies = (Collection<Movie>) query.getResultList();
		return util.getJSONForObject(movies);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String listFutureMovies() {
		java.util.Date javaDate = new java.util.Date();
		Date date = new Date(javaDate.getTime());
		Query query = em.createQuery("SELECT m FROM Movie m WHERE m.releaseDate > '" + date + "'");
		Collection<Movie> movies = (Collection<Movie>) query.getResultList();
		return util.getJSONForObject(movies);

	}

	@SuppressWarnings("unchecked")
	@Override

	public String getMovieById(Long id) {
		Query query = em.createQuery("SELECT m FROM Movie m WHERE m.idMovie = " + id);
		Collection<Movie> movies = (Collection<Movie>) query.getResultList();
		return util.getJSONForObject(movies.iterator().next());
	}



}
