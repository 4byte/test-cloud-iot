package com.ex.microservices.test.queryservice.service;

import com.ex.microservices.test.queryservice.entity.CarData;
import com.ex.microservices.test.queryservice.repository.CarDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToDoubleFunction;

@Service
public class CarDataService {
	@Autowired
	CarDataRepository carDataRepository;

	public List<CarData> getAll() {
		return carDataRepository.findAll(PageRequest.of(0, 1000000)).getContent();
	}

	private Double getAverageOfAllDoubleValue(ToDoubleFunction<CarData> toDoubleFunction) {
		return carDataRepository.findAll(PageRequest.of(0, 1000000)).getContent().stream()
				.mapToDouble(toDoubleFunction)
				.average()
				.orElse(0d);
	}

	private CarData getMaxValue(ToDoubleFunction<CarData> toDoubleFunction) {
		return carDataRepository.findAll(PageRequest.of(0, 1000000)).getContent().stream()
				.max(Comparator.comparingDouble(toDoubleFunction))
				.orElse(new CarData());
	}

	private CarData getMinValueFromDate(long date, ToDoubleFunction<CarData> toDoubleFunctio) {
		return carDataRepository.getAllByDate(date, PageRequest.of(0, 1000000)).orElse(new ArrayList<>()).stream()
				.min(Comparator.comparingDouble(CarData::getRpm))
				.orElse(new CarData());
	}

	public List<CarData> getAllByUserUUID(String uuid) {
		return carDataRepository.getAllByUserUUID(uuid, PageRequest.of(0, 1000000)).orElse(new ArrayList<>());
	}

	public Double getAverageOfAllRpm() {
		return getAverageOfAllDoubleValue(CarData::getRpm);
	}

	public Double getAverageOfAllSpeed() {
		return getAverageOfAllDoubleValue(CarData::getSpeed);
	}

	public Double getAverageOfAllFuelLeft() {
		return getAverageOfAllDoubleValue(CarData::getFuelLeft);
	}

	public CarData getMaxRpm() {
		return getMaxValue(CarData::getRpm);
	}

	public CarData getMaxRpmFromDate(long date) {
		return getMaxValue(CarData::getRpm);
	}

	public CarData getMinRpmFromDate(long date) {
		return getMinValueFromDate(date, CarData::getRpm);
	}

	public Double getAverageRpmFromDate(long date) {
		return carDataRepository.getAllByDate(date, PageRequest.of(0, 1000000)).orElse(new ArrayList<>()).stream()
				.mapToDouble(CarData::getRpm)
				.average()
				.orElse(0d);
	}
}
