package com.ex.microservices.lab.persistence.service;

import com.ex.microservices.lab.persistence.config.HouseDataProcessor;
import com.ex.microservices.lab.persistence.dto.HouseDataDTO;
import com.ex.microservices.lab.persistence.entity.HouseData;
import com.ex.microservices.lab.persistence.repository.HouseDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@EnableBinding(HouseDataProcessor.class)
public class HouseDataService {
	@Autowired
	private HouseDataRepository houseDataRepository;
	Logger logger = LoggerFactory.getLogger(HouseDataService.class);

	@StreamListener(HouseDataProcessor.HOUSE_DATA)
	public void listen(HouseDataDTO houseDataDTO) {
		boolean duplicateFound = houseDataRepository.getAllByDate(houseDataDTO.getDate()).orElse(new ArrayList<>())
				.stream()
				.map(HouseData::getDate)
				.anyMatch(houseDataDTO.toHouseData().getDate()::equals);
		if (!duplicateFound) houseDataRepository.save(houseDataDTO.toHouseData());
		else logger.warn("Duplicate by time found");
	}

}
