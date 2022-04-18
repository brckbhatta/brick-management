package com.bhatta.management.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhatta.management.entity.Employee;
import com.bhatta.management.entity.Location;
import com.bhatta.management.exceptions.BrickBhattaException;
import com.bhatta.management.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee save(Employee employee) throws BrickBhattaException {
		try {
			return	employeeRepository.save(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> getAll() {
		try {
			return employeeRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee getByEmail(String email) {
		try {
			return employeeRepository.findByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee update(Long id, Employee employee) throws BrickBhattaException {
		try {
			Optional<Employee> existEmployee = employeeRepository.findById(id);
			if(Objects.nonNull(existEmployee.get())) {
				existEmployee.get().setFirstName(employee.getFirstName());
				existEmployee.get().setLastName(employee.getLastName());
				existEmployee.get().setEmail(employee.getEmail());
				existEmployee.get().setAddress(employee.getAddress());
				existEmployee.get().setDesignation(employee.getDesignation());
				existEmployee.get().setLocation(employee.getLocation());
				existEmployee.get().setPhoneNumber(employee.getPhoneNumber());
				return employeeRepository.save(existEmployee.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String delete(Long id) {
		Optional<Employee> employee=employeeRepository.findById(id);
		if(Objects.nonNull(employee.get())) {
			employeeRepository.deleteById(id);
			return "Employee Delete Successfully";
		}else {
			return "Employee Details not found";
		}
		
	}

}
