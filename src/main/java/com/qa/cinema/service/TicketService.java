package com.qa.cinema.service;

import com.qa.cinema.persistence.Showing;
import com.qa.cinema.persistence.Ticket;
import com.qa.cinema.persistence.User;

/**
 * 
 * @author Denis kastrati
 * @version 0.0.2
 *
 */

public interface TicketService {
	
	String createTickets(String ticket);
	
	String updateTicket(Long idTicket);

	String getTicket(String idTicket);
	
	String getListTicket(String idShowing);
	
	String getUserTicket(String idUser);
}
