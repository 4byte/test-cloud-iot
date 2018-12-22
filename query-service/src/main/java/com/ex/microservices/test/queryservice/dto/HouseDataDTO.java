package com.ex.microservices.test.queryservice.dto;

import com.ex.microservices.test.queryservice.entity.HouseData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Objects;

@Data
public class HouseDataDTO {
	private Double thermostatTemp;
	private Double mainRoomTemp;
	private Double bedroomTemp;
	private Double fridgeTemp;
	private Long date;
	private String userUUID;
	@JsonIgnore
	public HouseData toHouseData() {
		return new HouseData(null, thermostatTemp, mainRoomTemp, bedroomTemp, fridgeTemp, date, userUUID);
	}


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
