package com.ex.microservices.test.persistence.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

@EnableBinding
public interface SmartWatchProcessor{

	String SMART_WATCH = "smart_watch";

	@Input(SmartWatchProcessor.SMART_WATCH)
	SubscribableChannel inputSmartWatch();
}
