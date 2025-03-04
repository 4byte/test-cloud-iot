package com.ex.microservices.test.generator.service;

import com.ex.microservices.test.generator.dto.SmartWatchDTO;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Future;

@Service
public class WatchDataSimulateService {

	public Future<Object> generateWatchDataAndSleep() {
		RestTemplate template = new RestTemplate();
		Random random = new Random();
		while (true) {
			template.postForLocation(URI.create("http://localhost:8083/watch"), new SmartWatchDTO(
					random.nextDouble() * 200,
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
