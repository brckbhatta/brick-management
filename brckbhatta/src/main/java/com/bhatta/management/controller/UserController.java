package com.bhatta.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhatta.management.entity.User;
import com.bhatta.management.service.UserService;

@RestController
@RequestMapping("/user-management")
public class UserController {
	

	@Autowired
	UserService userServiceImpl;
	
	@GetMapping
	public ResponseEntity<Object> getAllUser()
	{
		try {
			List<User> userList = userServiceImpl.getAll();
			return ResponseEntity.ok(userList);
		}catch(Exception ex) {
			return ResponseEntity.ok("Error Occured in getting user list");
		}
	}
	
}
