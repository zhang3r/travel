package com.zhang3r.travel.model;

import java.util.Date;

public class HotelDTO {
	public enum HotelType {
		AIRBNB,
		HOTEL,
		HOSTEL,
		FAMILY,
	}

	private HotelType hotelType;
	private String title;
	private String description;
	private String address;
	private String phoneNumber;
	private String city;
	private String country;
	private String zipCode;
	private int rating;
	private int nightNumber;
	private Date arrival;
	private Date departure;
	private double cost;

}
