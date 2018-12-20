package com.ex.microservices.lab.helloservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableBinding(Source.class)
@RefreshScope
@Component
@Controller
@RequestMapping("/")
public class HelloController {


	@Value("${params.hello}")
	private String value;

	@Autowired
	private Source source;

	@RequestMapping("hello/{name}")
	@ResponseBody
	public String helloGet(@PathVariable String name) {
		pushNameToQueue(name);
		return "Hello " + name+ " number is: "+value;
	}

	@SendTo(Source.OUTPUT)
	public void pushNameToQueue(String name){
		source.output().send(new GenericMessage<>(name));
	}
}
