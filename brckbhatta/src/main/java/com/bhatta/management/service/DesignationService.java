package com.bhatta.management.service;

import java.util.List;

import com.bhatta.management.entity.Designation;
import com.bhatta.management.entity.Employee;
import com.bhatta.management.exceptions.BrickBhattaException;

public interface DesignationService {

	Designation save(Designation designation) throws BrickBhattaException;

	List<Designation> getAll();

	Designation getById(Long id) throws BrickBhattaException;

	String delete(Long id);

	Designation update(Long id, Designation designation) throws BrickBhattaException;

}
