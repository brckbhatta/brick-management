package com.bhatta.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhatta.management.entity.BrickMaster;

public interface BrickMasterRepository extends JpaRepository<BrickMaster, Long>{

	BrickMaster findByAccountId(Long accountId);

}
