package com.ex.microservices.lab.apigateway.controller;

import com.ex.microservices.lab.apigateway.config.HouseDataSource;
import com.ex.microservices.lab.apigateway.dto.HouseDataDTO;
import com.ex.microservices.lab.apigateway.service.HouseDataQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@EnableBinding(HouseDataSource.class)
@RefreshScope
@Component
@RestController
@RequestMapping("/house")
public class HouseDataController {

	@Autowired
	HouseDataQueueService houseDataQueueService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity insertHouse(@RequestBody HouseDataDTO houseDataDTO){
		houseDataQueueService.publishHouse(houseDataDTO);
		return new ResponseEntity(HttpStatus.OK);
	}
}
