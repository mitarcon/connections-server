package com.mitarcon.connections.batch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mitarcon.connections.service.GreetingService;

import lombok.extern.log4j.Log4j;

@Log4j
@Component
public class GreetingBatch {
	
	@Autowired
	GreetingService greetingService;
	
	@Scheduled(
			cron="0,30 * * * * *")
	public void cronJob(){
		log.info("> cronJob");
		
		log.info("Existen --" + 
				greetingService.findAll().size() +
				"-- elementos almacenados");
		
		log.info("< cronJob");
	}
}
