
package com.qa.cinema.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 
 * 
 * @author Joseph Richardson
 * @version 0.1.1
 */

@Entity
public class Screen {
	
	@NotNull
	@Min(0)
	@Id
	@Column(nullable=false, unique=true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idScreen;
	
	@NotNull
	@Column(name="screenNum")
	private Long screenNum;
	
	@NotNull
	@Column(name="noOfSeats")
	private int noOfSeats;
	
	@NotNull	
	@Column(name="screenType")
	private String screenType;
	
	@NotNull
	@Column(name="isDirectorsBox")
	private boolean isDirectorsBox;
	
	@OneToMany(fetch=FetchType.EAGER)
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
