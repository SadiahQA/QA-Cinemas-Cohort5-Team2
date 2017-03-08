package com.qa.cinema.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Stefan Matykiewicz
 * @version 0.2.1
 */

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String dob;
	private String email;
	private String password;

	public User() {
	}

	public User(String firstName, String lastName, String dob, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.password = password;
	}

	public Long getIdUser() {
		return id;
	}
	
	public String getFirstNameUser() {
		return firstName;
	}

	public void setFirstNameUser(String firstNameUser) {
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

}
