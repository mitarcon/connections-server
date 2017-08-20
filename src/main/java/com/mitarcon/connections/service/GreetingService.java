package com.mitarcon.connections.service;

import java.util.Collection;

import com.mitarcon.connections.service.dto.GreetingDTO;

public interface GreetingService {

	Collection<GreetingDTO> findAll();
	GreetingDTO FindOne(int id);
	GreetingDTO create(GreetingDTO greeting);
	GreetingDTO update(GreetingDTO greeting);
	void delete(int id);
	void evitCache();
}
