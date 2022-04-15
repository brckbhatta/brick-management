package com.bhatta.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhatta.management.entity.BrickMaster;
import com.bhatta.management.exceptions.BrickBhattaException;
import com.bhatta.management.repository.BrickMasterRepository;

@Service
public class BrickMasterServiceImpl implements BrickMasterService {
	
	@Autowired
	private BrickMasterRepository brickMasterRepository;
	
	@Override
	public List<BrickMaster> getAllDetails() {
		return brickMasterRepository.findAll();
	}

	@Override
	public BrickMaster getByAccId(Long accountId) {
		return brickMasterRepository.findByAccountId(accountId);
	}

	@Override
	public BrickMaster addBrickDetails(BrickMaster brickMasterDetails) {
		return brickMasterRepository.save(brickMasterDetails);
	}

	@Override
	public BrickMaster editBrickDetails(Long id, BrickMaster brickMasterDetails) throws BrickBhattaException{
		Optional<BrickMaster> existingBrickMaster=brickMasterRepository.findById(id);
		if(existingBrickMaster.isPresent()) {
			existingBrickMaster.get().setBrickName(brickMasterDetails.getBrickName());
			existingBrickMaster.get().setBrickType(brickMasterDetails.getBrickType());
			return brickMasterRepository.save(existingBrickMaster.get());		
		}else {
			throw new BrickBhattaException("Brick Details Not Found");
		}
	}

	@Override
	public String deleteBrickDetails(Long id) throws BrickBhattaException{
		if(brickMasterRepository.findById(id).isPresent()) {
			brickMasterRepository.deleteById(id);
			return "Delete Successfully";
		}else {
			throw new BrickBhattaException("Brick Details Not Found");
		}
	}

}
