package com.zhang3r.travel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zhang3r.travel.model.CityDTO;

@Service
public class ItineraryService {
	private List<CityDTO> cityList;

	public List<CityDTO> getCityList() {
		return cityList;
	}

	public void setCityList(List<CityDTO> cityList) {
		this.cityList = cityList;
	}
}
