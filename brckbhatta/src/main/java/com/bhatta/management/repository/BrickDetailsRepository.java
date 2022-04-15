package com.bhatta.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhatta.management.entity.BrickDetails;

@Repository
public interface BrickDetailsRepository extends JpaRepository<BrickDetails, Long>{

}
