package com.bhatta.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhatta.management.constant.BrickBhattaConstant;
import com.bhatta.management.entity.LedgerMaster;
import com.bhatta.management.exceptions.BrickBhattaException;
import com.bhatta.management.response.Error;
import com.bhatta.management.response.ResponseUtil;
import com.bhatta.management.service.LedgerMasterService;

@RestController
@RequestMapping("/ledger")
public class LedgerMasterController {
	
	@Autowired
	private LedgerMasterService ledgerMasterService;
	
	@GetMapping
	public ResponseEntity<Object> getAllLedger() throws BrickBhattaException{
		try {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(
					ledgerMasterService.getAll(),BrickBhattaConstant.SUCCESS,null));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("getAllCustomer()", e.getMessage())));
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> saveLedgerMaster(@RequestBody LedgerMaster ledgerMasterDetails) throws BrickBhattaException{
		try {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(
					ledgerMasterService.saveLedgerData(ledgerMasterDetails),BrickBhattaConstant.SUCCESS,null));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("getAllCustomer()", e.getMessage())));
		}
	}

	@GetMapping(value="/getByCustomerId")
	public ResponseEntity<Object> getByCustomerId(@RequestParam(value="customerId") Long customerId) throws BrickBhattaException{
		try {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(
					ledgerMasterService.getByCustomerId(customerId),BrickBhattaConstant.SUCCESS,null));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("getAllCustomer()", e.getMessage())));
		}
	}

}
