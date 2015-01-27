package com.zhang3r.travel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zhang3r.travel.error.ApplicationError;
import com.zhang3r.travel.model.CityDTO;

/**
 * still need 
 * CREATE
 * READ
 * UPDATE
 * DELETE
 * @author rzhang
 *
 */
@Service
public class ItineraryService {
	private List<CityDTO> cityList;

	public void addCity(String name) {
		getCityList().add(new CityDTO(name));
	}

	public void addCity(CityDTO city) {
		getCityList().add(city);
	}

	//update
	public CityDTO getCity(String id) {
		for (CityDTO city : getCityList()) {
			if (city.getId().equals(id)) {
				return city;
			}
		}
		throw new ApplicationError("invalid id");
	}

	public List<CityDTO> getCityList() {
		if (cityList == null) {
			cityList = new ArrayList<CityDTO>();
		}
		return cityList;
	}

	public void setCityList(List<CityDTO> cityList) {
		this.cityList = cityList;
	}
}
