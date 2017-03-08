package com.qa.cinema.service;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cinema.persistence.User;
import com.qa.cinema.util.JSONUtil;

/**
 * @author Stefan Matykiewicz
 * @version 0.2.0
 */

@Stateless
@Default
public class DBUserService implements UserService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;
	
	@Override
	public String findIndividualUser(Long idUser) {
		Query query = em.createQuery("SELECT u FROM User u WHERE u.idUser=" + idUser);
		Object userFound = query.getSingleResult();
		return util.getJSONForObject(userFound);
			}

	@Override
	public String createNewUser(String user) {
		User newUser = util.getObjectForJSON(user, User.class);
		em.persist(newUser);
		return "{\"message\": \"User sucessfully added\"}";
	}

	@Override
	public String updateUser(Long idUser, String user) {
		User updatedUser = util.getObjectForJSON(user, User.class);
		User userInDB = findUser(new Long(idUser));
		if (userInDB != null){
			userInDB = updatedUser;
			em.merge(user);
		}
		return "{\"message\": \"User sucessfully updated\"}";
	}

	@Override
	public String deleteUser(Long idUser) {
		User userInDB = findUser (new Long(idUser));
		if (userInDB != null){
			em.remove(userInDB);
		}
		return "{\"message\": \"User sucessfully deleted\"}";
	}
	
	private User findUser(Long idUser){
		return em.find(User.class, idUser);
	}

}
