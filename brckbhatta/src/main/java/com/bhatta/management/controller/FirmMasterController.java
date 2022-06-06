package com.bhatta.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhatta.management.constant.BrickBhattaConstant;
import com.bhatta.management.entity.Customer;
import com.bhatta.management.entity.FirmMaster;
import com.bhatta.management.exceptions.BrickBhattaException;
import com.bhatta.management.response.Error;
import com.bhatta.management.response.ResponseUtil;
import com.bhatta.management.service.FirmMasterService;

@RestController
@RequestMapping("/firmMaster")
public class FirmMasterController {
	
	@Autowired
	private FirmMasterService firmMasterService;
	
	@PostMapping
	public ResponseEntity<Object> savedetails(@RequestBody FirmMaster firmMaster) throws BrickBhattaException{
		try {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(
					firmMasterService.saveFirmDetails(firmMaster),BrickBhattaConstant.SUCCESS,null));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("savedetails", e.getMessage())));
		}
	}
	

	@GetMapping
	public ResponseEntity<Object> getAllCustomer() throws BrickBhattaException{
		try {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(
					firmMasterService.getAll(),BrickBhattaConstant.SUCCESS,null));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("getAllCustomer()", e.getMessage())));
		}
	}

}
