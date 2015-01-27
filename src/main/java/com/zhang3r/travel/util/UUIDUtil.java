package com.zhang3r.travel.util;

import java.util.UUID;

import org.springframework.stereotype.Service;
@Service
public class UUIDUtil {
	
	public String generateId(){
		return UUID.randomUUID().toString();
		
	}

}
