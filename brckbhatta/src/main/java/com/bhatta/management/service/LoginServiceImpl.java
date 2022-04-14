package com.bhatta.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhatta.management.entity.Login;
import com.bhatta.management.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService{ 
	@Autowired
	private LoginRepository loginRepository;
	
	public Login save(Login login) {
		return loginRepository.save(login);
	}
}
