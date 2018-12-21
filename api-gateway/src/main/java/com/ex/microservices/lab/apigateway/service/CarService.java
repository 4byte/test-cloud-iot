package com.ex.microservices.lab.apigateway.service;

import com.ex.microservices.lab.apigateway.config.CarDataProcessor;
import com.ex.microservices.lab.apigateway.dto.CarDataDTO;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.config.EnablePublisher;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(CarDataProcessor.class)
@EnablePublisher(CarDataProcessor.CAR_DATA)
public class CarService {



	@SendTo(CarDataProcessor.CAR_DATA)
	public Integer publishCar(CarDataDTO carDataDTO){
		return 1;
	}

}
