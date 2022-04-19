package com.bhatta.management.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhatta.management.entity.Designation;
import com.bhatta.management.entity.Employee;
import com.bhatta.management.exceptions.BrickBhattaException;
import com.bhatta.management.repository.DesignationRepository;

@Service
public class DesignationServiceImpl implements DesignationService{
	
	@Autowired
	private DesignationRepository designationRepository;
	
	@Override
	public Designation save(Designation designation) throws BrickBhattaException {
		try {
			return designationRepository.save(designation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Designation> getAll() {
		try {
			return designationRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Designation getById(Long id) {
		try {
			Optional<Designation> designation=designationRepository.findById(id);
			if(Objects.nonNull(designation)) {
				return designation.get();
			}else {
				throw new BrickBhattaException("Designation not exist"+id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String delete(Long id) {
		try {
			Optional<Designation> designation= designationRepository.findById(id);
			if(Objects.nonNull(designation)) {
				designationRepository.deleteById(id);
				return "Designation Delete Successfully";
			}else {
				return "Designation not exist"+id;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Designation update(Long id, Designation designation) throws BrickBhattaException {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
