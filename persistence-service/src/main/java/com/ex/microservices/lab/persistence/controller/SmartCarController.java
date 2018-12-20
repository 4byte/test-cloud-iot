package com.ex.microservices.lab.persistence.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@Controller
@RequestMapping("/")
public class SmartCarController {

	@RequestMapping("cars/data/rpm")
	@ResponseBody
	public String helloGet(@PathVariable String name) {
		return "Hello";
	}
}
