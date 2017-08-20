package com.mitarcon.connections.service;

import java.math.BigInteger;
import java.util.Collection;

import com.mitarcon.connections.service.dto.GreetingDTO;

public interface GreetingService {

	Collection<GreetingDTO> findAll();
	GreetingDTO FindOne(BigInteger id);
	GreetingDTO create(GreetingDTO greeting);
	GreetingDTO update(GreetingDTO greeting);
	void delete(BigInteger id);
}
