package com.bhatta.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhatta.management.controller.AccountController;
import com.bhatta.management.entity.Account;
import com.bhatta.management.entity.FirmMaster;
import com.bhatta.management.repository.FirmMasterRepository;

@Service
public class FirmMasterServiceImpl implements FirmMasterService {
	
	@Autowired
	private FirmMasterRepository firmMasterRepository;

	@Override
	public FirmMaster saveFirmDetails(FirmMaster firmMaster) {
		Long accountId=firmMaster.getAccount().getAccountId();
//		Account acc=new Account();
//		acc.setAccountId(1L);
		//firmMaster.setAccount(acc);
		return firmMasterRepository.save(firmMaster);
	}

	@Override
	public List<FirmMaster> getAll() {
		return firmMasterRepository.findAll();
	}

}
