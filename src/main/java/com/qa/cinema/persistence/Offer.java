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
	private int offerID;
	
	private String offerCode;
	private String offerName;
	private double discountAmount;
	
	public Offer() {}
	
	public Offer(String offerCode, String offerName, double discountAmount){
		this.offerCode = offerCode;
		this.offerName = offerName;
		this.discountAmount = discountAmount;
	}
	
	public int getOfferID(){
		return offerID;
	}
	
	public String getOfferCode(){
		return offerCode;
	}
	
	public String getOfferName(){
		return offerName;
	}
	
	public double getDiscountAmount(){
		return discountAmount;
	}
}