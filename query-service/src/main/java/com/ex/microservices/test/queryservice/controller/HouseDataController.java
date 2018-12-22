package com.ex.microservices.test.queryservice.controller;


import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@Component
@RestController
@RequestMapping("/statistics/house")
public class HouseDataController {
}
