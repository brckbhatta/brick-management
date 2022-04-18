package com.bhatta.management.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhatta.management.entity.Location;
import com.bhatta.management.exceptions.BrickBhattaException;
import com.bhatta.management.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService{
	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public Location save(Location location) throws BrickBhattaException {
		try {
			return locationRepository.save(location);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Location> getAll() {
		try {
			return locationRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Location getByEmail(String email) {
		try {
			return locationRepository.findbyEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Location update(Long id, Location location) throws BrickBhattaException {
		try {
			Optional<Location> existLocation = locationRepository.findById(id);
			if(Objects.nonNull(existLocation.get())) {
				existLocation.get().setCity(location.getCity());
				existLocation.get().setCountry(location.getCountry());
				existLocation.get().setLocationAddress(location.getLocationAddress());
				existLocation.get().setLocationName(location.getLocationName());
				existLocation.get().setPincode(location.getPincode());
				existLocation.get().setState(location.getState());
				return locationRepository.save(existLocation.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String delete(Long id) {
		try {
			Optional<Location> existLocation = locationRepository.findById(id);
			if(Objects.nonNull(existLocation.get())) {
				locationRepository.deleteById(id);
				return "Location delete successfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
