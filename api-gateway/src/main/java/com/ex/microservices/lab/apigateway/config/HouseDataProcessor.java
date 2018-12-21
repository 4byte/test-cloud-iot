package com.ex.microservices.lab.apigateway.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
@EnableBinding
public interface HouseDataProcessor {

	String HOUSE_DATA = "house_data";

	@Output(HouseDataProcessor.HOUSE_DATA)
	MessageChannel outputHouseData();
}
