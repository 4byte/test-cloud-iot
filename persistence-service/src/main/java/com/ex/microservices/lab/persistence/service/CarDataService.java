package com.ex.microservices.lab.persistence.service;

import com.ex.microservices.lab.persistence.config.CarDataProcessor;
import com.ex.microservices.lab.persistence.dto.CarDataDTO;
import com.ex.microservices.lab.persistence.repository.CarDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(CarDataProcessor.class)
public class CarDataService {
	@Autowired
	private CarDataRepository carDataRepository;

	@StreamListener(CarDataProcessor.CAR_DATA)
	public void listen(CarDataDTO carDataDTO) {
		carDataRepository.save(carDataDTO.toCarData());
		System.out.println(carDataDTO);
	}
}
