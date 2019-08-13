package com.alore.assignment.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alore.assignment.dto.HotelReview;

@Repository
public interface HotelReviewRepo extends CrudRepository<HotelReview, Integer>{
	
	@Query(value="from HotelReview where city =:city  and date =:date and (number_of_rooms =:numberOfRooms or ac =:ac or meals =:meals) order by rating desc")
	List<HotelReview> findAll(@Param (value= "city") String city, @Param(value = "date") Date date,
			@Param(value= "numberOfRooms") Integer numberOfRooms, @Param(value = "ac") Boolean ac, @Param(value = "meals") Boolean meals);
	
	List<HotelReview> findByOverAllRating(@Param(value="overAllRating") Integer  overAllRating);

}
