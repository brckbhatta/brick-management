package com.bhatta.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhatta.management.entity.Customer;
import com.bhatta.management.exceptions.BrickBhattaException;
import com.bhatta.management.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customerDetails) {
		return customerRepository.save(customerDetails);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public Customer editCustomer(Long id, Customer customerDetails) throws BrickBhattaException {
		
		Optional<Customer> existingCustomer=customerRepository.findById(id);
		if (existingCustomer.isPresent()) {
			Customer customer = existingCustomer.get();
			customer.setCustomerId(customerDetails.getCustomerId());
			customer.setFirstName(customerDetails.getFirstName());
			customer.setLastName(customerDetails.getLastName());
			customer.setEmail(customerDetails.getEmail());
			customer.setAddress(customerDetails.getAddress());
			customer.setPhoneNumber(customerDetails.getPhoneNumber());
			customer.setActive(customerDetails.getActive());
			return customerRepository.save(customer);
		}else {
			throw new BrickBhattaException("Customer Not Exist");
		}
	}

	@Override
	public String deleteCustomer(Long id) throws BrickBhattaException {
		Optional<Customer> existingCustomer=customerRepository.findById(id);
		if (existingCustomer.isPresent()) {
			 customerRepository.deleteById(id);
			 return "Customer Delete Successfully";
		}else {
			throw new BrickBhattaException("Customer Not Exist");
		}
	}

	@Override
	public Customer getCustomerById(Long id) throws BrickBhattaException {
		Optional<Customer> existingCustomer=customerRepository.findById(id);
		if (existingCustomer.isPresent()) {
			return  existingCustomer.get();
		}else {
			throw new BrickBhattaException("Customer Not Exist");
		}
	}

}
