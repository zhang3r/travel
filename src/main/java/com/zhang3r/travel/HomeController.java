package com.zhang3r.travel;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhang3r.travel.model.CityDTO;
import com.zhang3r.travel.model.TravelDTO;
import com.zhang3r.travel.service.ItineraryService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private ItineraryService itService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String add(@RequestBody String add, Model model) {
		String json =add;
		Gson gson = new GsonBuilder()
		.setDateFormat("yyyy-MM-dd")
		.create();
		// convert java object to JSON format,
		// and returned as JSON formatted string
		CityDTO city= gson.fromJson(json, CityDTO.class);
		TravelDTO plane = new TravelDTO();
		plane.setTravelType(TravelDTO.TravelType.PLANE);
		plane.setCost(32.50);
		plane.setDepartureCity("Washington DC");
		plane.setArrivalCity(city.getName());
		city.getTravel().add(plane);
		itService.addCity(city);
		json = gson.toJson(itService.getCityList());
		if (add.equals("addCity")) {
			
			
			//model.addAttribute("dataJson", json);
		}else if(add.equals("addTravel")){
			
		}else if(add.equals("addHotel")){
			
		}else if(add.equals("addTours")){
			
		}else{
			
		}
		
		return json;

	}

}
