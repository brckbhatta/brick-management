package com.bhatta.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhatta.management.entity.Location;
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

	//Location findByEmail(String email);

}
