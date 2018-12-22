package com.ex.microservices.test.queryservice.service;

import com.ex.microservices.test.queryservice.entity.SmartWatch;
import com.ex.microservices.test.queryservice.repository.SmartWatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToDoubleFunction;

@Service
public class WatchDataService {
	@Autowired
	SmartWatchRepository smartWatchRepository;

	private SmartWatch getMaxDoubleValue(ToDoubleFunction<SmartWatch> toDoubleFunction) {
		return smartWatchRepository.findAll(PageRequest.of(0, 1000000)).getContent().stream()
				.max(Comparator.comparingDouble(toDoubleFunction))
				.orElse(new SmartWatch());
	}
	private SmartWatch getMinDoubleValue(ToDoubleFunction<SmartWatch> toDoubleFunction) {
		return smartWatchRepository.findAll(PageRequest.of(0, 1000000)).getContent().stream()
				.min(Comparator.comparingDouble(toDoubleFunction))
				.orElse(new SmartWatch());
	}
	private Double getAverageOfAll(ToDoubleFunction<SmartWatch> toDoubleFunction){
		return smartWatchRepository.findAll(PageRequest.of(0, 1000000)).getContent().stream()
				.mapToDouble(toDoubleFunction)
				.average()
				.orElse(0d);
	}
	public List<SmartWatch> getAll() {
		return smartWatchRepository.findAll(PageRequest.of(0, 1000000)).getContent();
	}
	public List<SmartWatch> getAllByUserUUID(String uuid) {
		return smartWatchRepository.getAllByUserUUID(uuid, PageRequest.of(0, 1000000)).orElse(new ArrayList<>());
	}
	public SmartWatch getMaxHeartRate(){
		return getMaxDoubleValue(SmartWatch::getHeartRate);
	}
	public SmartWatch getMaxChargeLeft(){
		return getMaxDoubleValue(SmartWatch::getChargeLeft);
	}
	public SmartWatch getMaxDate(){
		return getMaxDoubleValue(SmartWatch::getDate);
	}
	public SmartWatch getMinHeartRate(){
		return getMinDoubleValue(SmartWatch::getHeartRate);
	}
	public SmartWatch getMinChargeLeft(){
		return getMinDoubleValue(SmartWatch::getChargeLeft);
	}
	public SmartWatch getMinDate(){
		return getMaxDoubleValue(SmartWatch::getDate);
	}
	public Double getAverageHeartRate(){
		return getAverageOfAll(SmartWatch::getHeartRate);
	}
	public Double getAverageChargeLeft(){
		return getAverageOfAll(SmartWatch::getChargeLeft);
	}
}
