package com.qa.cinema.persistence;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * @author Tary Andrews  
 * @version 0.1.0
 */
@Entity
public class Actor {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private String gender;
	private String dob;
	
	
	private List<Movie> movies; 
	
	
	public Actor(){}
	
	public Actor(String firstName, String lastName, String gender, String dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
	}


	@ManyToMany(mappedBy="Movie")
	public List<Movie> getMovies(){
		return this.movies;
		}
	
	public List<Movie> setMovies(){
		return movies;
		
	}
	public String getFirstName() {
		return firstName;
	}	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public long getId() {
		return id;
	}
	
	
	

}
