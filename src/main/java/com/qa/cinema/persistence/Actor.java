package com.qa.cinema.persistence;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * 
 * @author Tary Andrews  
 * @version 0.1.1
 * 
 */

@Entity
public class Actor {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idActor;
	private String firstNameActor;
	private String lastNameActor;
	private String genderActor;
	private String dobActor;
	
	
	private List<Movie> movies; 
	
	
	public Actor(){}
	
	public Actor(String firstNameActor, String lastNameActor, String genderActor, String dobActor) {
		super();
		this.firstNameActor = firstNameActor;
		this.lastNameActor = lastNameActor;
		this.genderActor = genderActor;
		this.dobActor = dobActor;
	}


	@ManyToMany(mappedBy="Movie")
	public List<Movie> getMovies(){
		return this.movies;
		}
	
	public List<Movie> setMovies(){
		return movies;
		
	}
	public String getFirstNameActor() {
		return firstNameActor;
	}	
	public void setFirstNameActor(String firstName) {
		this.firstNameActor = firstName;
	}
	public String getLastNameActor() {
		return lastNameActor;
	}
	public void setLastNameActor(String lastName) {
		this.lastNameActor = lastName;
	}
	public String getGenderActor() {
		return genderActor;
	}
	public void setGenderActor(String gender) {
		this.genderActor = gender;
	}
	public String getDobActor() {
		return dobActor;
	}
	public void setDobActor(String dob) {
		this.dobActor = dob;
	}
	public long getIdActor() {
		return idActor;
	}
	
	
	

}
