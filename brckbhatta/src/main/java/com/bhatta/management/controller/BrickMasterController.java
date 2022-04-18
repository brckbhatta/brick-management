package com.bhatta.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhatta.management.constant.BrickBhattaConstant;
import com.bhatta.management.entity.BrickMaster;
import com.bhatta.management.exceptions.BrickBhattaException;
import com.bhatta.management.response.Error;
import com.bhatta.management.response.ResponseUtil;
import com.bhatta.management.service.BrickMasterService;

@RestController
@RequestMapping("/brickMaster")
public class BrickMasterController {
	
	@Autowired
	private BrickMasterService brickMasterService;
	
	@GetMapping
	public ResponseEntity<Object> getAll() throws BrickBhattaException{
		try {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(
					brickMasterService.getAllDetails(),BrickBhattaConstant.SUCCESS,null));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("getAll()", e.getMessage())));
		}
	}
	
	@GetMapping("/getByAccId")
	public ResponseEntity<Object> getByAccountId(@RequestParam(name="accountId") Long accountId) throws BrickBhattaException{
		try {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(
					brickMasterService.getByAccId(accountId),BrickBhattaConstant.SUCCESS,null));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("getByAccountId()", e.getMessage())));
		}
	}
	
	@PostMapping
	public ResponseEntity<Object> saveDetails(@RequestBody BrickMaster brickMasterDetails) throws BrickBhattaException{
		try {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(
					brickMasterService.addBrickDetails(brickMasterDetails),BrickBhattaConstant.SUCCESS,null));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("saveDetails()", e.getMessage())));
		}
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> editBrickDetails(@PathVariable(name="id") Long id,@RequestBody BrickMaster brickMasterDetails) throws BrickBhattaException{
		try {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(
					brickMasterService.editBrickDetails(id,brickMasterDetails),BrickBhattaConstant.SUCCESS,null));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("editBrickDetails()", e.getMessage())));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteBrickDetails(@PathVariable(name="id") Long id) throws BrickBhattaException{
		try {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(
					brickMasterService.deleteBrickDetails(id),BrickBhattaConstant.SUCCESS,null));
		} catch(BrickBhattaException ex) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("deleteBrickDetails()", ex.getMessage())));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("deleteBrickDetails()", e.getMessage())));
		}
	}
}
