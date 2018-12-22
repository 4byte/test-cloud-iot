package com.ex.microservices.test.apigateway.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface HouseDataSource {
	String OUTPUT = "house_data";

	@Output(HouseDataSource.OUTPUT)
	MessageChannel output();
}
