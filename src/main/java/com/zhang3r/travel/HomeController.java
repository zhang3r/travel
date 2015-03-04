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
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(value = "/{userId}")
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
	public String home(@PathVariable String userId, Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.info("userId is:" + userId);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);
		Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();
		String formattedDate = dateFormat.format(date);
		String json = gson.toJson(itService.listCities(userId));
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("jsonData", json);

		return "home";
	}

	@RequestMapping(value = "/addCity", method = RequestMethod.POST)
	public String addCity(@PathVariable String userId,
			HttpServletRequest request,
			@ModelAttribute("cityForm") CityDTO city, BindingResult result,
			Model model) {
		// convert java object to JSON format,
		// and returned as JSON formatted string
		itService.addCity(city, userId);
		// model.addAttribute("jsonData", gson.toJson(itService.listCities()));
		return "redirect:/"+userId+"/";

	}

	@RequestMapping(value = "/addTravel", method = RequestMethod.POST)
	public String addTravel(@PathVariable String userId,
			HttpServletRequest request,
			@ModelAttribute("travelForm") TravelDTO travel,
			BindingResult result, Model model) {

		// get city
		CityDTO city = itService.findCity(travel.getCityId(), userId);
		// update city
		if (city != null) {

			city.getTravel().add(travel);
			itService.updateCity(city, userId);
		} else {
			logger.info("updating travel" + travel.getCityId());
			outerloop: for (CityDTO cityDto : itService.listCities(userId)) {
				for (TravelDTO travelDto : cityDto.getTravel()) {
					if (travelDto.getId().equals(travel.getCityId())) {
						logger.info("travel updated");
						cityDto.getTravel().remove(travelDto);
						travel.setCityId(cityDto.getId());
						travel.setId(travelDto.getId());
						cityDto.getTravel().add(travel);
						itService.updateCity(cityDto, userId);
						break outerloop;
					}
				}

			}

		}

		return "redirect:/"+userId+"/";

	}

	@RequestMapping(value = "/addHotel", method = RequestMethod.POST)
	public String addHotel(@PathVariable String userId,
			HttpServletRequest request,
			@ModelAttribute("hotelForm") HotelDTO hotel, BindingResult result,
			Model model) {
		// get city
		CityDTO city = itService.findCity(hotel.getCityId(), userId);
		// update city
		if (city != null) {
			city.getHotel().add(hotel);
			itService.updateCity(city, userId);
		} else {
			logger.info("updating hotel" + hotel.getCityId());
			outerloop: for (CityDTO cityDto : itService.listCities(userId)) {
				for (HotelDTO hotelDTO : cityDto.getHotel()) {
					if (hotelDTO.getId().equals(hotel.getCityId())) {
						logger.info("travel updated");
						cityDto.getHotel().remove(hotelDTO);
						hotel.setCityId(cityDto.getId());
						hotel.setId(hotelDTO.getId());
						cityDto.getHotel().add(hotel);
						itService.updateCity(cityDto, userId);
						break outerloop;
					}
				}

			}
		}

		return "redirect:/"+userId+"/";
	}

	@RequestMapping(value = "/addTours", method = RequestMethod.POST)
	public String addTours(@PathVariable String userId,
			HttpServletRequest request,
			@ModelAttribute("toursForm") TourDTO tour, BindingResult result,
			Model model) {
		// get city
		CityDTO city = itService.findCity(tour.getCityId(), userId);
		// update city
		if (city != null) {

			city.getTours().add(tour);
			itService.updateCity(city, userId);
		} else {
			logger.info("updating tour" + tour.getCityId());
			outerloop: for (CityDTO cityDto : itService.listCities(userId)) {
				for (TourDTO tourDTO : cityDto.getTours()) {
					if (tourDTO.getId().equals(tour.getCityId())) {
						logger.info("travel updated");
						cityDto.getTours().remove(tourDTO);
						tour.setCityId(cityDto.getId());
						tour.setId(tourDTO.getId());
						cityDto.getTours().add(tour);
						itService.updateCity(cityDto, userId);
						break outerloop;
					}
				}

			}
		}

		return "redirect:/"+userId+"/";

	}

	@RequestMapping(value = "/cityList", method = RequestMethod.GET)
	@ResponseBody
	public String cityList(@PathVariable String userId, Locale locale,
			Model model) {
		String json = "";
		Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();
		json = gson.toJson(itService.listCities(userId));

		return json;
	}

	@RequestMapping(value = "/deleteCity", method = RequestMethod.POST)
	@ResponseBody
	public String removeCity(@PathVariable String userId, @RequestBody String id) {

		CityDTO deletee = itService.findCity(id, userId);
		if (deletee != null) {
			logger.info("removing city id:" + id);
			itService.deleteCity(deletee);
		}
		String json = "";
		Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();
		json = gson.toJson(itService.listCities(userId));

		return json;
	}

	@RequestMapping(value = "/deleteTravel", method = RequestMethod.POST)
	@ResponseBody
	public String removeTravel(@PathVariable String userId,
			@RequestBody String id) {
		CityDTO deletee = null;
		TravelDTO deleteTravel = null;
		logger.info("travel for removal:" + id);
		// find tour
		outerloop: for (CityDTO city : itService.listCities(userId)) {
			for (TravelDTO travel : city.getTravel()) {
				if (travel.getId().equals(id)) {
					deletee = city;
					deleteTravel = travel;
					break outerloop;
				}
			}

		}

		if (deletee != null && deleteTravel != null) {
			logger.info("removing travel id:" + id);
			deletee.getTravel().remove(deleteTravel);
			itService.updateCity(deletee, userId);
		}
		String json = "";
		Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();
		json = gson.toJson(itService.listCities(userId));

		return json;
	}

	@RequestMapping(value = "/deleteHotel", method = RequestMethod.POST)
	@ResponseBody
	public String removeHotel(@PathVariable String userId,
			@RequestBody String id) {
		CityDTO deletee = null;
		HotelDTO deleteHotel = null;
		logger.info("travel for removal:" + id);
		// find tour
		outerloop: for (CityDTO city : itService.listCities(userId)) {
			for (HotelDTO hotel : city.getHotel()) {
				if (hotel.getId().equals(id)) {
					deletee = city;
					deleteHotel = hotel;
					break outerloop;
				}
			}

		}

		if (deletee != null && deleteHotel != null) {
			logger.info("removing hotel id:" + id);
			deletee.getHotel().remove(deleteHotel);
			itService.updateCity(deletee, userId);
		}
		String json = "";
		Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();
		json = gson.toJson(itService.listCities(userId));

		return json;
	}

	@RequestMapping(value = "/deleteTour", method = RequestMethod.POST)
	@ResponseBody
	public String removeTour(@PathVariable String userId, @RequestBody String id) {
		CityDTO deletee = null;
		TourDTO deleteTour = null;
		logger.info("travel for removal:" + id);
		// find tour
		outerloop: for (CityDTO city : itService.listCities(userId)) {
			for (TourDTO tour : city.getTours()) {
				if (tour.getId().equals(id)) {
					deletee = city;
					deleteTour = tour;
					break outerloop;
				}
			}

		}

		if (deletee != null && deleteTour != null) {
			logger.info("removing tour id:" + id);
			deletee.getTours().remove(deleteTour);
			itService.updateCity(deletee, userId);
		}
		String json = "";
		Gson gson = new GsonBuilder().setDateFormat("MM/dd/yyyy").create();
		json = gson.toJson(itService.listCities(userId));

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

	@ModelAttribute("hotelForm")
	public HotelDTO getHotelForm() {
		return new HotelDTO();
	}

	@ModelAttribute("toursForm")
	public TourDTO getTourForm() {
		return new TourDTO();
	}

}
