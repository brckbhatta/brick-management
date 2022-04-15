package com.bhatta.management.service;

import java.util.List;
import java.util.Optional;

import com.bhatta.management.entity.BrickDetails;
import com.bhatta.management.exceptions.BrickBhattaException;

public interface BrickDetailsService {

	List<BrickDetails> getAllDetails();

	Optional<BrickDetails> getByAccId(Long accountId);

	BrickDetails addBrickDetails(BrickDetails brickDetails);

	BrickDetails editBrickDetails(Long id, BrickDetails brickDetails);

	String deleteBrickDetails(Long id) throws BrickBhattaException;

}
