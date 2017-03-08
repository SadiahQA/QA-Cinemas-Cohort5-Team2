package com.qa.cinema.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.MovieTest;
import com.qa.cinema.util.JSONUtil;

@Stateless
@Default
public class DBMovieService implements MovieService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	@SuppressWarnings("unchecked")
	@Override
	public String listAllMovies() {
		Query query = em.createQuery("SELECT m FROM Movie m");
		Collection<MovieTest> movies = (Collection<MovieTest>) query.getResultList();
		return util.getJSONForObject(movies);
	}

	@Override
	public String createNewMovie(String movie) {
		MovieTest newMovie = util.getObjectForJSON(movie, MovieTest.class);
		em.persist(newMovie);
		return "{\"message\": \"movie sucessfully added\"}";
	}

	@Override
	public String updateMovie(Long movieId, String movie) {
		MovieTest updateMovie = util.getObjectForJSON(movie, MovieTest.class);
		MovieTest movieInDB = findMovie(new Long(movieId));
		if (movieInDB != null) {
			movieInDB = updateMovie;
			em.merge(movie);
		}
		return "{\"message\": \"movie sucessfully updated\"}";
	}

	@Override
	public String deleteMovie(Long movieId) {
		MovieTest movieInDB = findMovie(new Long(movieId));
		if (movieInDB != null) {
			em.remove(movieInDB);
		}
		return "{\"message\": \"movie sucessfully deleted\"}";
	}

	private MovieTest findMovie(Long id) {
		return em.find(MovieTest.class, id);
	}

}
