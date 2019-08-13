package com.alore.assignment.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alore.assignment.dto.HotelDetails;
import com.alore.assignment.repo.HotelDetailsRepo;

@Service
public class HotelDetailsService {

	@Autowired
	HotelDetailsRepo hotelDetailsRepo;

	public HotelDetails storeHotelDetails(HotelDetails hotelDetails) {
		hotelDetails.setCreatedAt(Timestamp.from(Instant.now()));
		return hotelDetailsRepo.save(hotelDetails);
	}

	public List<HotelDetails> fetchHotelDetails(String city, Date date, Integer numberOfRooms, Boolean ac,
			Boolean meals, Integer rating) {
		return hotelDetailsRepo.findAll(city, date, numberOfRooms, ac, meals, rating);
	}

	public HotelDetails updateHotelDetail(Integer id, String hotelName,  String city,  Date date, Integer numberOfRooms, 
			Boolean ac, Boolean meals, Boolean wifi, Boolean roomsAvailability) {
		HotelDetails hotelDtl = hotelDetailsRepo.findById(id).get();
		hotelDtl.setCity(city);
		hotelDtl.setHotelName(hotelName);
		hotelDtl.setAc(ac);
		hotelDtl.setDate(date);
		hotelDtl.setMeals(meals);
		hotelDtl.setWifi(wifi);
		hotelDtl.setNumberOfRooms(numberOfRooms);
		hotelDtl.setRoomsAvailability(roomsAvailability);
		return hotelDetailsRepo.save(hotelDtl);
	}
}
