package com.ex.microservices.lab.statistics.statisticsservice.contoller;

import com.ex.microservices.lab.statistics.statisticsservice.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RefreshScope
@Component
@Controller
@RequestMapping("/")
public class NameController  {
	@Autowired
	NameService nameService;

	@RequestMapping("names")
	@ResponseBody
	public String processNameFromQueue() {
		StringBuilder stringBuilder = new StringBuilder();
		nameService.getNamesMap().forEach((k,v) -> {
			stringBuilder.append(k);
			stringBuilder.append(" ");
			stringBuilder.append(v);
			stringBuilder.append('\n');
		});
		return stringBuilder.toString();
	}
}
