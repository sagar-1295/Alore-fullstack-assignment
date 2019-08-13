package com.alore.assignment.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alore.assignment.dto.HotelDetails;
import com.alore.assignment.dto.HotelReview;
import com.alore.assignment.dto.UserDetails;
import com.alore.assignment.repo.HotelDetailsRepo;
import com.alore.assignment.repo.HotelReviewRepo;
import com.alore.assignment.repo.UserDetailsRepo;

@Service
public class HotelReviewService {
	
	@Autowired
	HotelReviewRepo hotelReviewRepo;
	
	@Autowired
	HotelDetailsRepo hotelDetailsRepo;
	
	@Autowired
	UserDetailsRepo userDetailsRepo;

	public String storeHotelReviews(HotelReview hotelReview, Integer hotelID, Integer userID) {
		HotelDetails hotelDetails = hotelDetailsRepo.findById(hotelID).get();
		UserDetails userDetails = userDetailsRepo.findById(userID).get();
		if(hotelDetails != null && userDetails != null) {
		hotelReview.setHotelID(hotelDetails.getHotelID());
		hotelReview.setHotelName(hotelDetails.getHotelName());
		hotelReview.setAc(hotelDetails.getAc());
		hotelReview.setCity(hotelDetails.getCity());
		hotelReview.setMeals(hotelDetails.getMeals());
		hotelReview.setNumberOfRooms(hotelDetails.getNumberOfRooms());
		hotelReview.setDate(hotelDetails.getDate());
		hotelReview.setWifi(hotelDetails.getWifi());
		hotelReview.setRoomsAvailability(hotelDetails.getRoomsAvailability());	
		hotelReview.setCreatedAt(Timestamp.from(Instant.now()));
		hotelReview.setUsername(userDetails.getName());
		hotelReview.setUser_email(userDetails.getEmail());
		hotelReviewRepo.save(hotelReview);
		return "Successfully Added review";
		}else {
			return "Please enter correct userID or emailID!";
		}
	}

	public List<HotelReview> searchHotelDetails(String city, Date date, Integer numberOfRooms, Boolean ac,
			Boolean meals) {
		return hotelReviewRepo.findAll(city, date, numberOfRooms, ac, meals);
	}

	public List<HotelReview> fetchHotel(Integer overAllRating) {
		
		return hotelReviewRepo.findByOverAllRating(overAllRating);
	}

}
