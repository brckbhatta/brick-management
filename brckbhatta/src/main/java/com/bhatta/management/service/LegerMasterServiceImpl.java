package com.bhatta.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhatta.management.entity.LedgerMaster;
import com.bhatta.management.repository.LedgerMasterRepository;

@Service
public class LegerMasterServiceImpl implements LedgerMasterService{
	
	@Autowired
	private LedgerMasterRepository ledgerMasterRepo;

	@Override
	public List<LedgerMaster> getAll() {
		
		return ledgerMasterRepo.findAll() ;
	}

	@Override
	public LedgerMaster saveLedgerData(LedgerMaster ledgerMasterDetails) {
		return ledgerMasterRepo.save(ledgerMasterDetails);
		
	}

	@Override
	public LedgerMaster getByCustomerId(Long customerId) {
		LedgerMaster ledgerMasterData = ledgerMasterRepo.findByCustomerId(customerId);
		return ledgerMasterData;
	}
	
	

}
