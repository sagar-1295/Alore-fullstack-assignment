package com.alore.assignment.controller;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alore.assignment.dto.HotelDetails;
import com.alore.assignment.dto.HotelReview;
import com.alore.assignment.service.HotelReviewService;
import com.alore.assignment.utils.AloreConstants;

@RestController
public class HotelReviewController {

	private static final Logger logger = LoggerFactory.getLogger(HotelReviewController.class);

	@Autowired
	HotelReviewService hotelReviewService;

	@PostMapping("/hotel/review")
	public ResponseEntity<?> storeHotelReviews(@RequestBody HotelReview hotelReview , @RequestParam Integer hotelID, @RequestParam Integer userID) {
		try {
			logger.info(AloreConstants.Entered + new Object() {
			}.getClass().getEnclosingMethod().getName());

			String hotelDtl = hotelReviewService.storeHotelReviews(hotelReview, hotelID, userID);

			logger.info(AloreConstants.Exiting + new Object() {
			}.getClass().getEnclosingMethod().getName());
			return new ResponseEntity<String>(hotelDtl, HttpStatus.OK);
		} catch (Exception exception) {
			logger.error(AloreConstants.EXCEPTION_IN + new Object() {
			}.getClass().getEnclosingMethod().getName(), exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/search/hotel/details")
	public ResponseEntity<?> searchHotelDetails(@RequestParam String city, @RequestParam Date date,
			@RequestParam(required = true) Integer numberOfRooms, @RequestParam(required = false) Boolean ac,
			@RequestParam(required = false) Boolean meals) {
		try {
			logger.info(AloreConstants.Entered + new Object() {
			}.getClass().getEnclosingMethod().getName());

			List<HotelReview> hotelDtl = hotelReviewService.searchHotelDetails(city, date, numberOfRooms, ac, meals);

			logger.info(AloreConstants.Exiting + new Object() {
			}.getClass().getEnclosingMethod().getName());
			return new ResponseEntity<List<HotelReview>>(hotelDtl, HttpStatus.OK);
		} catch (Exception exception) {
			logger.error(AloreConstants.EXCEPTION_IN + new Object() {
			}.getClass().getEnclosingMethod().getName(), exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/fetch/hotel")
	public ResponseEntity<?> fetchHotel(@RequestParam Integer overAllRating) {
		try {
			logger.info(AloreConstants.Entered + new Object() {
			}.getClass().getEnclosingMethod().getName());

			List<HotelReview> hotelDtl = hotelReviewService.fetchHotel(overAllRating);

			logger.info(AloreConstants.Exiting + new Object() {
			}.getClass().getEnclosingMethod().getName());
			return new ResponseEntity<List<HotelReview>>(hotelDtl, HttpStatus.OK);
		} catch (Exception exception) {
			logger.error(AloreConstants.EXCEPTION_IN + new Object() {
			}.getClass().getEnclosingMethod().getName(), exception);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
