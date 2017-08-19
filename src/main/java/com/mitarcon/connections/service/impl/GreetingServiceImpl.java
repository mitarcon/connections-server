package com.mitarcon.connections.service.impl;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mitarcon.connections.domain.Greeting;
import com.mitarcon.connections.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {

	
	private static BigInteger nextId;
	private static Map<BigInteger, Greeting> greetingMap;
	
	private static Greeting save(Greeting greting){
		if (greetingMap == null){
			greetingMap = new HashMap<BigInteger, Greeting>();
			nextId = BigInteger.ONE;
		}
		
//		If update
		if (greting.getId() != null){
			Greeting greetingOld = greetingMap.get(greting.getId());
			if (greetingOld == null){
				return null;
			}
			greetingMap.remove(greting.getId());
			greetingMap.put(greting.getId(), greting);
			return greting;
		}
		
//		If create
		greting.setId(nextId);
		greetingMap.put(nextId, greting);
		nextId = nextId.add(BigInteger.ONE);
		return greting;
	}
	
	private static boolean remove(BigInteger id){
		Greeting greeting = greetingMap.remove(id);
		if (greeting == null) {
			return false;
		} else {
			return true;
		}
	}
	
	static {
		Greeting aux = new Greeting ();
		aux.setText("Mensaje 1");
		save(aux);
		
		aux = new Greeting ();
		aux.setText("Mensaje 2");
		save(aux);
	}
	
	
	@Override
	public Collection<Greeting> findAll() {
		// TODO Auto-generated method stub
		return greetingMap.values();
	}

	@Override
	public Greeting FindOne(BigInteger id) {
		// TODO Auto-generated method stub
		return greetingMap.get(id);
	}

	@Override
	public Greeting create(Greeting greeting) {
		// TODO Auto-generated method stub
		return save(greeting);
	}

	@Override
	public Greeting update(Greeting greeting) {
		// TODO Auto-generated method stub
		return save(greeting);
	}

	@Override
	public void delete(BigInteger id) {
		// TODO Auto-generated method stub
		delete(id);
	}

}
