package com.mitarcon.connections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ConnectionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectionsApplication.class, args);
	}
}
