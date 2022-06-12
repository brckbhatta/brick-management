package com.bhatta.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhatta.management.entity.TransactionInfo;

@Repository
public interface TransactionInfoRepository extends JpaRepository<TransactionInfo, Long> {

}
