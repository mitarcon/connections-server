package com.mitarcon.connections.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitarcon.connections.domain.GreetingEntity;

@Repository
public interface GreetingRepository extends JpaRepository<GreetingEntity, Integer> {

}
