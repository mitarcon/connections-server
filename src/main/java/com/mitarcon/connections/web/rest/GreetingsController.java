package com.mitarcon.connections.web.rest;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitarcon.connections.domain.Greetting;

@RestController
public class GreetingsController {
	
	private static BigInteger nextId;
	private static Map<BigInteger, Greetting> greetingMap;
	
	private static Greetting save(Greetting gretting){
		if (greetingMap == null){
			greetingMap = new HashMap<BigInteger, Greetting>();
			nextId = BigInteger.ONE;
		}
		gretting.setId(nextId);
		nextId = nextId.add(BigInteger.ONE);
		greetingMap.put(nextId, gretting);
		return gretting;
	}
	
	static {
		Greetting aux = new Greetting ();
		aux.setText("Mensaje 1");
		save(aux);
		
		aux = new Greetting ();
		aux.setText("Mensaje 2");
		save(aux);
	}
	
	@GetMapping(value="/greeting", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <Collection <Greetting>>  greeting(){
		
		Collection<Greetting> greeting = greetingMap.values(); 
		return new ResponseEntity <Collection <Greetting>>
		 (greeting, HttpStatus.OK);
	}
}
