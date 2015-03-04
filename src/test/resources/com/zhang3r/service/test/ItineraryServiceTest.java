package com.zhang3r.service.test;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.zhang3r.travel.model.CityDTO;
import com.zhang3r.travel.service.ItineraryService;


@Ignore
public class ItineraryServiceTest {

	@Autowired
	private ItineraryService itineraryService;

	@Before
	public void setup() {
		if (itineraryService == null) {
			itineraryService = new ItineraryService();
			
		}
	}

	// CRUD TESTS
	@Test
	public void createCity() {
		
		// create
		CityDTO city = new CityDTO();
		city.setName("abc");
		itineraryService.addCity(city,"a");
		List<CityDTO> cities = itineraryService.listCities("a");
		assert (cities.size() == 1);
	}

	@Test
	public void updateCity() {
		List<CityDTO> cities = itineraryService.listCities("a");
		assert (cities.size() == 1);
		CityDTO temp = cities.get(0);
		temp.setName("1234");
		itineraryService.updateCity(temp,"a");
		cities = itineraryService.listCities("a");
		assert (cities.size() == 1);
		assert (cities.get(0).getName().equals("1234"));
		;

	}

	@Test
	public void deleteCity() {
		List<CityDTO> cities = itineraryService.listCities("a");
		for (CityDTO city : cities) {
			itineraryService.deleteCity(city);
		}
		cities = itineraryService.listCities("a");
		assert (cities.isEmpty());
	}

}
