package com.qa.cinema.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Alice Thomas
 * @version 0.0.1
 * @since 20/03/2017
 *
 */

@Entity
public class Offer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long offerID;
	
	private String offerCode;
	private String offerName;
	
	public Offer() {}
	
	public Offer(String offerCode, String offerName){
		this.offerCode = offerCode;
		this.offerName = offerName;
	}
	
	public Long getOfferID(){
		return offerID;
	}
	
	public String getOfferCode(){
		return offerCode;
	}
	
	public String getOfferName(){
		return offerName;
	}
}