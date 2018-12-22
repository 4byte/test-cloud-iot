package com.ex.microservices.lab.persistence.service;

import com.ex.microservices.lab.persistence.config.CarDataProcessor;
import com.ex.microservices.lab.persistence.dto.CarDataDTO;
import com.ex.microservices.lab.persistence.entity.CarData;
import com.ex.microservices.lab.persistence.repository.CarDataRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@EnableBinding(CarDataProcessor.class)
public class CarDataService {
	@Autowired
	private CarDataRepository carDataRepository;
	Logger logger = LoggerFactory.getLogger(CarDataService.class);


	@StreamListener(CarDataProcessor.CAR_DATA)
	public void listen(CarDataDTO carDataDTO) {
		boolean duplicateFound = carDataRepository.getAllByDate(carDataDTO.getDate()).orElse(new ArrayList<>())
				.stream()
				.map(CarData::getDate)
				.anyMatch(carDataDTO.getDate()::equals);
		if (!duplicateFound) carDataRepository.save(carDataDTO.toCarData());
		else logger.warn("Duplicate by time found");
	}
}
