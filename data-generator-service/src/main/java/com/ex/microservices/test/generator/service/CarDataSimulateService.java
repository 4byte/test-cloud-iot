package com.ex.microservices.test.generator.service;

import com.ex.microservices.test.generator.dto.CarDataDTO;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Future;

@Service
public class CarDataSimulateService {

	public Future<Object> generateCarDataAndSleep() {
		RestTemplate template = new RestTemplate();
		Random random = new Random();
		while (true) {
			template.postForLocation(URI.create("http://localhost:8083/car"), new CarDataDTO(
					random.nextDouble(),
					random.nextDouble(),
					random.nextDouble(),
					System.currentTimeMillis(),
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
