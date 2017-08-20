package com.mitarcon.connections.domain;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class GreetingEntity {
	
	@Id
	@GeneratedValue
	private BigInteger id;
	private String text;
}
