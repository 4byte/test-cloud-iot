package com.ex.microservices.test.generator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class HouseDataDTO {
	public Double thermostatTemp;
	public Double mainRoomTemp;
	public Double bedroomTemp;
	public Double fridgeTemp;
	public Long date;
	public String userUUID;


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof HouseDataDTO)) return false;
		HouseDataDTO that = (HouseDataDTO) o;
		return Objects.equals(getThermostatTemp(), that.getThermostatTemp()) &&
				Objects.equals(getMainRoomTemp(), that.getMainRoomTemp()) &&
				Objects.equals(getBedroomTemp(), that.getBedroomTemp()) &&
				Objects.equals(getFridgeTemp(), that.getFridgeTemp()) &&
				Objects.equals(getDate(), that.getDate()) &&
				Objects.equals(getUserUUID(), that.getUserUUID());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getThermostatTemp(), getMainRoomTemp(), getBedroomTemp(), getFridgeTemp(), getDate(), getUserUUID());
	}
}
