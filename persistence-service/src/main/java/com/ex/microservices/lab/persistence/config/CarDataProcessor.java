package com.ex.microservices.lab.persistence.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

@EnableBinding
public interface CarDataProcessor {
	String CAR_DATA = "car_data";

	@Input(CarDataProcessor.CAR_DATA)
	SubscribableChannel inputCarData();
}
