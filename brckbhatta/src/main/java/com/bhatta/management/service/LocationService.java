package com.bhatta.management.service;

import java.util.List;

import com.bhatta.management.entity.Location;
import com.bhatta.management.exceptions.BrickBhattaException;

public interface LocationService {

	Location save(Location location)throws BrickBhattaException;

	List<Location> getAll();

	Location getByEmail(String email);

	Location update(Long id, Location location)throws BrickBhattaException;

	String delete(Long id);

}
