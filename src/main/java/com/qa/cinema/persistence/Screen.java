
package com.qa.cinema.persistence;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * 
 * @author Joseph Richardson
 * @version 0.0.1
 */

@Entity
public class Screen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idScreen;
	private Long screenNum;
	private int noOfSeats;
	private String screenType;
	private boolean isDirectorsBox;
	private List<Showing> showings;
	
	public Screen(){
		
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
