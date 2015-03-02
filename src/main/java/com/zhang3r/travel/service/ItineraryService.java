package com.zhang3r.travel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zhang3r.travel.error.ApplicationError;
import com.zhang3r.travel.model.CityDTO;

/**
 * still need CREATE READ UPDATE DELETE
 * 
 * @author rzhang
 *
 */
@Service
@Repository
public class ItineraryService {
	@Autowired
	private MongoTemplate mongoTemplate;

	public static final String COLLECTION_NAME = "cities";

	public void addCity(CityDTO city) {
		if (!mongoTemplate.collectionExists(CityDTO.class)) {
			mongoTemplate.createCollection(CityDTO.class);
		}
		city.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(city, COLLECTION_NAME);
	}

	public CityDTO findCity(String id){
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		return mongoTemplate.findOne(query, CityDTO.class);
		
	}

	public List<CityDTO> listCities() {
		return mongoTemplate.findAll(CityDTO.class, COLLECTION_NAME);
	}

	public void deleteCity(CityDTO city) {
		mongoTemplate.remove(city, COLLECTION_NAME);
	}

	public void updateCity(CityDTO city) {
		mongoTemplate.insert(city, COLLECTION_NAME);
	}

}
