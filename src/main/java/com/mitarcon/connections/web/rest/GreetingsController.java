package com.mitarcon.connections.web.rest;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mitarcon.connections.domain.Greeting;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class GreetingsController {
	
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
	
	private static boolean delete(BigInteger id){
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
	
	@GetMapping(value="/greeting",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <Collection <Greeting>>  greeting(){
		log.info("Call : " + "greeting() ");
		Collection<Greeting> greeting = greetingMap.values(); 
		return new ResponseEntity <Collection <Greeting>>
		 (greeting, HttpStatus.OK);
	}
	
	@GetMapping(value="/greeting/{id}",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Greeting> getGreeting(@PathVariable("id") BigInteger id){
		log.info("Call : " + "getGreeting() " + "-- PathVariable: " + id);
		Greeting greeting = greetingMap.get(id);
		if (greeting == null){
			return new ResponseEntity<Greeting>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
		}
	}
	
	@PutMapping(value="/greeting/{id}",
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Greeting> updateGreeting(@RequestBody Greeting greeting){
		log.info("Call : " + "updateGreeting() " + "-- RequestBody: " + greeting.toString());
		greeting = save(greeting);
		if (greeting == null){
			return new ResponseEntity<Greeting>(greeting, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
		}
	}
	
	@DeleteMapping(value="/greeting/{id}")
	public ResponseEntity<Greeting> deleteGreeting(@PathVariable("id") BigInteger id){
		log.info("Call : " + "deleteGreeting() " + "-- PathVariable: " + id);
		if (delete(id)){
			return new ResponseEntity<Greeting>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Greeting>(HttpStatus.OK);
		}	 
	}
	
	@PostMapping(value="/greeting",
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Greeting> createGreeting(@RequestBody Greeting greeting){
		log.info("Call : " + "createGreeting() " + "-- RequestBody: " + greeting.toString());
		save(greeting);
		return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
		
	}
}
