package com.bhatta.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhatta.management.entity.TransactionInfo;
import com.bhatta.management.exceptions.BrickBhattaException;
import com.bhatta.management.repository.TransactionInfoRepository;

@Service
public class TransactionInfoServiceImpl implements TransactionInfoService {
	
	@Autowired
	private TransactionInfoRepository transactionInfoRepository;
	
	@Override
	public TransactionInfo saveTransaction(TransactionInfo transactionInfo) {
		try {
			transactionInfoRepository.save(transactionInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TransactionInfo> getAll() {
		try {
			List<TransactionInfo> listTransactionInfo=transactionInfoRepository.findAll();
			return listTransactionInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public TransactionInfo updateTransactionByCustId(TransactionInfo transactionInfo, Long customerId) throws BrickBhattaException{
		try {
			Optional<TransactionInfo> existedTransaction=transactionInfoRepository.findById(customerId);
			if(existedTransaction.isPresent()) {
				TransactionInfo transaction=existedTransaction.get();
				transaction.setCustomer(transactionInfo.getCustomer());
				transaction.setTransactionInfo(transactionInfo.getTransactionInfo());
				return transactionInfoRepository.save(transaction);
			}else {
				throw new BrickBhattaException("Transaction not found with this id :"+customerId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteTransaction(Long customerId) throws BrickBhattaException {
		try {
			Optional<TransactionInfo> existedTransaction=transactionInfoRepository.findById(customerId);
			if(existedTransaction.isPresent()) {
				transactionInfoRepository.deleteById(customerId);
				return "Transaction delete successfully with id :"+customerId;
			}else {
				throw new BrickBhattaException("Transaction not found with this id :"+customerId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  null;
	}

	@Override
	public TransactionInfo getTransactionByCustId(Long customerId) throws BrickBhattaException {
		try {
			Optional<TransactionInfo> transactionDetails=transactionInfoRepository.findById(customerId);
			if(transactionDetails.isPresent()) {
				return transactionDetails.get();
			}else {
				throw new BrickBhattaException("Transaction not found with this id :"+customerId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
