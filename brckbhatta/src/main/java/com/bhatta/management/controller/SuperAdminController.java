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
import com.bhatta.management.entity.SuperAdmin;
import com.bhatta.management.exceptions.BrickBhattaException;
import com.bhatta.management.response.Error;
import com.bhatta.management.response.ResponseUtil;
import com.bhatta.management.service.SuperAdminService;

@RestController
@RequestMapping("/superAdmin")
public class SuperAdminController {
	
	@Autowired
	private SuperAdminService adminService;
  
	@PostMapping
	public ResponseEntity<Object> savedetails(@RequestBody SuperAdmin superAdmin) throws BrickBhattaException{
		try {
			SuperAdmin superadmin=adminService.save(superAdmin);
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(superadmin,BrickBhattaConstant.SUCCESS,null));
		} catch(BrickBhattaException ex) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("savedetails", ex.getMessage())));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("savedetails", e.getMessage())));
		}
	}
	
	@GetMapping
	public ResponseEntity<Object> getAll(){
		try {
			List<SuperAdmin> superadminList=adminService.getAll();
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(superadminList,BrickBhattaConstant.SUCCESS,null));
		} catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null,BrickBhattaConstant.FAILURE, new Error("getAll", e.getMessage())));
		}
	}
	
	@GetMapping("/getByEmail")
	public ResponseEntity<Object> getByEmail(@RequestParam String email){
		try {
			SuperAdmin superadmin=adminService.getByEmail(email);
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(superadmin,BrickBhattaConstant.SUCCESS,null));
		} catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null,BrickBhattaConstant.FAILURE, new Error("getByEmail", e.getMessage())));
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable Long id,@RequestBody SuperAdmin superAdminDetails) throws BrickBhattaException{
		try {
			SuperAdmin superadmin=adminService.update(id,superAdminDetails);
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(superadmin,BrickBhattaConstant.SUCCESS,null));
		}catch(BrickBhattaException ex) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE, new Error("update", ex.getMessage())));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null,BrickBhattaConstant.FAILURE, new Error("update", e.getMessage())));
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable Long id){
		try {
			String msg=adminService.delete(id);
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(msg,BrickBhattaConstant.SUCCESS,null));
		}catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null,BrickBhattaConstant.FAILURE, new Error("delete", e.getMessage())));
		}
	}
}
