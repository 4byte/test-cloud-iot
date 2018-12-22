package com.ex.microservices.test.queryservice.controller;


import com.ex.microservices.test.queryservice.service.CarDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RefreshScope
@Component
@RestController
@RequestMapping("/statistics/car")
public class CarDataController {
	@Autowired
	CarDataService carDataService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity getCarInfoAll() {

		return new ResponseEntity(HttpStatus.OK);
	}
}
