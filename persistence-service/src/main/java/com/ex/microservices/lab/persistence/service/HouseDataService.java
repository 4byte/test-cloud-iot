package com.ex.microservices.lab.persistence.service;

import com.ex.microservices.lab.persistence.dto.HouseDataDTO;
import com.ex.microservices.lab.persistence.repository.HouseDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Sink.class)
public class HouseDataService implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private Sink sink;
	@Autowired
	private HouseDataRepository houseDataRepository;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		sink.input().subscribe(message -> houseDataRepository.save(((HouseDataDTO) message.getPayload()).toHouseData()));
	}
}
