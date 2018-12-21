package com.ex.microservices.lab.persistence.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

@EnableBinding
public interface SmartWatchProcessor{
	String CAR_DATA = "car_data";
	String HOUSE_DATA = "house_data";
	String SMART_WATCH = "smart_watch";

	@Input(SmartWatchProcessor.CAR_DATA)
	SubscribableChannel inputCarData();

	@Input(SmartWatchProcessor.HOUSE_DATA)
	SubscribableChannel inputHouseData();

	@Input(SmartWatchProcessor.SMART_WATCH)
	SubscribableChannel inputSmartWatch();
}
