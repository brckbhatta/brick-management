package com.bhatta.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhatta.management.entity.SuperAdmin;
import com.bhatta.management.exceptions.BrickBhattaException;
import com.bhatta.management.repository.SuperAdminRepository;

@Service
public class SuperAdminServiceImpl implements SuperAdminService{

	@Autowired
	private SuperAdminRepository superAdminRepository;
	
	@Override
	public SuperAdmin save(SuperAdmin superAdmin) throws BrickBhattaException {
		try {
			return	superAdminRepository.save(superAdmin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<SuperAdmin> getAll() {
		try {
			return superAdminRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SuperAdmin getByEmail(String email) {
		try {
			return superAdminRepository.findByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public SuperAdmin update(Long id, SuperAdmin superAdmin) throws BrickBhattaException {
		try {
			Optional<SuperAdmin> existAdmin = superAdminRepository.findById(id);
			if (existAdmin.isPresent()) {
				existAdmin.get().setFirstName(superAdmin.getFirstName());
				existAdmin.get().setLastName(superAdmin.getLastName());
				existAdmin.get().setEmail(superAdmin.getEmail());
				existAdmin.get().setPassword(superAdmin.getPassword());
				existAdmin.get().setPhoneNo(superAdmin.getPhoneNo());
				return superAdminRepository.save(existAdmin.get());

			} else {
				throw new BrickBhattaException("SuperAdmin details not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String delete(Long id) {
		try {
			Optional<SuperAdmin> existAdmin = superAdminRepository.findById(id);
			if(existAdmin.isPresent()) {
				superAdminRepository.deleteById(id);
				return "SuperAdmin Delete successfully";
			}else {
				return "SuperAdmin not exist with this id "+ id;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
