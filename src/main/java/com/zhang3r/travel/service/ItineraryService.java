package com.zhang3r.travel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zhang3r.travel.model.CityDTO;

@Service
public class ItineraryService {
	private List<CityDTO> cityList;

	public void addCity(String name) {
		getCityList().add(new CityDTO(name));
	}

	public void addCity(CityDTO city) {
		getCityList().add(city);
	}

	public List<CityDTO> getCityList() {
		if (cityList == null) {
			cityList = new ArrayList<>();
		}
		return cityList;
	}

	public void setCityList(List<CityDTO> cityList) {
		this.cityList = cityList;
	}
}
