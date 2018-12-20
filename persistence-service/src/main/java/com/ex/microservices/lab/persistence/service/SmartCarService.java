package com.ex.microservices.lab.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Sink.class)
public class SmartCarService implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private Sink sink;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		sink.input().subscribe(message -> nameService.addName(new String((byte[]) message.getPayload())));
	}

	public void
}
