package com.bhatta.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.bhatta.management.entity.Login;
import com.bhatta.management.response.Error;
import com.bhatta.management.response.ResponseUtil;
import com.bhatta.management.constant.BrickBhattaConstant;
import com.bhatta.management.service.LoginService;

public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<Object> createUser(@RequestBody Login login){
		try {
			Login superadmin=loginService.save(login);
			return ResponseEntity.ok(com.bhatta.management.response.ResponseUtil.populateResponseObject(superadmin,BrickBhattaConstant.SUCCESS,null));
		} catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, com.bhatta.management.constant.BrickBhattaConstant.FAILURE, new Error("Login", e.getMessage())));
		}
	}
	
	
}
