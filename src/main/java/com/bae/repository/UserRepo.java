package com.bae.repository;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bae.entity.User;

@Repository
public interface UserRepo extends JpaRepository <User, Long>{

	
}
