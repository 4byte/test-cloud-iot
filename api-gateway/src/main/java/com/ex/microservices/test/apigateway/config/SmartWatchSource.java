package com.ex.microservices.test.apigateway.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SmartWatchSource {
	String OUTPUT = "smart_watch";

	@Output(SmartWatchSource.OUTPUT)
	MessageChannel output();
}
