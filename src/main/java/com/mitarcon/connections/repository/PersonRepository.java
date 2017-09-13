package com.mitarcon.connections.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mitarcon.connections.domain.PersonEntity;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {

}
