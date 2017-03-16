package com.qa.cinema.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
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


@Stateless
@Default
public class DBTicketService implements TicketService{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;

	@Override
	public String createTickets(String tickets) {
		List<?> newTickets = util.getObjectForJSON(tickets, ArrayList.class);
		for(Object o: newTickets){
			Ticket newTicket = (Ticket) o;
			em.persist(newTicket);
		}
		return "{\"message\": \"Tickets sucessfully created\"}";
	}

	@Override
	public String updateTicket(Long idTicket) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String getTicket(String id) {
		Query query = em.createQuery("SELECT t FROM Ticket t WHERE t.idTicket=" + id);
		if(query.getResultList().isEmpty()){
			return "Ticket could not be found";
		}
		Object ticketFound = query.getSingleResult();
		return util.getJSONForObject(ticketFound);
	}

	@Override
	public String getListTicket(String idShowing) {
		Query query = em.createQuery("SELECT t FROM Ticket t WHERE t.showing.idShowing=" + idShowing);
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
