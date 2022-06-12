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
import org.springframework.web.bind.annotation.RestController;

import com.bhatta.management.constant.BrickBhattaConstant;
import com.bhatta.management.entity.TransactionInfo;
import com.bhatta.management.exceptions.BrickBhattaException;
import com.bhatta.management.response.Error;
import com.bhatta.management.response.ResponseUtil;
import com.bhatta.management.service.TransactionInfoService;

@RestController
@RequestMapping("/transaction-info")
public class TransactionInfoController {

	@Autowired
	private TransactionInfoService transactionInfoService;

	@PostMapping("/")
	public ResponseEntity<Object> createTransaction(@RequestBody TransactionInfo transactionInfo) {
		try {
			TransactionInfo savedTransaction = transactionInfoService.saveTransaction(transactionInfo);
			return ResponseEntity
					.ok(ResponseUtil.populateResponseObject(savedTransaction, BrickBhattaConstant.SUCCESS, null));
		} catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE,
					new Error("createTransaction()", e.getMessage())));
		}
	}

	@GetMapping("/getAll")
	public ResponseEntity<Object> getAllTransaction() {
		try {
			List<TransactionInfo> listTransactionInfo = transactionInfoService.getAll();
			return ResponseEntity
					.ok(ResponseUtil.populateResponseObject(listTransactionInfo, BrickBhattaConstant.SUCCESS, null));
		} catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE,
					new Error("getAllTransaction()", e.getMessage())));
		}
	}

	@PutMapping("/{custId}")
	public ResponseEntity<Object> updateTransaction(@RequestBody TransactionInfo transactionInfo,
			@PathVariable(value = "custId") Long customerId) {
		try {
			TransactionInfo updatedTransaction = transactionInfoService.updateTransactionByCustId(transactionInfo,
					customerId);
			return ResponseEntity
					.ok(ResponseUtil.populateResponseObject(updatedTransaction, BrickBhattaConstant.SUCCESS, null));
		} catch (BrickBhattaException ex) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE,
					new Error("updateTransaction()", ex.getMessage())));
		} catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE,
					new Error("updateTransaction()", e.getMessage())));
		}
	}

	@DeleteMapping("/{custId}")
	public ResponseEntity<Object> deleteTransaction(@PathVariable(value = "custId") Long customerId)
			throws BrickBhattaException {
		try {
			transactionInfoService.deleteTransaction(customerId);
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(
					"Customer Trasaction delete Successfully with id :" + customerId, BrickBhattaConstant.SUCCESS,
					null));
		} catch (BrickBhattaException ex) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE,
					new Error("deleteTransaction()", ex.getMessage())));
		} catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE,
					new Error("deleteTransaction()", e.getMessage())));
		}
	}
	
	@GetMapping("/{custId}")
	public ResponseEntity<Object> getTransaction(@PathVariable(value = "custId") Long customerId) {
		try {
			TransactionInfo transactiondetails = transactionInfoService.getTransactionByCustId(customerId);
			return ResponseEntity
					.ok(ResponseUtil.populateResponseObject(transactiondetails, BrickBhattaConstant.SUCCESS, null));
		} catch (BrickBhattaException ex) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE,
					new Error("getTransaction()", ex.getMessage())));
		} catch (Exception e) {
			return ResponseEntity.ok(ResponseUtil.populateResponseObject(null, BrickBhattaConstant.FAILURE,
					new Error("getTransaction()", e.getMessage())));
		}
	}

}
