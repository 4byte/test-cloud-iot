package com.ex.microservices.lab.apigateway.controller;

import com.ex.microservices.lab.apigateway.config.SmartWatchSource;
import com.ex.microservices.lab.apigateway.dto.SmartWatchDTO;
import com.ex.microservices.lab.apigateway.service.WatchDataQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@EnableBinding(SmartWatchSource.class)
@RefreshScope
@Component
@RestController
@RequestMapping("/watch")
public class WatchDataController {
	@Autowired
	WatchDataQueueService watchDataQueueService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity insertWatch(@RequestBody SmartWatchDTO smartWatchDTO){
		watchDataQueueService.publishHouse(smartWatchDTO);
		return new ResponseEntity(HttpStatus.OK);
	}
}
