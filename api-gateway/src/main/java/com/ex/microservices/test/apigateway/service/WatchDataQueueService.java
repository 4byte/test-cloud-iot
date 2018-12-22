package com.ex.microservices.test.apigateway.service;

import com.ex.microservices.test.apigateway.config.SmartWatchSource;
import com.ex.microservices.test.apigateway.dto.SmartWatchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(SmartWatchSource.class)
public class WatchDataQueueService {
	@Autowired
	private SmartWatchSource source;

	@SendTo(SmartWatchSource.OUTPUT)
	public void publishWatch(SmartWatchDTO smartWatchDTO){
		source.output().send(new GenericMessage<>(smartWatchDTO));
	}
}
