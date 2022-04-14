package com.bhatta.management.service;

import java.util.List;

import com.bhatta.management.entity.SuperAdmin;
import com.bhatta.management.exceptions.BrickBhattaException;

public interface SuperAdminService {

	SuperAdmin save(SuperAdmin superAdmin) throws BrickBhattaException;

	List<SuperAdmin> getAll();

	SuperAdmin getByEmail(String email);

	SuperAdmin update(Long id, SuperAdmin superAdminDetails) throws BrickBhattaException;

	String delete(Long id);

}
