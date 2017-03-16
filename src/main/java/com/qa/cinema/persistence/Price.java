package com.qa.cinema.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**		
 * @author Sadiah Ahmed		
 * @version 0.0.1		
 * @since 16/03/2017		
 *		
 */

@Entity
public class Price {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long priceID;
	
	private double price;
	private String showingType;
	private String ticketType;
	
	public Price() {}

	public Price(double price, String showingType, String ticketType) {
		
		this.price = price;
		this.showingType = showingType;
		this.ticketType = ticketType;
	}

	public Long getPriceID() {
		return priceID;
	}

	public double getPrice() {
		return price;
	}
	
	public String getShowingType() {
		return showingType;
	}

	public String getTicketType() {
		return ticketType;
	}
	
}