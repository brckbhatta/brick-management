package com.bhatta.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhatta.management.constant.BrickBhattaConstant;
import com.bhatta.management.entity.Account;
import com.bhatta.management.exceptions.BrickBhattaException;
import com.bhatta.management.response.Error;
import com.bhatta.management.response.ResponseUtil;
import com.bhatta.management.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping
	public ResponseEntity<Object> savedetails(@RequestBody Account accountDetails) throws BrickBhattaException{
		try {
			String savedData=accountService.saveDetails(accountDetails);
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(savedData,BrickBhattaConstant.SUCCESS,null));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("savedetails", e.getMessage())));
		}
	}
	
	@GetMapping
	public ResponseEntity<Object> verifyOtp(@PathVariable String otp) throws BrickBhattaException{
		try {
			Boolean verify=accountService.verifyOtp(otp);
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(verify,BrickBhattaConstant.SUCCESS,null));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("savedetails", e.getMessage())));
		}
	}
}
