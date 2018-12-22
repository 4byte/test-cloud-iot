package com.ex.microservices.test.generator.controller;

import com.ex.microservices.test.generator.service.CarDataSimulateService;
import com.ex.microservices.test.generator.service.HouseDataSimulateService;
import com.ex.microservices.test.generator.service.WatchDataSimulateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class GenerateController implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	CarDataSimulateService carDataSimulateService;
	@Autowired
	HouseDataSimulateService houseDataSimulateService;
	@Autowired
	WatchDataSimulateService watchDataSimulateService;
	Logger logger = LoggerFactory.getLogger(GenerateController.class);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		logger.info("Starting to generate data for car, house, watch");
		ExecutorService service = Executors.newFixedThreadPool(3);
		service.submit(carDataSimulateService::generateCarDataAndSleep);
		service.submit(houseDataSimulateService::generateHouseDataAndSleep);
		service.submit(watchDataSimulateService::generateWatchDataAndSleep);
	}
}
