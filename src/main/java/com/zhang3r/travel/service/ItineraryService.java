package com.zhang3r.travel.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mongodb.WriteResult;
import com.zhang3r.travel.error.ApplicationError;
import com.zhang3r.travel.model.CityDTO;

/**
 * 
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

	public void addCity(CityDTO city, String userId) {
		if (!mongoTemplate.collectionExists(CityDTO.class)) {
			mongoTemplate.createCollection(CityDTO.class);
		}
		if (findCity(city.getId(), userId) != null) {
			updateCity(city, userId);
			return;
		}
		city.setUserId(userId);
		city.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(city, COLLECTION_NAME);
	}

	public CityDTO findCity(String id, String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id)
				.andOperator(Criteria.where("userId").is(userId)));

		return mongoTemplate.findOne(query, CityDTO.class, COLLECTION_NAME);

	}

	public List<CityDTO> listCities(String userId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(userId));

		return mongoTemplate.find(query, CityDTO.class, COLLECTION_NAME);
	}

	public void deleteCity(CityDTO city) {
		mongoTemplate.remove(city, COLLECTION_NAME);

	}

	public void updateCity(CityDTO city, String userId) {

		Update update = new Update();
		update.set("name", city.getName());
		update.set("userId", userId);
		update.set("description", city.getDescription());
		update.set("date", city.getDate());
		update.set("hotel", city.getHotel());
		update.set("tours", city.getTours());
		update.set("travel", city.getTravel());

		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(city.getId())
				.andOperator(Criteria.where("userId").is(userId)));
		WriteResult result = mongoTemplate.updateFirst(query, update,
				CityDTO.class, COLLECTION_NAME);

		if (!result.isUpdateOfExisting()) {

		}

	}

}
