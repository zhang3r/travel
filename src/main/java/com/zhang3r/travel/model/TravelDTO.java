package com.zhang3r.travel.model;

import java.util.Date;

public class TravelDTO {
	public enum TravelType {
		PLANE,
		RAIL,
		BUS,
		FERRY,
		CAR,
		CRUISE,

	}

	private TravelType travelType;
	private String title;
	private String name;
	private String number;
	private String passengerName;
	private String info;
	private String confirmationNumber;
	private String seatNumber;
	private Date departure;
	private Date arrival;
	private double cost;

}
