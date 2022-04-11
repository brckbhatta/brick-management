package com.bhatta.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhatta.management.entity.SuperAdmin;

public interface SuperAdminRepository extends JpaRepository<SuperAdmin, Long> {

}
