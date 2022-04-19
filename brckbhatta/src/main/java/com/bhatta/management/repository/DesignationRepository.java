package com.bhatta.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhatta.management.entity.Designation;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Long>{

}
