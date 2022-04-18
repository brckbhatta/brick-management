package com.bhatta.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhatta.management.entity.BrickDetails;
import com.bhatta.management.exceptions.BrickBhattaException;
import com.bhatta.management.repository.BrickDetailsRepository;

@Service
public class BrickDetailsServiceImpl implements BrickDetailsService {
	
	@Autowired
	private BrickDetailsRepository brickDetailsRepository;
	
	@Override
	public List<BrickDetails> getAllDetails() {
		try {
			return brickDetailsRepository.findAll();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public Optional<BrickDetails> getByAccId(Long accountId) {
		try {
			return brickDetailsRepository.findById(accountId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BrickDetails addBrickDetails(BrickDetails brickDetails) {
		try {
			return brickDetailsRepository.save(brickDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BrickDetails editBrickDetails(Long id, BrickDetails brickDetails) {
		try {
			Optional<BrickDetails> brickdata = brickDetailsRepository.findById(id);
			if (brickdata.isPresent()) {
				brickdata.get().setBrickQuantity(brickDetails.getBrickQuantity());
				brickdata.get().setBrickPrice(brickDetails.getBrickPrice());
				brickdata.get().setBrickMaster(brickDetails.getBrickMaster());
				brickDetailsRepository.save(brickdata.get());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	@Override
	public String deleteBrickDetails(Long id) throws BrickBhattaException {
		try{
			Optional<BrickDetails> brickdata = brickDetailsRepository.findById(id);
			if (brickdata.isPresent()) {
				brickDetailsRepository.delete(brickdata.get());
				return "Brick Details Delete Successfully";
			} else {
				return "Brick Details not found";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
