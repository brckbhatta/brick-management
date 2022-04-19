package com.bhatta.management.controller;

import java.util.List;

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
import com.bhatta.management.entity.Designation;
import com.bhatta.management.entity.Employee;
import com.bhatta.management.exceptions.BrickBhattaException;
import com.bhatta.management.response.Error;
import com.bhatta.management.response.ResponseUtil;
import com.bhatta.management.service.DesignationService;

@RestController
@RequestMapping("/designation")
public class DesignationController {
	
	@Autowired
	private DesignationService designationService;
	
	@PostMapping
	public ResponseEntity<Object> savedetails(@RequestBody Designation designation) throws BrickBhattaException{
		try {
			Designation addDesignation=designationService.save(designation);
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(addDesignation,BrickBhattaConstant.SUCCESS,null));
		} catch(BrickBhattaException ex) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("savedetails()", ex.getMessage())));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("savedetails()", e.getMessage())));
		}
	}
	
	@GetMapping
	public ResponseEntity<Object> getAll(){
		try {
			List<Designation> designationList=designationService.getAll();
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(designationList,BrickBhattaConstant.SUCCESS,null));
		} catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null,BrickBhattaConstant.FAILURE, new Error("getAll()", e.getMessage())));
		}
	}
	
	@GetMapping("/getById")
	public ResponseEntity<Object> getByEmail(@RequestParam Long id) throws BrickBhattaException{
		try {
			Designation designationDetails=designationService.getById(id);
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(designationDetails,BrickBhattaConstant.SUCCESS,null));
		}catch(BrickBhattaException ex) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("getByEmail()", ex.getMessage())));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null,BrickBhattaConstant.FAILURE, new Error("getByEmail()", e.getMessage())));
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateDesignation(@PathVariable Long id,@RequestBody Designation designation) throws BrickBhattaException{
		try {
			Designation designationDetails=designationService.update(id,designation);
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(designationDetails,BrickBhattaConstant.SUCCESS,null));
		}catch(BrickBhattaException ex) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("updateDesignation()", ex.getMessage())));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null,BrickBhattaConstant.FAILURE, new Error("updateDesignation()", e.getMessage())));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteDesignation(@PathVariable Long id){
		try {
			String msg=designationService.delete(id);
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(msg,BrickBhattaConstant.SUCCESS,null));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null,BrickBhattaConstant.FAILURE, new Error("deleteDesignation()", e.getMessage())));
		}
	}

}
