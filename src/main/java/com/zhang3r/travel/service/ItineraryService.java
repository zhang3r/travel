package com.zhang3r.travel.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
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
	Logger logger = Logger.getLogger(ItineraryService.class);

	public static final String COLLECTION_NAME = "cities";

	public void addCity(CityDTO city) {
		if (!mongoTemplate.collectionExists(CityDTO.class)) {
			mongoTemplate.createCollection(CityDTO.class);
		}
		city.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(city, COLLECTION_NAME);
	}

	public CityDTO findCity(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		logger.info(query.toString());

		return (CityDTO) mongoTemplate.findOne(query, CityDTO.class,
				COLLECTION_NAME);

	}

	public List<CityDTO> listCities() {
		return mongoTemplate.findAll(CityDTO.class, COLLECTION_NAME);
	}

	public void deleteCity(CityDTO city) {
		mongoTemplate.remove(city, COLLECTION_NAME);
	}

	public void updateCity(CityDTO city) {
		logger.info("updating city");
		Update update = new Update();
		update.set("name",city.getName());
		update.set("description",city.getDescription());
		update.set("date", city.getDate());
		update.set("hotel",city.getHotel());
		update.set("tours",city.getTours());
		update.set("travel",city.getTravel());
		logger.info(update.toString());
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(city.getId()));
		WriteResult result = mongoTemplate.updateFirst(query, update, CityDTO.class, COLLECTION_NAME);
		logger.info(result.isUpdateOfExisting());
		if(!result.isUpdateOfExisting()){
			logger.info(result.getLastConcern().toString());
		}
	
		
	}

}
