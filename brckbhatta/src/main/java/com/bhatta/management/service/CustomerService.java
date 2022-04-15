package com.bhatta.management.service;

import java.util.List;

import com.bhatta.management.entity.Customer;
import com.bhatta.management.exceptions.BrickBhattaException;

public interface CustomerService {

	Customer saveCustomer(Customer customerDetails);

	List<Customer> getAllCustomer();

	Customer editCustomer(Long id, Customer customerDetails) throws BrickBhattaException;

	String deleteCustomer(Long id) throws BrickBhattaException;

	Customer getCustomerById(Long id) throws BrickBhattaException;

}
