package com.bhatta.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhatta.management.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

	Login save(Login login);

}
