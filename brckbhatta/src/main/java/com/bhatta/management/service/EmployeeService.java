package com.bhatta.management.service;

import java.util.List;

import com.bhatta.management.entity.Employee;
import com.bhatta.management.exceptions.BrickBhattaException;

public interface EmployeeService {

	Employee save(Employee employee) throws BrickBhattaException;

	List<Employee> getAll();

	Employee getByEmail(String email);

	Employee update(Long id, Employee employee) throws BrickBhattaException;

	String delete(Long id);

}
