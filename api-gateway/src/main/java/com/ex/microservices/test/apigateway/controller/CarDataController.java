package com.ex.microservices.test.apigateway.controller;

import com.ex.microservices.test.apigateway.config.CarDataSource;
import com.ex.microservices.test.apigateway.dto.CarDataDTO;
import com.ex.microservices.test.apigateway.service.CarDataQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@EnableBinding(CarDataSource.class)
@RefreshScope
@Component
@RestController
@RequestMapping("/car")
public class CarDataController {

	@Autowired
	CarDataQueueService carDataQueueService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity insertCar(@RequestBody CarDataDTO carDataDTO) {
		carDataQueueService.publishCar(carDataDTO);
		return new ResponseEntity(HttpStatus.OK);
	}
}
