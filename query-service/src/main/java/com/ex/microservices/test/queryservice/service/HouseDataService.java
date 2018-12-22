package com.ex.microservices.test.queryservice.service;

import com.ex.microservices.test.queryservice.entity.HouseData;
import com.ex.microservices.test.queryservice.repository.HouseDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToDoubleFunction;

@Service
public class HouseDataService {
	@Autowired
	HouseDataRepository houseDataRepository;

	private Double getAverageOfAllTemp(ToDoubleFunction<HouseData> toDoubleFunction){
		return houseDataRepository.findAll(PageRequest.of(0, 1000000)).getContent().stream()
				.mapToDouble(toDoubleFunction)
				.average()
				.orElse(0d);
	}

	private HouseData getMaxDoubleValue(ToDoubleFunction<HouseData> toDoubleFunction) {
		return houseDataRepository.findAll(PageRequest.of(0, 1000000)).getContent().stream()
				.max(Comparator.comparingDouble(toDoubleFunction))
				.orElse(new HouseData());
	}
	private HouseData getMinDoubleValue(ToDoubleFunction<HouseData> toDoubleFunction) {
		return houseDataRepository.findAll(PageRequest.of(0, 1000000)).getContent().stream()
				.min(Comparator.comparingDouble(toDoubleFunction))
				.orElse(new HouseData());
	}
	public List<HouseData> getAll() {
		return houseDataRepository.findAll(PageRequest.of(0, 1000000)).getContent();
	}

	public List<HouseData> getAllByUserUUID(String uuid) {
		return houseDataRepository.getAllByUserUUID(uuid, PageRequest.of(0, 1000000)).orElse(new ArrayList<>());
	}
	public Double getAverageOfAllThermostatTemp(){
		return getAverageOfAllTemp(HouseData::getThermostatTemp);
	}

	public Double getAverageOfAllMainRoomTemp(){
		return getAverageOfAllTemp(HouseData::getMainRoomTemp);
	}

	public Double getAverageOfAllBedroomTemp(){
		return getAverageOfAllTemp(HouseData::getBedroomTemp);
	}
	public Double getAverageOfAllFridgeTemp(){
		return getAverageOfAllTemp(HouseData::getFridgeTemp);
	}
	public HouseData getMaxThermostatTempOfAll(){
		return getMaxDoubleValue(HouseData::getThermostatTemp);
	}
	public HouseData getMaxMainRoomTempOfAll(){
		return getMaxDoubleValue(HouseData::getMainRoomTemp);
	}
	public HouseData getMaxBedroomTempOfAll(){
		return getMaxDoubleValue(HouseData::getBedroomTemp);
	}
	public HouseData getMaxFridgeTempOfAll(){
		return getMaxDoubleValue(HouseData::getFridgeTemp);
	}
	public HouseData getMinThermostatTempOfAll(){
		return getMinDoubleValue(HouseData::getThermostatTemp);
	}
	public HouseData getMinMainRoomTempOfAll(){
		return getMinDoubleValue(HouseData::getMainRoomTemp);
	}
	public HouseData getMinBedroomTempOfAll(){
		return getMinDoubleValue(HouseData::getBedroomTemp);
	}
	public HouseData getMinFridgeTempOfAll(){
		return getMinDoubleValue(HouseData::getFridgeTemp);
	}
}
