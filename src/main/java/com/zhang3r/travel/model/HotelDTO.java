package com.zhang3r.travel.model;

import java.util.Date;

public class HotelDTO {
	public enum HotelType {
		AIRBNB,
		HOTEL,
		HOSTEL,
		OTHER,
	}
	public enum RoomType {
		DORMITORY,
		SINGLE,
		TWIN,
		DOUBLE,
		DOUBLE_DOUBLE,
		TRIPLE,
		QUEEN,
		KING,
		OTHER,
	}

	private HotelType hotelType;
	private String name;
	private String confirmationNumber;
	private String reservationNumber;
	private String description;
	private String address;
	private String phoneNumber;
	private String city;
	private String country;
	private String zipCode;
	private RoomType roomType;
	private int rating;
	private int nightNumber;
	private Date arrival;
	private Date departure;
	private double cost;
	private String id;

	public HotelDTO() {

	}

	public HotelType getHotelType() {
		return hotelType;
	}

	public void setHotelType(HotelType hotelType) {
		this.hotelType = hotelType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getNightNumber() {
		return nightNumber;
	}

	public void setNightNumber(int nightNumber) {
		this.nightNumber = nightNumber;
	}

	public Date getArrival() {
		return arrival;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public Date getDeparture() {
		return departure;
	}

	public void setDeparture(Date departure) {
		this.departure = departure;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

}
