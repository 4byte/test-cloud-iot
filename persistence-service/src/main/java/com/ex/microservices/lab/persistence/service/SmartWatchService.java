package com.ex.microservices.lab.persistence.service;

import com.ex.microservices.lab.persistence.config.SmartWatchProcessor;
import com.ex.microservices.lab.persistence.dto.SmartWatchDTO;
import com.ex.microservices.lab.persistence.repository.SmartWatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Sink.class)
public class SmartWatchService implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private Sink sink;
	@Autowired
	private SmartWatchRepository smartWatchRepository;

//	@Override
//	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//		sink.input().subscribe(message -> smartWatchRepository.save(((SmartWatchDTO) message.getPayload()).toSmartWatch()));
//	}
 	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//		sink.input().subscribe(message -> smartWatchRepository.save(((SmartWatchDTO) message.getPayload()).toSmartWatch()));
	}

	@StreamListener(SmartWatchProcessor.INPUT)
	public void listen(SmartWatchDTO smartWatchDTO){
		System.out.println(smartWatchDTO);
	}
}
