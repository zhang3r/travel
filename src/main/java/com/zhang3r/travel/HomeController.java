package com.zhang3r.travel;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhang3r.travel.model.CityDTO;
import com.zhang3r.travel.model.HotelDTO;
import com.zhang3r.travel.model.TourDTO;
import com.zhang3r.travel.model.TravelDTO;
import com.zhang3r.travel.mongo.MongoConnectionService;
import com.zhang3r.travel.service.ItineraryService;
import com.zhang3r.travel.util.UUIDUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private ItineraryService itService;
	@Autowired
	private UUIDUtil uuidService;
	
	@Autowired
	private MongoConnectionService dbService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		Gson gson = new GsonBuilder()
		.setDateFormat("MM/dd/yyyy")
		.create();
		String formattedDate = dateFormat.format(date);
		String json = gson.toJson(itService.getCityList());
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("jsonData", json );

		return "home";
	}

	@RequestMapping(value = "/addCity", method = RequestMethod.POST)
	@ResponseBody
	public String addCity(@RequestBody String add, Model model) {
		String json =add;
		Gson gson = new GsonBuilder()
		.setDateFormat("MM/dd/yyyy")
		.create();
		// convert java object to JSON format,
		// and returned as JSON formatted string
		CityDTO city= gson.fromJson(json, CityDTO.class);
		city.setId(uuidService.generateId());
		itService.addCity(city);
		json = gson.toJson(itService.getCityList());
		dbService.connectToMongo();
		
		
		return json;

	}
	
	@RequestMapping(value = "/addTravel", method = RequestMethod.POST)
	@ResponseBody
	public String addTravel(@RequestBody String add, Model model) {
		String json =add;
		Gson gson = new GsonBuilder()
		.setDateFormat("MM/dd/yyyy")
		.create();
		// convert java object to JSON format,
		// and returned as JSON formatted string
		TravelDTO travel= gson.fromJson(json, TravelDTO.class);
		travel.setId(uuidService.generateId());
		for(CityDTO city: itService.getCityList()){
			if(city.getId().equals(travel.getCityId())){
				city.getTravel().add(travel);
			}
		}
		//itService.addCity(city);
		json = gson.toJson(itService.getCityList());
		
		
		return json;

	}
	
	@RequestMapping(value = "/addHotel", method = RequestMethod.POST)
	@ResponseBody
	public String addHotel(@RequestBody String add, Model model) {
		String json =add;
		Gson gson = new GsonBuilder()
		.setDateFormat("MM/dd/yyyy")
		.create();
		// convert java object to JSON format,
		// and returned as JSON formatted string
		HotelDTO hotel= gson.fromJson(json, HotelDTO.class);
		hotel.setId(uuidService.generateId());
		for(CityDTO city: itService.getCityList()){
			if(city.getId().equals(hotel.getCityId())){
				city.getHotel().add(hotel);
			}
		}
		//itService.addCity(city);
		json = gson.toJson(itService.getCityList());
		
		
		return json;

	}
	@RequestMapping(value = "/addTours", method = RequestMethod.POST)
	@ResponseBody
	public String addTours(@RequestBody String add, Model model) {
		String json =add;
		Gson gson = new GsonBuilder()
		.setDateFormat("MM/dd/yyyy")
		.create();
		// convert java object to JSON format,
		// and returned as JSON formatted string
		TourDTO tour= gson.fromJson(json, TourDTO.class);
		tour.setId(uuidService.generateId());
		for(CityDTO city: itService.getCityList()){
			if(city.getId().equals(tour.getCityId())){
				city.getTours().add(tour);
			}
		}
		//itService.addCity(city);
		json = gson.toJson(itService.getCityList());
		
		
		return json;

	}

}
