
package com.qa.cinema.persistence;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.validation.constraints.Min;


/**
 * 
 * 
 * @author Joseph Richardson

 * @version 0.1.3
 */

@Entity
public class Screen {

	@Min(0)
	@Id
	@Column(nullable=false, unique=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idScreen;
	
	@Column(name="screenNum")
	private Long screenNum;
	
	@Column(name="noOfSeats")
	private int noOfSeats;
	
	@Column(name="screenType")
	private String screenType;
	
	@Column(name="isDirectorsBox")
	private boolean isDirectorsBox;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "Screen_idScreen")
	private List<Showing> showings;
	
	
	public Screen(){
		//empty constructor
	}

	public Screen(Long screenNum, int noOfSeats, String screenType, boolean isDirectorsBox) {
		this.screenNum = screenNum;
		this.noOfSeats = noOfSeats;
		this.screenType = screenType;
		this.isDirectorsBox = isDirectorsBox;
		showings = new ArrayList<Showing>();
		
	}
	
	
	public Long getId() {
		return idScreen;
	}


	public Long getScreenNum() {
		return screenNum;
	}
	
	public void setScreenNum(Long screenNum) {
		this.screenNum = screenNum;
	}
	
	public int getNoOfSeats() {
		return noOfSeats;
	}
	
	public void setNoOfSeats(int numOfSeats) {
		this.noOfSeats = numOfSeats;
	}
	public String getScreenType() {
		return screenType;
	}
	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}
	public boolean isDirectorsBox() {
		return isDirectorsBox;
	}
	public void setDirectorsBox(boolean isDirectorsBox) {
		this.isDirectorsBox = isDirectorsBox;
	}

	public List<Showing> getShowings() {
		return showings;
	}

	

}
