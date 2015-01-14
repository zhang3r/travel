package com.zhang3r.travel.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
public class CityDTO {
	private String name;
	private String description;
	private Date date;
	private String title;
	private UUID id;

	private List<TravelDTO> travel;
	private List<HotelDTO> hotel;
	private List<TourDTO> tours;

	public CityDTO(String name) {
		this.name = name;
		this.id = UUID.randomUUID();
	}

	public void generateId(){
		this.id=UUID.randomUUID();
	}
	public String getId() {
		return id.toString();
	}

	public void setId(String id) {
		this.id = UUID.fromString(id);
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
		return hotel;
	}

	public void setHotel(List<HotelDTO> hotel) {
		if (hotel == null) {
			hotel = new ArrayList<>();
		}
		this.hotel = hotel;
	}

	public List<TourDTO> getTours() {
		return tours;
	}

	public void setTours(List<TourDTO> tours) {
		if (tours == null) {
			tours = new ArrayList<>();
		}
		this.tours = tours;
	}

	// restaurants?
	// museums?

}
