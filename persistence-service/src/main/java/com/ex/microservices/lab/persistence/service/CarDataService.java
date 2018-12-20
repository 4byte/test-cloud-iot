package com.ex.microservices.lab.persistence.service;

import com.ex.microservices.lab.persistence.dto.CarDataDTO;
import com.ex.microservices.lab.persistence.repository.CarDataRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Sink.class)
public class CarDataService implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private Sink sink;
	@Autowired
	private CarDataRepository carDataRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		sink.input().subscribe(message -> carDataRepository.save(((CarDataDTO) message.getPayload()).toCarData()));
	}
}
