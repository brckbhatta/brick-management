package com.bhatta.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bhatta.management.entity.LedgerMaster;

@Repository
public interface LedgerMasterRepository extends JpaRepository<LedgerMaster, Long> {

	@Query(value="select * from LedgerMaster l where l.customer_id =:customerId " ,nativeQuery = true)
	LedgerMaster findByCustomerId(Long customerId);

}
