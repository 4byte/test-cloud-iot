package com.ex.microservices.lab.apigateway.controller;

import com.ex.microservices.lab.apigateway.config.CarDataProcessor;
import com.ex.microservices.lab.apigateway.dto.CarDataDTO;
import com.ex.microservices.lab.apigateway.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@EnableBinding(CarDataProcessor.class)
@RefreshScope
@Component
@RestController
@RequestMapping("/car")
public class CarDataController {
//	@Autowired
//	private Processor processor;\
	@Autowired
	CarService carService;


//	@RequestMapping(value = "", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity insertCar(@RequestBody CarDataDTO carDataDTO) {
//		publishCar(carDataDTO);
//		return new ResponseEntity(HttpStatus.OK);
//	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity insertCar() {
//		publishCar(new CarDataDTO());
		carService.publishCar(new CarDataDTO());
		return new ResponseEntity(HttpStatus.OK);
	}

	@SendTo(CarDataProcessor.CAR_DATA)
	public Integer publishCar(CarDataDTO carDataDTO){
		return 1;
	}
}
