package com.qa.cinema.service;

import java.util.List;

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
	public String findIndividualUser(Long id) {
		Query query = em.createQuery("SELECT u FROM User u WHERE u.idUser=" + id);
		Object userFound = query.getSingleResult();
		return util.getJSONForObject(userFound);
			}

	@Override
	public String createNewUser(String user) {
		User newUser = util.getObjectForJSON(user, User.class);
		Query query = em.createQuery("SELECT * FROM User");
		List<User> users = (List<User>) query.getResultList();
		for (User u : users) {
			if (u.getEmail().equals(newUser.getEmail())) {
				return "{\"message\": \"User Already Exists!\"}";
			}
		}
		em.persist(newUser);
		return "{\"message\": \"User Sucessfully Added\"}";
	}

	@Override
	public String updateUser(Long id, String user) {
		User updatedUser = util.getObjectForJSON(user, User.class);
		User userInDB = findUser(id);
		if (userInDB != null){
			userInDB.setFirstNameUser(updatedUser.getFirstNameUser());
			userInDB.setLastNameUser(updatedUser.getLastNameUser());
			userInDB.setDobUser(updatedUser.getDobUser());
			userInDB.setEmail(updatedUser.getEmail());
			userInDB.setPassword(updatedUser.getPassword());
			userInDB.setActive(updatedUser.getActive());
			return "{\"message\": \"User sucessfully updated\"}";
		}
		else {
			return "{\"message\": \"User update Failed\"}";
		}
	}
	
	private User findUser(Long id){
		return em.find(User.class, id);
	}

}
