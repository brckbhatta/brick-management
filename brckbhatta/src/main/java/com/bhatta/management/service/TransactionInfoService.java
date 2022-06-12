package com.bhatta.management.service;

import java.util.List;

import com.bhatta.management.entity.TransactionInfo;
import com.bhatta.management.exceptions.BrickBhattaException;

public interface TransactionInfoService {

	TransactionInfo saveTransaction(TransactionInfo transactionInfo) throws BrickBhattaException;

	List<TransactionInfo> getAll();

	TransactionInfo updateTransactionByCustId(TransactionInfo transactionInfo, Long customerId) throws BrickBhattaException;
	
	String deleteTransaction(Long customerId) throws BrickBhattaException;

	TransactionInfo getTransactionByCustId(Long customerId) throws BrickBhattaException;

}
