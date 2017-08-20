package com.mitarcon.connections.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class GreetingEntity {
	
	@Id
	@GeneratedValue
	private int id;
	private String text;
}
