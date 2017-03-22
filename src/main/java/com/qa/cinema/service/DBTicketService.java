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
			List<Ticket> returnList = new ArrayList<Ticket>();
			for(Ticket t: ticketList){
				em.persist(t);
				em.flush();
				returnList.add(t);
			}
			String returnJSON = new Gson().toJson(returnList, type);
			//return "{\"message\": \"Tickets successfully created\"}";
			return returnJSON;
		}
		else{
			return "{\"message\": \"Not enough available seats\"}";
		}
	}
	
	@Override
	public String removeTickets(String tickets){
		System.out.println(tickets);
		Type type = new TypeToken<List<Ticket>>(){}.getType();
		List<Ticket> ticketList = new Gson().fromJson(tickets, type);
		if(ticketList.isEmpty()){
			return "{\"message\": \"No tickets to delete\"}";
		}
		Showing showing = em.find(Showing.class, ticketList.get(0).getShowing().getIdShowing());
		showing.setAvailableSeats(showing.getAvailableSeats()+ticketList.size());
		for(Ticket t : ticketList){
			em.remove(em.contains(t) ? t : em.merge(t));
		}
		return "{\"message\": \"Tickets successfully removed\"}";
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
		ArrayList<Ticket> ticketFound = (ArrayList<Ticket>) query.getResultList();
		int[] seats = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		int[] availableSeats=new int[seats.length];
		
		int count = 0;
		
	for (int i = 0; i < seats.length; i++){
		boolean checked = false;
		inner: for (Ticket ticket: ticketFound){
			if (ticket.getSeatNumber() == seats[i]){
				checked=true;
				break inner;				
			}
		}
		if (!checked)
			availableSeats[count]=seats[i];
		count++;
	}
		return util.getJSONForObject(availableSeats);
	}

	@Override
	public String getUserTicket(String idUser) {
		Query query = em.createQuery("SELECT t FROM Ticket t WHERE t.user.id=" + idUser);
		Collection<Ticket> ticketFound = (Collection<Ticket>) query.getResultList();
		return util.getJSONForObject(ticketFound);
	}


	

}
