package com.ex.microservices.lab.persistence.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;

@EnableBinding
public interface SmartWatchProcessor{
	String WORDS = "words";

	@Input("words")
	SubscribableChannel input();
//
//	@Input(Sink.INPUT)
//	SubscribableChannel myInput();
}
