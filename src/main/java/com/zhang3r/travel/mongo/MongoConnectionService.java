package com.zhang3r.travel.mongo;

import java.net.UnknownHostException;

import org.springframework.stereotype.Service;

import com.mongodb.DB;
import com.mongodb.MongoClient;

@Service
public class MongoConnectionService {
	public DB connectToMongo() {
		MongoClient mongoClient;
		try {
			mongoClient = new MongoClient();
			DB db = mongoClient.getDB("travel");
			return db;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
	}

}
