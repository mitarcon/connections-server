package com.mitarcon.connections.service;

import java.math.BigInteger;
import java.util.Collection;

import com.mitarcon.connections.domain.Greeting;

public interface GreetingService {

	Collection<Greeting> findAll();
	Greeting FindOne(BigInteger id);
	Greeting create(Greeting greeting);
	Greeting update(Greeting greeting);
	void delete(BigInteger id);
}
