package com.zhang3r.travel;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhang3r.travel.model.CityDTO;
import com.zhang3r.travel.model.HotelDTO;
import com.zhang3r.travel.model.TourDTO;
import com.zhang3r.travel.model.TravelDTO;
import com.zhang3r.travel.service.ItineraryService;
import com.zhang3r.travel.util.UUIDUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	@Autowired
	private ItineraryService itService;
	@Autowired
	private UUIDUtil uuidService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);
		Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();
		String formattedDate = dateFormat.format(date);
		String json = gson.toJson(itService.listCities());
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("jsonData", json);

		return "home";
	}

	@RequestMapping(value = "/addCity", method = RequestMethod.POST)
	public String addCity(HttpServletRequest request,
			@ModelAttribute("cityForm") CityDTO city, BindingResult result,
			Model model) {
		// convert java object to JSON format,
		// and returned as JSON formatted string
		itService.addCity(city);
		// model.addAttribute("jsonData", gson.toJson(itService.listCities()));
		return "redirect:/";

	}

	@RequestMapping(value = "/addTravel", method = RequestMethod.POST)
	public String addTravel(HttpServletRequest request,
			@ModelAttribute("travelForm") TravelDTO travel,
			BindingResult result, Model model) {

		// get city
		CityDTO city = itService.findCity(travel.getCityId());
		// update city
		if (city != null) {
		
			city.getTravel().add(travel);
			itService.updateCity(city);
		}else{
			logger.info("no city found");
		}

		return "redirect:/";

	}

	@RequestMapping(value = "/addHotel", method = RequestMethod.POST)
	@ResponseBody
	public String addHotel(@RequestBody String add, Model model) {
		String json = add;
		Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();
		// convert java object to JSON format,
		// and returned as JSON formatted string
		HotelDTO hotel = gson.fromJson(json, HotelDTO.class);
		hotel.setId(uuidService.generateId());
		for (CityDTO city : itService.listCities()) {
			if (city.getId().equals(hotel.getCityId())) {
				city.getHotel().add(hotel);
			}
		}
		// itService.addCity(city);
		json = gson.toJson(itService.listCities());

		return json;

	}

	@RequestMapping(value = "/addTours", method = RequestMethod.POST)
	@ResponseBody
	public String addTours(@RequestBody String add, Model model) {
		String json = add;
		Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();
		// convert java object to JSON format,
		// and returned as JSON formatted string
		TourDTO tour = gson.fromJson(json, TourDTO.class);
		tour.setId(uuidService.generateId());
		for (CityDTO city : itService.listCities()) {
			if (city.getId().equals(tour.getCityId())) {
				city.getTours().add(tour);
			}
		}
		// itService.addCity(city);
		json = gson.toJson(itService.listCities());

		return json;

	}

	@RequestMapping(value = "/cityList", method = RequestMethod.GET)
	@ResponseBody
	public String cityList(Locale locale, Model model) {
		String json = "";
		Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();
		json = gson.toJson(itService.listCities());

		return json;
	}

	@ModelAttribute("cityForm")
	public CityDTO getForm() {
		return new CityDTO();
	}

	@ModelAttribute("travelForm")
	public TravelDTO getTravelForm() {
		return new TravelDTO();
	}
	// @ModelAttribute("hotelForm")
	// public HotelDTO getHotelForm() {
	// return new HotelDTO();
	// }
	// @ModelAttribute("toursForm")
	// public TourDTO getToursForm() {
	// return new TourDTO();
	// }

}
