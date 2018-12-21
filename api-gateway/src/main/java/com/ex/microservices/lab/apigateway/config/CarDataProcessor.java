package com.ex.microservices.lab.apigateway.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

@EnableBinding
public interface CarDataProcessor {
	String CAR_DATA = "car_data";

	@Output(CarDataProcessor.CAR_DATA)
	MessageChannel output();
}
