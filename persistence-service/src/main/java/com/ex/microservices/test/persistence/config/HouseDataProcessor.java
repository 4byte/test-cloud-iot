package com.ex.microservices.test.persistence.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

@EnableBinding
public interface HouseDataProcessor {

	String HOUSE_DATA = "house_data";

	@Input(HouseDataProcessor.HOUSE_DATA)
	SubscribableChannel inputHouseData();
}
