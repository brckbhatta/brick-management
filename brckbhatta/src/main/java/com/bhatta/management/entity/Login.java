package com.bhatta.management.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Login {
	
	@Id
	private Long id;
	private String email;
	private String password;
	
	
}
