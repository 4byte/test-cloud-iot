package com.ex.microservices.test.queryservice.controller;


import com.ex.microservices.test.queryservice.dto.CarDataDTO;
import com.ex.microservices.test.queryservice.entity.CarData;
import com.ex.microservices.test.queryservice.service.CarDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RefreshScope
@Component
@RestController
@RequestMapping("/statistics/car")
public class CarDataController {
	@Autowired
	CarDataService carDataService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<CarDataDTO>> getCarInfoAll() {
		return new ResponseEntity<>(
				carDataService.getAll().stream().map(CarData::toDTO).collect(Collectors.toList())
				,HttpStatus.OK);
	}

	@RequestMapping(value = "/average/rpm", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Double> getAverageRpm() {
		return new ResponseEntity<>(carDataService.getAverageOfAllRpm(),HttpStatus.OK);
	}

	@RequestMapping(value = "/my", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<CarDataDTO>> getMy(@PathVariable String uuid) {
		return new ResponseEntity<>(
				carDataService.getAllByUserUUID(uuid).stream().map(CarData::toDTO).collect(Collectors.toList())
				,HttpStatus.OK);
	}
	@RequestMapping(value = "/average/speed", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Double> getAverageOfSpeed() {
		return new ResponseEntity<>(carDataService.getAverageOfAllSpeed(),HttpStatus.OK);
	}
	@RequestMapping(value = "/average/fuel", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Double> getAverageOfFuelLeft() {
		return new ResponseEntity<>(carDataService.getAverageOfAllFuelLeft(),HttpStatus.OK);
	}
	@RequestMapping(value = "/max/rpm", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<CarDataDTO> getMaxRpm() {
		return new ResponseEntity<>(carDataService.getMaxRpm().toDTO(),HttpStatus.OK);
	}

	@RequestMapping(value = "/max/rpmFromDay", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<CarDataDTO> getMaxRpmFromDate(Long date) {
		return new ResponseEntity<>(carDataService.getMaxRpmFromDate(date).toDTO(),HttpStatus.OK);
	}
	@RequestMapping(value = "/min/rpmFromDay", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<CarDataDTO> getMinRpmFromDate(Long date) {
		return new ResponseEntity<>(carDataService.getMinRpmFromDate(date).toDTO(),HttpStatus.OK);
	}
	@RequestMapping(value = "/min/rpmFromDay", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<CarDataDTO> getMaxRpm(Long date) {
		return new ResponseEntity<>(carDataService.getMinRpmFromDate(date).toDTO(),HttpStatus.OK);
	}
	@RequestMapping(value = "/average/rpmFromDay", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Double> getAverageRpmFromDate(Long date) {
		return new ResponseEntity<>(carDataService.getAverageRpmFromDate(date),HttpStatus.OK);
	}


}
