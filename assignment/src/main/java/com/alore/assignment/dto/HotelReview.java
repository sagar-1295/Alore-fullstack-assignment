package com.alore.assignment.dto;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "hotel_review")
public class HotelReview {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "hotel_name")
	private String hotelName;

	@Column(name = "hotel_id")
	private Integer hotelID;

	@Column(name = "city")
	private String city;

	@Column(name = "number_of_rooms")
	private Integer numberOfRooms;

	@Column(name = "wifi")
	private Boolean wifi;

	@Column(name = "ac")
	private Boolean ac;

	@Column(name = "meals")
	private Boolean meals;

	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	@Column(name = "rooms_availability")
	private Boolean roomsAvailability;

	@Column(name = "rating")
	private Integer rating;

	@Column(name = "review")
	private String review;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "user_name")
	private String username;

	@Column(name = "user_email")
	private String user_email;

	@Column(name = "over_all_rating")
	private Integer overAllRating;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public Integer getHotelID() {
		return hotelID;
	}

	public void setHotelID(Integer hotelID) {
		this.hotelID = hotelID;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(Integer numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public Boolean getWifi() {
		return wifi;
	}

	public void setWifi(Boolean wifi) {
		this.wifi = wifi;
	}

	public Boolean getAc() {
		return ac;
	}

	public void setAc(Boolean ac) {
		this.ac = ac;
	}

	public Boolean getMeals() {
		return meals;
	}

	public void setMeals(Boolean meals) {
		this.meals = meals;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getRoomsAvailability() {
		return roomsAvailability;
	}

	public void setRoomsAvailability(Boolean roomsAvailability) {
		this.roomsAvailability = roomsAvailability;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public Integer getOverAllRating() {
		return overAllRating;
	}

	public void setOverAllRating(Integer overAllRating) {
		this.overAllRating = overAllRating;
	}

}
