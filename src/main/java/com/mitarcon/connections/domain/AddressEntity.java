package com.mitarcon.connections.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {
	
	@Id
	@GeneratedValue
	public Long id;
	
	public String Country;
	
	public String state;
	
	public String postalCode;
	
	public String city;
	
	public String street;
	
	public String aparment;
	
}
