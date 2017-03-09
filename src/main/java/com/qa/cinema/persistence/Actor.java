package com.qa.cinema.persistence;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.qa.cinema.persistence.Movie;

/**
 * @author Tary Andrews  
 * @version 0.1.2
 */
@Entity
public class Actor {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idActor;
	private String firstName;
	private String lastName;
	private String gender;
	private String dob;
	
	@ManyToMany(mappedBy="actors")
	private List<Movie> movies; 
	
	
	public Actor(){}
	
	public Actor(String firstName, String lastName, String gender, String dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
	}

	public List<Movie> getMovies(){
		return this.movies;
		}
	
	public List<Movie> setMovies(){
		return movies;
		
	}
	public String getFirstNameActor() {
		return firstName;
	}	
	public void setFirstNameActor(String firstName) {
		this.firstName = firstName;
	}
	public String getLastNameActor() {
		return lastName;
	}
	public void setLastNameActor(String lastName) {
		this.lastName = lastName;
	}
	public String getGenderActor() {
		return gender;
	}
	public void setGenderActor(String gender) {
		this.gender = gender;
	}
	public String getDobActor() {
		return dob;
	}
	public void setDobActor(String dob) {
		this.dob= dob;
	}
	public long getIdActor() {
		return idActor;
	}
	
	
	

}
