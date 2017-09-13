package com.mitarcon.connections.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
public class ClientEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String rif;
	
}
