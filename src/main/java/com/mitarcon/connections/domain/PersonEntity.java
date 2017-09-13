package com.mitarcon.connections.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(uniqueConstraints = 
		@UniqueConstraint(columnNames = {"id", "email"}))
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String fitstName;
	
	private String lastName;
	
	private String ci;
	
	private LocalDate birthdate;
	
	@OneToOne(cascade = CascadeType.ALL)
	private AddressEntity address;
	
	private String email;
}
