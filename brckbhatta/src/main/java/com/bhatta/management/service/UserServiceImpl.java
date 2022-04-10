package com.bhatta.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhatta.management.dao.UserRepository;
import com.bhatta.management.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

}
