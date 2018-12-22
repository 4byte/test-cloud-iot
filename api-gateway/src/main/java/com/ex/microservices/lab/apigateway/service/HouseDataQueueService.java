package com.ex.microservices.lab.apigateway.service;

import com.ex.microservices.lab.apigateway.config.CarDataSource;
import com.ex.microservices.lab.apigateway.config.HouseDataSource;
import com.ex.microservices.lab.apigateway.dto.CarDataDTO;
import com.ex.microservices.lab.apigateway.dto.HouseDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(HouseDataSource.class)
public class HouseDataQueueService {
	@Autowired
	private HouseDataSource source;

	@SendTo(HouseDataSource.OUTPUT)
	public void publishHouse(HouseDataDTO houseDataDTO){
		source.output().send(new GenericMessage<>(houseDataDTO));
	}
}
