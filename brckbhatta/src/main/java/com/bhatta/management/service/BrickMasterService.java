package com.bhatta.management.service;

import java.util.List;

import com.bhatta.management.entity.BrickMaster;
import com.bhatta.management.exceptions.BrickBhattaException;


public interface BrickMasterService {

	List<BrickMaster> getAllDetails();

	BrickMaster getByAccId(Long accountId);

	BrickMaster addBrickDetails(BrickMaster brickMasterDetails);

	BrickMaster editBrickDetails(Long id, BrickMaster brickMasterDetails) throws BrickBhattaException;

	String deleteBrickDetails(Long id) throws BrickBhattaException;

}
