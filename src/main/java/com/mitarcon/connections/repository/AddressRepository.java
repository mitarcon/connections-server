package com.mitarcon.connections.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mitarcon.connections.domain.AddressEntity;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, Long> {

}
