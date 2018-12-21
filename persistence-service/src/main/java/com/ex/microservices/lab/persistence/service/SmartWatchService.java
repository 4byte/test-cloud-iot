package com.ex.microservices.lab.persistence.service;

import com.ex.microservices.lab.persistence.config.SmartWatchProcessor;
import com.ex.microservices.lab.persistence.dto.SmartWatchDTO;
import com.ex.microservices.lab.persistence.repository.SmartWatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(SmartWatchProcessor.class)
public class SmartWatchService{

	@Autowired
	private SmartWatchRepository smartWatchRepository;

//	@Override
//	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//		sink.input().subscribe(message -> smartWatchRepository.save(((SmartWatchDTO) message.getPayload()).toSmartWatch()));
//	}

	@StreamListener(SmartWatchProcessor.SMART_WATCH)
	public void listen(SmartWatchDTO smartWatchDTO){
		System.out.println(smartWatchDTO);
	}
}
