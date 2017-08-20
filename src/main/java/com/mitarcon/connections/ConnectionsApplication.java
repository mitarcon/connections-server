package com.mitarcon.connections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan
@EnableTransactionManagement
@EnableCaching
public class ConnectionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectionsApplication.class, args);
	}
}
