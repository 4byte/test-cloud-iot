package com.ex.microservices.lab.persistence.service;

import com.ex.microservices.lab.persistence.config.HouseDataProcessor;
import com.ex.microservices.lab.persistence.dto.HouseDataDTO;
import com.ex.microservices.lab.persistence.repository.HouseDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(HouseDataProcessor.class)
public class HouseDataService {
	@Autowired
	private HouseDataRepository houseDataRepository;

	@StreamListener(HouseDataProcessor.HOUSE_DATA)
	public void listen(HouseDataDTO houseDataDTO) {
		houseDataRepository.save(houseDataDTO.toHouseData());
		System.out.println(houseDataDTO);
	}

}
