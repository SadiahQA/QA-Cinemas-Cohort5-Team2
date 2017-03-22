package com.qa.cinema.persistence;


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


/*
 * @author Alistair Fenn
 * @version 0.0.3

 */

@Entity
public class Cinema {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idCinema")
	private Long idCinema;
	
	private String name;
	
	private String city;
	

	private String openingTimes;

	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "Cinema_idCinema")
	private List<Screen> screens;
	
	private double latitude;
	
	private double longitude;
	
	public Cinema(){
		//empty constructor
	}
	

	public Cinema(String name, String city, String openingTimes, List<Screen> screens) {
		super();
		this.name = name;
		this.city = city;
		this.openingTimes = openingTimes;

		this.screens = screens;
	}
	
	public Cinema(String name, String city, String openingTimes, List<Screen> screens, double latitude,
			double longitude) {
		this(name, city, openingTimes, screens);
		this.latitude = latitude;
		this.longitude = longitude;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getOpeningTimes() {
		return openingTimes;
	}

	public void setOpeningTimes(String openingTimes) {
		this.openingTimes = openingTimes;
	}


	public Long getId() {
		return idCinema;
	}

	public List<Screen> getScreens() {
		return screens;
	}

	public void setScreens(List<Screen> screens) {
		this.screens = screens;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	
	

}
