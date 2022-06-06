package com.bhatta.management.service;

import java.util.List;

import com.bhatta.management.entity.LedgerMaster;

public interface LedgerMasterService {

	List<LedgerMaster> getAll();

	LedgerMaster saveLedgerData(LedgerMaster ledgerMasterDetails);

	LedgerMaster getByCustomerId(Long customerId);

}
