package com.bhatta.management.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {
	
	@Id
	private Long id;
	private String email;
	private String password;
	
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
