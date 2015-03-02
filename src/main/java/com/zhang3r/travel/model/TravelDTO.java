package com.zhang3r.travel.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;

public class TravelDTO {
	public enum TravelType {
		PLANE, RAIL, BUS, FERRY, CAR, CRUISE, OTHER
	}

	private TravelType travelType;
	private String title;
	private String name;
	private String reservationNumber;
	private String passengerName;
	private String info;
	private String confirmationNumber;
	private String seatNumber;
	private String departureCity;
	private String arrivalCity;
	private Date departure;
	private Date arrival;
	private double cost;
	@Id
	private String id;
	private String cityId;

	public TravelDTO() {
		setId(UUID.randomUUID().toString());

	}

	public TravelDTO(String name) {
		this();
		this.name = name;
	}

	public TravelType getTravelType() {
		return travelType;
	}

	public void setTravelType(TravelType travelType) {
		this.travelType = travelType;
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

	public String getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(String number) {
		this.reservationNumber = number;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(String confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public Date getDeparture() {
		return departure;
	}

	public void setDeparture(Date departure) {
		this.departure = departure;
	}

	public Date getArrival() {
		return arrival;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
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

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public void generateId() {
		// TODO Auto-generated method stub

	}

}
