package com.mitarcon.connections.service.impl;

import java.util.Collection;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mitarcon.connections.domain.GreetingEntity;
import com.mitarcon.connections.repository.GreetingRepository;
import com.mitarcon.connections.service.GreetingService;
import com.mitarcon.connections.service.dto.GreetingDTO;
import com.mitarcon.connections.util.DozerUtil;

@Service
@Transactional(
	propagation=Propagation.SUPPORTS,
	readOnly=true)
public class GreetingServiceImpl implements GreetingService {

	@Autowired
	GreetingRepository greetingRepository;

	@Autowired
	DozerBeanMapper mapper;

	@Override
	public Collection<GreetingDTO> findAll() {
		// TODO Auto-generated method stub
		Collection<GreetingEntity> greetings = greetingRepository.findAll();
		return DozerUtil.mapCollection(mapper, greetings, GreetingDTO.class);
	}
	@Override
	@Cacheable(
			value="greeting",
			key="#id")
	public GreetingDTO FindOne(int id) {
		// TODO Auto-generated method stub
		GreetingEntity greeting = greetingRepository.findOne(id);
		GreetingDTO output = mapper.map(greeting, GreetingDTO.class);
		return output;
	}
	@Override
	@Transactional(
			propagation=Propagation.REQUIRED,
			readOnly=false)
	@CachePut(
			value="greeting",
			key="#result.id")
	public GreetingDTO create(GreetingDTO greeting) {
		// TODO Auto-generated method stub
		
		GreetingEntity aux = greetingRepository.save(
				mapper.map(greeting, GreetingEntity.class));
		
		// Ilustar rollback
		if (aux.getId() == 4){
			throw new RuntimeException("Roll me back transaccion");
		}
		return mapper.map(
				aux, GreetingDTO.class);
	}
	@Override
	@Transactional(
			propagation=Propagation.REQUIRED,
			readOnly=false)
	@CachePut(
			value="greeting",
			key="#result.id")
	public GreetingDTO update(GreetingDTO greeting) {
		// TODO Auto-generated method stub
		return mapper.map(
				greetingRepository.save(
						mapper.map(greeting, GreetingEntity.class)),
				GreetingDTO.class);
	}
	@Override
	@Transactional(
			propagation=Propagation.REQUIRED,
			readOnly=false)
	@CacheEvict(
			value="greeting",
			key="#id")
	public void delete(int id) {
		// TODO Auto-generated method stub
		greetingRepository.delete(id);
	}
	@Override
	@CacheEvict(
			value="greeting",
			allEntries=true)
	public void evitCache() {
		// TODO Auto-generated method stub
		
	}

}
