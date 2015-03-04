package com.zhang3r.travel.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CityDTO {
	private String name;
	private String description;
	private Date date;
	private String title;
	@Id
	private String id;
	
	private String userId;

	private List<TravelDTO> travel;
	private List<HotelDTO> hotel;
	private List<TourDTO> tours;

	public CityDTO() {
	}

	public CityDTO(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<TravelDTO> getTravel() {
		if (travel == null) {
			travel = new ArrayList<>();
		}
		return travel;
	}

	public void setTravel(List<TravelDTO> travel) {
		this.travel = travel;
	}

	public List<HotelDTO> getHotel() {
		if (hotel == null) {
			hotel = new ArrayList<>();
		}
		return hotel;
	}

	public void setHotel(List<HotelDTO> hotel) {
		this.hotel = hotel;
	}

	public List<TourDTO> getTours() {
		if (tours == null) {
			tours = new ArrayList<>();
		}
		return tours;
	}

	public void setTours(List<TourDTO> tours) {
		
		this.tours = tours;
	}

	

}
