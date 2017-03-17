package com.qa.cinema.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qa.cinema.persistence.Showing;
import com.qa.cinema.persistence.Ticket;
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


		Type type = new TypeToken<List<Ticket>>(){}.getType();
		List<Ticket> ticketList = new Gson().fromJson(tickets, type);
		if(ticketList.isEmpty()){
			return "{\"message\": \"No tickets found\"}";
		}
		Showing showing = em.find(Showing.class, ticketList.get(0).getShowing().getIdShowing());
		if(showing.getAvailableSeats() >= ticketList.size()){
			showing.setAvailableSeats(showing.getAvailableSeats()-ticketList.size());
			for(Ticket t: ticketList){
				em.persist(t);
			}
			return "{\"message\": \"Tickets successfully created\"}";
		}
		else{
			return "{\"message\": \"Not enough available seats\"}";
		}
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
