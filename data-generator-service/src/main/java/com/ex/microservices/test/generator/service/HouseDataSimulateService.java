package com.ex.microservices.test.generator.service;

import com.ex.microservices.test.generator.dto.HouseDataDTO;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Random;
import java.util.UUID;

@Service
public class HouseDataSimulateService implements ApplicationListener<ContextRefreshedEvent> {
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		generateHouseDataAndSleep(1000);
	}

	@Async
	public void generateHouseDataAndSleep(long sleepMillis) {
		RestTemplate template = new RestTemplate();
		Random random = new Random();
		while (true) {
			template.postForLocation(URI.create("http://localhost:8083/house"), new HouseDataDTO(
					random.nextDouble() * 100,
					random.nextDouble() * 100,
					random.nextDouble() * 100,
					random.nextDouble() * 10,
					random.nextLong() * 10000,
					UUID.randomUUID().toString()
			));
			try {
				Thread.sleep(sleepMillis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
