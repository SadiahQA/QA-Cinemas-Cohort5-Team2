package com.qa.cinema.persistence;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Denis kastrati
 * @version 0.0.2
 *
 */

@Entity
@Table(name = "Ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTicket;

	@ManyToOne
	@JoinColumn(name = "Showing_idShowing", nullable = false)
	private Showing showing;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "User_idUser", nullable = false)
	private User user;

	private String ticketType;

	public Ticket() {
		//empty constructor
	}

	public Ticket(Showing showing, User user, String ticketType) {

		this.showing = showing;
		this.user = user;
		this.ticketType = ticketType;
	}

	public Long getIdTicket() {
		return idTicket;
	}

	public Showing getShowing() {
		return showing;
	}

	public void setShowing(Showing showing) {
		this.showing = showing;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

}
