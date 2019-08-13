package com.alore.assignment.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alore.assignment.dto.UserDetails;

@Repository
public interface UserDetailsRepo extends CrudRepository<UserDetails, Integer> {
	
	boolean existsByName(String name);

}
