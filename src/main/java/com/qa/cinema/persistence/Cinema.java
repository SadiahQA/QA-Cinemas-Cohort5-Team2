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
	private Long id;
	
	private String name;
	
	private String city;
	

	private String openingTimes;

	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "Cinema_idCinema")
	private List<Screen> screens;
	
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
		return id;
	}

	public List<Screen> getScreens() {
		return screens;
	}

	public void setScreens(List<Screen> screens) {
		this.screens = screens;
	}

	
	

}
