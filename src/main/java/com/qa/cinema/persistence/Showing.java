package com.qa.cinema.persistence;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**		
 * @author Sadiah Ahmed		
 * @version 0.0.1		
 * @since 08/03/2017		
 *		
 */

@Entity
public class Showing {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idShowing;
	
	@ManyToOne(fetch=FetchType.EAGER)  //Many showings to one movie
	@JoinColumn(name="Movie_idMovie", nullable = false) 
	private Movie movie;
	
	private String startTime;
	private String showingType;
	private int availableSeats;
	private Date showingDate;
	
	public Showing() {
		//empty constructor
	}
	
	public Showing(Movie movie, String startTime, String showingType, int availableSeats, Date showingDate) {
	
		this.movie = movie;
		this.startTime = startTime;
		this.showingType = showingType;
		this.availableSeats = availableSeats;
		this.showingDate = showingDate;
	}
	
	public Long getIdShowing() {
		return idShowing;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getShowingType() {
		return showingType;
	}

	public void setShowingType(String showingType) {
		this.showingType = showingType;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Date getShowingDate() {
		return showingDate;
	}

	public void setShowingDate(Date showingDate) {
		this.showingDate = showingDate;
	}

}
