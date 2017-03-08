/**
 * @author Stefan Matykiewicz
 * @version 0.2.0
 */

package com.qa.cinema.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUser;
	private String firstNameUser;
	private String lastNameUser;
	private String dobUser;
	private String email;
	private String password;

	public User() {
	}

	public User(String firstNameUser, String lastNameUser, String dobUser, String email, String password) {
		this.firstNameUser = firstNameUser;
		this.lastNameUser = lastNameUser;
		this.dobUser = dobUser;
		this.email = email;
		this.password = password;
	}

	public Long getIdUser() {
		return idUser;
	}
	
	public String getFirstNameUser() {
		return firstNameUser;
	}

	public void setFirstNameUser(String firstNameUser) {
		this.firstNameUser = firstNameUser;
	}

	public String getLastNameUser() {
		return lastNameUser;
	}

	public void setLastNameUser(String lastNameUser) {
		this.lastNameUser = lastNameUser;
	}

	public String getDobUser() {
		return dobUser;
	}

	public void setDobUser(String dobUser) {
		this.dobUser = dobUser;
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
