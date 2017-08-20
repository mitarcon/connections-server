package com.mitarcon.connections.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCacheManager;

@Configuration
public class CacheConfiguration {

	@Bean
	public CacheManager cacheManager(){
		GuavaCacheManager  cacheManager = new GuavaCacheManager ("greeting");
		return cacheManager;
	}
}
