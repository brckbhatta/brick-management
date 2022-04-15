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
import org.springframework.web.bind.annotation.RestController;

import com.bhatta.management.constant.BrickBhattaConstant;
import com.bhatta.management.entity.Customer;
import com.bhatta.management.exceptions.BrickBhattaException;
import com.bhatta.management.response.Error;
import com.bhatta.management.response.ResponseUtil;
import com.bhatta.management.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<Object> savedetails(@RequestBody Customer customerDetails) throws BrickBhattaException{
		try {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(
					customerService.saveCustomer(customerDetails),BrickBhattaConstant.SUCCESS,null));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("savedetails", e.getMessage())));
		}
	}
	

	@GetMapping
	public ResponseEntity<Object> getAllCustomer() throws BrickBhattaException{
		try {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(
					customerService.getAllCustomer(),BrickBhattaConstant.SUCCESS,null));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("getAllCustomer", e.getMessage())));
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getById(@PathVariable(value="id") Long id) throws BrickBhattaException{
		try {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(
					customerService.getCustomerById(id),BrickBhattaConstant.SUCCESS,null));
		} catch(BrickBhattaException ex) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("savedetails", ex.getMessage())));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("savedetails", e.getMessage())));
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> editCustomer(@PathVariable(value="id") Long id,
			@RequestBody Customer customerDetails) throws BrickBhattaException{
		try {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(
					customerService.editCustomer(id,customerDetails),BrickBhattaConstant.SUCCESS,null));
		} catch(BrickBhattaException ex) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("savedetails", ex.getMessage())));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("savedetails", e.getMessage())));
		}
	}
	


	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable(value="id") Long id) throws BrickBhattaException{
		try {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(
					customerService.deleteCustomer(id),BrickBhattaConstant.SUCCESS,null));
		} catch(BrickBhattaException ex) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("savedetails", ex.getMessage())));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("savedetails", e.getMessage())));
		}
	}
	
}
