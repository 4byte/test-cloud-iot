package com.ex.microservices.lab.apigateway.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CarDataSource {
	String OUTPUT = "car_data";

	@Output(CarDataSource.OUTPUT)
	MessageChannel output();
}
