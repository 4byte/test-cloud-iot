package com.ex.microservices.lab.persistence.config;

import org.springframework.cloud.stream.annotation.*;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

@EnableBinding
public interface SmartWatchProcessor {
		String INPUT = "smart_watch";

		@Input
		SubscribableChannel myInput();

		@Output("myOutput")
		MessageChannel anOutput();

		@Output
		MessageChannel anotherOutput();
}
