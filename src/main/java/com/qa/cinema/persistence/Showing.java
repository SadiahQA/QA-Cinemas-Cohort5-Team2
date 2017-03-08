package com.qa.cinema.persistence;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	
	@ManyToOne(fetch=FetchType.EAGER)  //Many showings to one screen
	@JoinColumn(name="Screen_idScreen", nullable = false) 
	private Screen screen;
	
	private String startTime;
	private String showingType;
	private int availableSeats;
	
	public Showing() {}
	
	public Showing(Screen screen, Movie movie, String startTime, String showingType, int availableSeats) {
		
		this.screen = screen;
		this.movie = movie;
		this.startTime = startTime;
		this.showingType = showingType;
		this.availableSeats = availableSeats;
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

}
