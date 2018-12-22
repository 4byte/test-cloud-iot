package com.ex.microservices.test.persistence.service;

import com.ex.microservices.test.persistence.config.SmartWatchProcessor;
import com.ex.microservices.test.persistence.dto.SmartWatchDTO;
import com.ex.microservices.test.persistence.entity.SmartWatch;
import com.ex.microservices.test.persistence.repository.SmartWatchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@EnableBinding(SmartWatchProcessor.class)
public class SmartWatchService {
	@Autowired
	private SmartWatchRepository smartWatchRepository;
	Logger logger = LoggerFactory.getLogger(SmartWatchService.class);

	@StreamListener(SmartWatchProcessor.SMART_WATCH)
	public void listen(SmartWatchDTO smartWatchDTO) {
		boolean duplicateFound = smartWatchRepository.getAllByDate(smartWatchDTO.getDate()).orElse(new ArrayList<>())
				.stream()
				.map(SmartWatch::getDate)
				.anyMatch(smartWatchDTO.toSmartWatch().getDate()::equals);
		if (!duplicateFound) smartWatchRepository.save(smartWatchDTO.toSmartWatch());
		else logger.warn("Duplicate by time found");
	}
}
