package com.ex.microservices.lab.persistence.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface HouseDataProcessor {

	String HOUSE_DATA = "house_data";

	@Input(HouseDataProcessor.HOUSE_DATA)
	SubscribableChannel inputHouseData();
}
