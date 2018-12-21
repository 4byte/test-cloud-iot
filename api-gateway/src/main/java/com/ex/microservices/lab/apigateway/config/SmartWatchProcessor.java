package com.ex.microservices.lab.apigateway.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

@EnableBinding
public interface SmartWatchProcessor{

	String SMART_WATCH = "smart_watch";

	@Output(SmartWatchProcessor.SMART_WATCH)
	MessageChannel outputSmartWatch();
}
