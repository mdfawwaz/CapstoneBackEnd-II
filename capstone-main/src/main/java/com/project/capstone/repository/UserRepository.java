package com.project.capstone.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.capstone.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	 public Optional<User> findByName(String username);
	 public boolean existsByName(String name);


}
