package com.alore.assignment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alore.assignment.dto.HotelDetails;
import com.alore.assignment.dto.UserDetails;
import com.alore.assignment.repo.UserDetailsRepo;
import com.alore.assignment.service.UserDetailService;
import com.alore.assignment.utils.AloreConstants;

@RestController
@RequestMapping("user")
public class UserDetailsController {

	private static final Logger logger = LoggerFactory.getLogger(UserDetailsController.class);

	@Autowired
	UserDetailService userDetailsService;
	
	@Autowired
	UserDetailsRepo userDetailsRepo;

	@PostMapping("/details")
	public ResponseEntity<?> storeUserData(@RequestBody UserDetails userDetails) {
		try {
			logger.info(AloreConstants.Entered + new Object() {
			}.getClass().getEnclosingMethod().getName());

			String userData = userDetailsService.storeUserData(userDetails);

			logger.info(AloreConstants.Exiting + new Object() {
			}.getClass().getEnclosingMethod().getName());
			return new ResponseEntity<String>(userData, HttpStatus.OK);
		} catch (Exception exception) {
			logger.error(AloreConstants.EXCEPTION_IN + new Object() {
			}.getClass().getEnclosingMethod().getName(), exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PatchMapping("/update/user/details/{id}")
	public ResponseEntity<?> updateUserDetails(@PathVariable Integer id, @RequestParam(required = false) String name, @RequestParam(required = false) String email,
			@RequestParam(required = false) String password) {
		try {
			logger.info(AloreConstants.Entered + new Object() {
			}.getClass().getEnclosingMethod().getName());
			
			UserDetails userDetails = userDetailsService.updateUserDetails(id, name, email, password);

			logger.info(AloreConstants.Exiting + new Object() {
			}.getClass().getEnclosingMethod().getName());
			return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
		} catch (Exception exception) {
			logger.error(AloreConstants.EXCEPTION_IN + new Object() {
			}.getClass().getEnclosingMethod().getName(), exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/remove/{id}")
	public String removeHotelDetail(@PathVariable Integer id) {
		try {
			logger.info(AloreConstants.Entered + new Object() {
			}.getClass().getEnclosingMethod().getName());
			userDetailsRepo.deleteById(id);
			logger.info(AloreConstants.Exiting + new Object() {
			}.getClass().getEnclosingMethod().getName());
			return "Deleted User Detail";
		} catch (Exception exception) {
			logger.error(AloreConstants.EXCEPTION_IN + new Object() {
			}.getClass().getEnclosingMethod().getName(), exception);
			return "Failed To Delete";
		}
	}

}
