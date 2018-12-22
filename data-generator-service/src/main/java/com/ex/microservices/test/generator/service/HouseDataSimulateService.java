package com.ex.microservices.test.generator.service;

import com.ex.microservices.test.generator.dto.HouseDataDTO;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Future;

@Service
public class HouseDataSimulateService {

	public Future<Object> generateHouseDataAndSleep() {
		RestTemplate template = new RestTemplate();
		Random random = new Random();
		while (true) {
			template.postForLocation(URI.create("http://localhost:8083/house"), new HouseDataDTO(
					random.nextDouble() * 100,
					random.nextDouble() * 100,
					random.nextDouble() * 100,
					random.nextDouble() * 10,
					Math.abs(((long) random.nextInt(100000000)) * 100),
					UUID.randomUUID().toString()
			));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
