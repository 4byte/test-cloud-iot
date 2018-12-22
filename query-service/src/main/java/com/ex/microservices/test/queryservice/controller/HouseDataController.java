package com.ex.microservices.test.queryservice.controller;


import com.ex.microservices.test.queryservice.dto.HouseDataDTO;
import com.ex.microservices.test.queryservice.entity.HouseData;
import com.ex.microservices.test.queryservice.service.HouseDataService;
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
@RequestMapping("/statistics/house")
public class HouseDataController {
	@Autowired
	HouseDataService houseDataService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<HouseDataDTO>> getAllHouseInfo() {
		return new ResponseEntity<>(
				houseDataService.getAll().stream().map(HouseData::toDTO).collect(Collectors.toList())
				, HttpStatus.OK);
	}

	@RequestMapping(value = "/my", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<HouseDataDTO>> getAllByUserUUID(@PathVariable String uuid) {
		return new ResponseEntity<>(houseDataService.getAllByUserUUID(uuid)
				.stream().map(HouseData::toDTO).collect(Collectors.toList())
				,HttpStatus.OK);
	}

	@RequestMapping(value = "/average/thermostat", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Double> getAverageOfAllThermostatTemp() {
		return new ResponseEntity<>(houseDataService.getAverageOfAllThermostatTemp(),HttpStatus.OK);
	}
	@RequestMapping(value = "/average/mainRoom", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Double> getAverageOfAllMainRoomTemp() {
		return new ResponseEntity<>(houseDataService.getAverageOfAllMainRoomTemp(),HttpStatus.OK);
	}
	@RequestMapping(value = "/average/bedroom", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Double> getAverageOfAllBedroomTemp() {
		return new ResponseEntity<>(houseDataService.getAverageOfAllBedroomTemp(),HttpStatus.OK);
	}
	@RequestMapping(value = "/average/fridge", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Double> getAverageOfAllFridgeTemp() {
		return new ResponseEntity<>(houseDataService.getAverageOfAllFridgeTemp(),HttpStatus.OK);
	}
	@RequestMapping(value = "/max/thermostat", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HouseDataDTO> getMaxThermostatTempOfAll() {
		return new ResponseEntity<>(houseDataService.getMaxThermostatTempOfAll().toDTO(),HttpStatus.OK);
	}
	@RequestMapping(value = "/max/mainRoom", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HouseDataDTO> getMaxMainRoomTempOfAll() {
		return new ResponseEntity<>(houseDataService.getMaxMainRoomTempOfAll().toDTO(),HttpStatus.OK);
	}
	@RequestMapping(value = "/max/bedroom", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HouseDataDTO> getMaxBedroomTempOfAll() {
		return new ResponseEntity<>(houseDataService.getMaxBedroomTempOfAll().toDTO(),HttpStatus.OK);
	}
	@RequestMapping(value = "/max/fridge", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HouseDataDTO> getMaxFridgeTempOfAll() {
		return new ResponseEntity<>(houseDataService.getMaxFridgeTempOfAll().toDTO(),HttpStatus.OK);
	}
	@RequestMapping(value = "/min/thermostat", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HouseDataDTO> getMinThermostatTempOfAll() {
		return new ResponseEntity<>(houseDataService.getMinThermostatTempOfAll().toDTO(),HttpStatus.OK);
	}
	@RequestMapping(value = "/min/mainRoom", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HouseDataDTO> getMinMainRoomTempOfAll() {
		return new ResponseEntity<>(houseDataService.getMinMainRoomTempOfAll().toDTO(),HttpStatus.OK);
	}
	@RequestMapping(value = "/min/bedroom", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HouseDataDTO> getMinBedroomTempOfAll() {
		return new ResponseEntity<>(houseDataService.getMinBedroomTempOfAll().toDTO(),HttpStatus.OK);
	}
	@RequestMapping(value = "/min/fridge", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HouseDataDTO> getMinFridgeTempOfAll() {
		return new ResponseEntity<>(houseDataService.getMinFridgeTempOfAll().toDTO(),HttpStatus.OK);
	}
}
