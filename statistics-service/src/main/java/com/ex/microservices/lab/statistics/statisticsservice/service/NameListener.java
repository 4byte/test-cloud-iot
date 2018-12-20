package com.ex.microservices.lab.statistics.statisticsservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
@EnableBinding(Sink.class)

@Component
public class NameListener implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private Sink sink;
	@Autowired
	private NameService nameService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		sink.input().subscribe(message -> nameService.addName(new String((byte[])message.getPayload())));
	}
}
