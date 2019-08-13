package com.alore.assignment.controller;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alore.assignment.dto.HotelDetails;
import com.alore.assignment.repo.HotelDetailsRepo;
import com.alore.assignment.service.HotelDetailsService;
import com.alore.assignment.utils.AloreConstants;

@RestController
@RequestMapping("alore")
public class HotelDetailsController {
	
	private static final Logger logger = LoggerFactory.getLogger(HotelDetailsController.class);

	@Autowired
	HotelDetailsService hotelDetailsService;
	
	@Autowired
	HotelDetailsRepo hotelDetailsRepo;
	
	@PostMapping("/hotel/details")
	public ResponseEntity<?> updateHotelDetails( @RequestBody HotelDetails hotelDetails) {
		try {
			logger.info(AloreConstants.Entered + new Object() {
			}.getClass().getEnclosingMethod().getName());

			HotelDetails hotelDtl = hotelDetailsService.storeHotelDetails( hotelDetails);

			logger.info(AloreConstants.Exiting + new Object() {
			}.getClass().getEnclosingMethod().getName());
			return new ResponseEntity<HotelDetails>(hotelDtl, HttpStatus.OK);
		} catch (Exception exception) {
			logger.error(AloreConstants.EXCEPTION_IN + new Object() {
			}.getClass().getEnclosingMethod().getName(), exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PatchMapping("/update/hotel/details/{id}")
	public ResponseEntity<?> updateHotelDetail11(@PathVariable Integer id, @RequestParam(required = true) String hotelName,
			@RequestParam(required = false) String city, @RequestParam(required = false) Date date,
			 @RequestParam(required = false) Integer numberOfRooms,  @RequestParam(required = false) Boolean ac,  @RequestParam(required = false) Boolean meals,
			 @RequestParam(required = false) Boolean wifi, @RequestParam(required = false) Boolean roomsAvailability) {
		try {
			logger.info(AloreConstants.Entered + new Object() {
			}.getClass().getEnclosingMethod().getName());
			
			HotelDetails hotelDtlq = hotelDetailsService.updateHotelDetail(id, hotelName, city, date, numberOfRooms, ac, meals, wifi, roomsAvailability);

			logger.info(AloreConstants.Exiting + new Object() {
			}.getClass().getEnclosingMethod().getName());
			return new ResponseEntity<HotelDetails>(hotelDtlq, HttpStatus.OK);
		} catch (Exception exception) {
			logger.error(AloreConstants.EXCEPTION_IN + new Object() {
			}.getClass().getEnclosingMethod().getName(), exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/remove/hotel/{id}")
	public String removeHotelDetail(@PathVariable Integer id) {
		try {
			logger.info(AloreConstants.Entered + new Object() {
			}.getClass().getEnclosingMethod().getName());
			hotelDetailsRepo.deleteById(id);
			logger.info(AloreConstants.Exiting + new Object() {
			}.getClass().getEnclosingMethod().getName());
			return "Deleted Hotel Details";
		} catch (Exception exception) {
			logger.error(AloreConstants.EXCEPTION_IN + new Object() {
			}.getClass().getEnclosingMethod().getName(), exception);
			return "Failed To Delete";
		}
	}
	
	
}
