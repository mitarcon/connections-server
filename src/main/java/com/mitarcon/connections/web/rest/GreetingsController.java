package com.mitarcon.connections.web.rest;

import java.math.BigInteger;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.mitarcon.connections.service.GreetingService;
import com.mitarcon.connections.service.dto.GreetingDTO;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class GreetingsController {
	
	@Autowired
	GreetingService greetingService;
	
	@GetMapping(value="/greeting",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <Collection <GreetingDTO>>  greeting(){
		log.info("Call : " + "greeting() ");
		return new ResponseEntity <Collection <GreetingDTO>>
			(greetingService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/greeting/{id}",
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GreetingDTO> getGreeting(@PathVariable("id") BigInteger id){
		log.info("Call : " + "getGreeting() " + "-- PathVariable: " + id);
		GreetingDTO greeting = greetingService.FindOne(id);
		if (greeting == null){
			return new ResponseEntity<GreetingDTO>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<GreetingDTO>(greeting, HttpStatus.OK);
		}
	}
	
	@PutMapping(value="/greeting/{id}",
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GreetingDTO> updateGreeting(@PathVariable("id") BigInteger id,
			@RequestBody GreetingDTO greeting){
		
		log.info("Call : " + "updateGreeting() " + "-- RequestBody: " + greeting.toString());
		greeting = greetingService.update(greeting);
		if (greeting == null){
			return new ResponseEntity<GreetingDTO>(greeting, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<GreetingDTO>(greeting, HttpStatus.OK);
		}
	}
	
	@DeleteMapping(value="/greeting/{id}")
	public ResponseEntity<GreetingDTO> deleteGreeting(@PathVariable("id") BigInteger id){
		log.info("Call : " + "deleteGreeting() " + "-- PathVariable: " + id);
		greetingService.delete(id);
		return new ResponseEntity<GreetingDTO>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(value="/greeting",
			produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GreetingDTO> createGreeting(@RequestBody GreetingDTO greeting){
		log.info("Call : " + "createGreeting() " + "-- RequestBody: " + greeting.toString());
		greeting = greetingService.create(greeting);
		return new ResponseEntity<GreetingDTO>(greeting, HttpStatus.OK);
		
	}
}
