package com.alore.assignment.service;

import java.sql.Timestamp;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alore.assignment.dto.UserDetails;
import com.alore.assignment.repo.UserDetailsRepo;

@Service
public class UserDetailService {

	@Autowired
	UserDetailsRepo userDetailsRepo;

	public String storeUserData(UserDetails userDetails) {
		if(userDetailsRepo.existsByName(userDetails.getName())) {
			return "UserName Already exist!";
		}else {
			userDetails.setCreatedAt(Timestamp.from(Instant.now()));
			 userDetailsRepo.save(userDetails);
			 return "User Details Saved Successfully";

		}		
	}

	public UserDetails updateUserDetails(Integer id, String name, String email, String password) {
		UserDetails userDetails = userDetailsRepo.findById(id).get();
		userDetails.setName(name);
		userDetails.setEmail(email);
		userDetails.setPassword(password);
		return userDetailsRepo.save(userDetails);
	}

}
