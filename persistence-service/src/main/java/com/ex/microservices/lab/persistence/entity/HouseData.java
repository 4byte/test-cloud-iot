package com.ex.microservices.lab.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;

@Document(collection = "house_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseData {
	@Id
	public String id;
	@Field("thermostat_temp")
	public Double thermostatTemp;
	@Field("main_room_temp")
	public Double mainRoomTemp;
	@Field("bedroom_temp")
	public Double bedroomTemp;
	@Field("fridge_temp")
	public Double fridgeTemp;
	public Long date;
	@Field("user_uuid")
	public String userUUID;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof HouseData)) return false;
		HouseData houseData = (HouseData) o;
		return Objects.equals(getId(), houseData.getId()) &&
				Objects.equals(getThermostatTemp(), houseData.getThermostatTemp()) &&
				Objects.equals(getMainRoomTemp(), houseData.getMainRoomTemp()) &&
				Objects.equals(getBedroomTemp(), houseData.getBedroomTemp()) &&
				Objects.equals(getFridgeTemp(), houseData.getFridgeTemp()) &&
				Objects.equals(getDate(), houseData.getDate()) &&
				Objects.equals(getUserUUID(), houseData.getUserUUID());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getThermostatTemp(), getMainRoomTemp(), getBedroomTemp(), getFridgeTemp(), getDate(), getUserUUID());
	}
}
