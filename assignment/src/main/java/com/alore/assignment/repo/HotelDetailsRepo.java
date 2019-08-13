package com.alore.assignment.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alore.assignment.dto.HotelDetails;

@Repository
public interface HotelDetailsRepo extends CrudRepository<HotelDetails, Integer>{

	@Query(value="from HotelDetails where city =:city  and date =:date and number_of_rooms =:numberOfRooms and ac =:ac and meals =:meals and rating =:rating")
	List<HotelDetails> findbyCityAndDateAndNumberOfRoomsAndACAndMealsAndRating(@Param (value= "city") String city, @Param(value = "date") Date date,
			@Param(value= "numberOfRooms") Integer numberOfRooms, @Param(value = "ac") Boolean ac, @Param(value = "meals") Boolean meals,
			@Param(value = "rating") Integer rating);
	
	@Query(value="from HotelDetails where city =:city  and date =:date and number_of_rooms =:numberOfRooms and ac =:ac and meals =:meals and rating =:rating")
	List<HotelDetails> findAll(@Param (value= "city") String city, @Param(value = "date") Date date,
			@Param(value= "numberOfRooms") Integer numberOfRooms, @Param(value = "ac") Boolean ac, @Param(value = "meals") Boolean meals,
			@Param(value = "rating") Integer rating);
	
	@Query(value="UPDATE HotelDetails SET hotel_name =:hotelName, city =:city, date =:date, ac =:ac, meals =:meals, number_of_rooms =:numberOfRooms, wifi =:wifi \r\n" + 
			", rooms_availability =:roomsAvailability  WHERE id =:id")
	HotelDetails updateHotelDetails(@Param(value = "hotelName") String hotelName, @Param(value="city") String city, @Param(value = "date") Date date, 
			@Param(value = "ac") Boolean ac, @Param(value = "meals") Boolean meals, @Param(value= "numberOfRooms") Integer numberOfRooms, 
			@Param(value= "wifi") Boolean wifi,
			@Param(value="roomsAvailability") Boolean roomsAvailability, @Param(value="id") Integer id);
	
	
	HotelDetails findByHotelName(String hotelName);
	
	HotelDetails findByHotelID(Integer hotelID);

}
