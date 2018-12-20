package com.ex.microservices.lab.persistence.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;

@EnableBinding
public interface SmartWatchProcessor extends Processor {
	String INPUT = "input";
	String WORDS = "words";

	@Input(SmartWatchProcessor.WORDS)
	SubscribableChannel input();

	@Input(SmartWatchProcessor.INPUT)
	SubscribableChannel myInput();
}
