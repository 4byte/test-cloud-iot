package com.ex.microservices.test.apigateway.controller;

import com.ex.microservices.test.apigateway.config.SmartWatchSource;
import com.ex.microservices.test.apigateway.dto.SmartWatchDTO;
import com.ex.microservices.test.apigateway.service.WatchDataQueueService;
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

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity insertWatch(@RequestBody SmartWatchDTO smartWatchDTO){
		watchDataQueueService.publishWatch(smartWatchDTO);
		return new ResponseEntity(HttpStatus.OK);
	}
}
