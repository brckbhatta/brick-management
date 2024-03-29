package com.bhatta.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhatta.management.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

	Login save(Login login);

}
