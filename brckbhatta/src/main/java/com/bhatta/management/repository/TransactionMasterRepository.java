package com.bhatta.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhatta.management.entity.TransactionMaster;

@Repository
public interface TransactionMasterRepository extends JpaRepository<TransactionMaster, Long> {

}
