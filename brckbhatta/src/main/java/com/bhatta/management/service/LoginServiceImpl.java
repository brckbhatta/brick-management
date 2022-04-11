package com.bhatta.management.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bhatta.management.entity.Login;
import com.bhatta.management.repository.LoginRepository;

public class LoginServiceImpl {
	@Autowired
	private LoginRepository loginRepository;
	
	public Login save(Login login) {
		return loginRepository.save(login);
	}
}
