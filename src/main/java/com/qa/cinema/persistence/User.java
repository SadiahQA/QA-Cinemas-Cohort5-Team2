package com.qa.cinema.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Stefan Matykiewicz
 * @version 0.3.0
 */

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	private String firstName;
	private String lastName;
	private String dob;
	private String email;
	private String password;
	private Boolean active;

	public User() {
		//empty constructor
	}

	public User(String firstName, String lastName, String dob, String email, String password, Boolean active) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.password = password;
		this.active = active;
	}

	public Long getIdUser() {
		return idUser;
	}
	
	public String getFirstNameUser() {
		return firstName;
	}

	public void setFirstNameUser(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNameUser() {
		return lastName;
	}

	public void setLastNameUser(String lastName) {
		this.lastName = lastName;
	}

	public String getDobUser() {
		return dob;
	}

	public void setDobUser(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
