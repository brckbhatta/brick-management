package com.bhatta.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhatta.management.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
