package com.qa.cinema.service;

import java.sql.Date;
import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qa.cinema.persistence.Actor;
import com.qa.cinema.persistence.Movie;
/**
 * 
 * @author Alex Mercer
 * @version 0.1.1
 */
@Stateless
@Default
public class DBMovieService implements MovieService {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private Gson util= new GsonBuilder().addSerializationExclusionStrategy(new ExclusionStrategy() {
		
		@Override
		public boolean shouldSkipField(FieldAttributes f) {
			return f.getDeclaringClass() == Actor.class && f.getName().equals("movies");
		}
		
		@Override
		public boolean shouldSkipClass(Class<?> arg0) {
			return false;
		}
	}).create();;

	
	
	@SuppressWarnings("unchecked")
	@Override

	public String listCurrentMovies() {
		
		java.util.Date javaDate = new java.util.Date();
		Date date = new Date(javaDate.getTime());
		Query query = em.createQuery("SELECT m FROM Movie m WHERE m.releaseDate < '" + date + "'");
		Collection<Movie> movies = (Collection<Movie>) query.getResultList();
		return util.toJson(movies);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String listFutureMovies() {
		java.util.Date javaDate = new java.util.Date();
		Date date = new Date(javaDate.getTime());
		Query query = em.createQuery("SELECT m FROM Movie m WHERE m.releaseDate > '" + date + "'");
		Collection<Movie> movies = (Collection<Movie>) query.getResultList();
		return util.toJson(movies);

	}

	@SuppressWarnings("unchecked")
	@Override

	public String getMovieById(Long id) {
		Query query = em.createQuery("SELECT m FROM Movie m WHERE m.idMovie = " + id);
		Collection<Movie> movies = (Collection<Movie>) query.getResultList();
		return util.toJson(movies.iterator().next());
	}



}
