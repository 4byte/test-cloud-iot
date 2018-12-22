package com.ex.microservices.test.queryservice.controller;

import com.ex.microservices.test.queryservice.dto.SmartWatchDTO;
import com.ex.microservices.test.queryservice.entity.SmartWatch;
import com.ex.microservices.test.queryservice.service.WatchDataService;
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
@RequestMapping("/statistics/smart_watch")
public class SmartWatchController {
	@Autowired
	WatchDataService watchDataService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<SmartWatchDTO>> getAll() {
		return new ResponseEntity<>(
				watchDataService.getAll().stream().map(SmartWatch::toDTO).collect(Collectors.toList())
				, HttpStatus.OK);
	}
	@RequestMapping(value = "/my", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<SmartWatchDTO>> getMy(@PathVariable String uuid) {
		return new ResponseEntity<>(
				watchDataService.getAllByUserUUID(uuid).stream().map(SmartWatch::toDTO).collect(Collectors.toList())
				,HttpStatus.OK);
	}
	@RequestMapping(value = "/max/heartRate", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<SmartWatchDTO> getMaxHeartRate() {
		return new ResponseEntity<>(watchDataService.getMaxHeartRate().toDTO(),HttpStatus.OK);
	}
	@RequestMapping(value = "/max/chargeLeft", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<SmartWatchDTO> getMaxChargeLeft() {
		return new ResponseEntity<>(watchDataService.getMaxChargeLeft().toDTO(),HttpStatus.OK);
	}
	@RequestMapping(value = "/max/date", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<SmartWatchDTO> getMaxDate() {
		return new ResponseEntity<>(watchDataService.getMaxDate().toDTO(),HttpStatus.OK);
	}
	@RequestMapping(value = "/min/heartRate", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<SmartWatchDTO> getMinHeartRate() {
		return new ResponseEntity<>(watchDataService.getMinHeartRate().toDTO(),HttpStatus.OK);
	}
	@RequestMapping(value = "/min/chargeLeft", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<SmartWatchDTO> getMinChargeLeft() {
		return new ResponseEntity<>(watchDataService.getMinChargeLeft().toDTO(),HttpStatus.OK);
	}
	@RequestMapping(value = "/min/date", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<SmartWatchDTO> getMinDate() {
		return new ResponseEntity<>(watchDataService.getMinDate().toDTO(),HttpStatus.OK);
	}
	@RequestMapping(value = "/average/heatRate", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Double> getAverageHeartRate() {
		return new ResponseEntity<>(watchDataService.getAverageHeartRate(),HttpStatus.OK);
	}
	@RequestMapping(value = "/average/chargeLeft", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Double> getAverageChargeLeft() {
		return new ResponseEntity<>(watchDataService.getAverageChargeLeft(),HttpStatus.OK);
	}
}
