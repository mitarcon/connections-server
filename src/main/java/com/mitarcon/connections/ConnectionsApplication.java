package com.mitarcon.connections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mitarcon.connections.domain.AddressEntity;
import com.mitarcon.connections.domain.PersonEntity;
import com.mitarcon.connections.repository.AddressRepository;
import com.mitarcon.connections.repository.PersonRepository;

import lombok.extern.log4j.Log4j;

@SpringBootApplication
@ComponentScan
@EnableTransactionManagement
@EnableCaching
@EnableScheduling
@Log4j
public class ConnectionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectionsApplication.class, args);
	}
	

	@Bean
	public CommandLineRunner demo(AddressRepository addressRepository, PersonRepository personRepository) {
		return (args) -> {
			AddressEntity add = new AddressEntity(null, "Caracas", "Distrito Capital", "1040", "Caracas", "Calle90", "70");
//			addressRepository.save(add);
//			log.info("GUARDO ADDRESS con id " + add.getId());
			
			PersonEntity per = new PersonEntity(null, "Mitchell", "Contreras", "20094680", null, add, "mitchellcontreras@gmail.com");
			personRepository.save(per);
			log.info("GUARDO PERSONA con id " + per.getId());
			
		};
	}
}
