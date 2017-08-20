package com.mitarcon.connections.service.impl;

import java.math.BigInteger;
import java.util.Collection;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitarcon.connections.domain.GreetingEntity;
import com.mitarcon.connections.repository.GreetingRepository;
import com.mitarcon.connections.service.GreetingService;
import com.mitarcon.connections.service.dto.GreetingDTO;

import com.mitarcon.connections.util.DozerUtil;

@Service
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
	public GreetingDTO FindOne(BigInteger id) {
		// TODO Auto-generated method stub
		GreetingEntity greeting = greetingRepository.findOne(id);
		GreetingDTO output = mapper.map(greeting, GreetingDTO.class);
		return output;
	}
	@Override
	public GreetingDTO create(GreetingDTO greeting) {
		// TODO Auto-generated method stub
		return mapper.map(
				greetingRepository.save(
						mapper.map(greeting, GreetingEntity.class)),
				GreetingDTO.class);
	}
	@Override
	public GreetingDTO update(GreetingDTO greeting) {
		// TODO Auto-generated method stub
		return mapper.map(
				greetingRepository.save(
						mapper.map(greeting, GreetingEntity.class)),
				GreetingDTO.class);
	}
	@Override
	public void delete(BigInteger id) {
		// TODO Auto-generated method stub
		greetingRepository.delete(id);
	}

}
