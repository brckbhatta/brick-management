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
		try {
			return customerRepository.save(customerDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> getAllCustomer() {
		try {
			return customerRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer editCustomer(Long id, Customer customerDetails) throws BrickBhattaException {
		try {
			Optional<Customer> existingCustomer=customerRepository.findById(id);
			if (existingCustomer.isPresent()) {
				Customer customer = existingCustomer.get();
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteCustomer(Long id) throws BrickBhattaException {
		try {
			Optional<Customer> existingCustomer = customerRepository.findById(id);
			if (existingCustomer.isPresent()) {
				customerRepository.deleteById(id);
				return "Customer Delete Successfully";
			} else {
				throw new BrickBhattaException("Customer Not Exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer getCustomerById(Long id) throws BrickBhattaException {
		try {
			Optional<Customer> existingCustomer = customerRepository.findById(id);
			if (existingCustomer.isPresent()) {
				return existingCustomer.get();
			} else {
				throw new BrickBhattaException("Customer Not Exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
