package com.bhatta.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhatta.management.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
