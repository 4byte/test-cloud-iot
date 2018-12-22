package com.ex.microservices.lab.apigateway.service;

import com.ex.microservices.lab.apigateway.config.CarDataSource;
import com.ex.microservices.lab.apigateway.dto.CarDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(CarDataSource.class)
public class CarDataQueueService {

	@Autowired
	private CarDataSource source;

	@SendTo(CarDataSource.OUTPUT)
	public void publishCar(CarDataDTO carDataDTO){
		source.output().send(new GenericMessage<>(carDataDTO));
	}

}
