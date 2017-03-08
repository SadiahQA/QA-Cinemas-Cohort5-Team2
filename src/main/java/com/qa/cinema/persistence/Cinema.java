package com.qa.cinema.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.executable.ValidateOnExecution;

/*
 * Author: Alistair Fenn
 * Version: 0.0.1
 */

@Entity
public class Cinema {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idCinema")
	private Long id;
	
	private String name;
	
	private String city;
	
	private String openingtimes;
	
	@OneToMany
	@JoinColumn(name = "idScreen")
	private List<Screen> screens;
	
	public Cinema(){}
	
	public Cinema(String name, String city, String openingtimes, List<Screen> screens) {
		super();
		this.name = name;
		this.city = city;
		this.openingtimes = openingtimes;
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

	public String getOpeningtimes() {
		return openingtimes;
	}

	public void setOpeningtimes(String openingtimes) {
		this.openingtimes = openingtimes;
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
