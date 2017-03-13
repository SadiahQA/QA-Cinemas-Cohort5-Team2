package com.qa.cinema.service;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.qa.cinema.persistence.Actor;
import com.qa.cinema.persistence.Ticket;
import com.qa.cinema.persistence.User;
import com.qa.cinema.util.JSONUtil;

/**
 * 
 * @author Denis kastrati
 * @version 0.0.2
 *
 */

public class DBTicketService implements TicketService{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;

	@Override
	public String createTicket(String ticket) {
		Ticket newTicket = util.getObjectForJSON(ticket, Ticket.class);
		em.persist(newTicket);
		return "{\"message\": \"Ticket sucessfully created\"}";
	}

	@Override
	public String updateTicket(Long idTicket) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String getTicket(Long id) {
		Query query = em.createQuery("SELECT t FROM Ticket t WHERE t.idTicket=" + id);
		Object ticketFound = query.getSingleResult();
		return util.getJSONForObject(ticketFound);
	}

	@Override
	public String getListTicket(String idShowing) {
		Query query = em.createQuery("SELECT t FROM Ticket t WHERE u.idTicket=" + idShowing);
		Collection<Ticket> ticketFound = (Collection<Ticket>) query.getResultList();
		return util.getJSONForObject(ticketFound);
	}

	@Override
	public String getUserTicket(String idUser) {
		Query query = em.createQuery("SELECT t FROM Ticket t WHERE t.user.id=" + idUser);
		Collection<Ticket> ticketFound = (Collection<Ticket>) query.getResultList();
		return util.getJSONForObject(ticketFound);
	}


	

}
