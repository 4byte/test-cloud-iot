package com.ex.microservices.lab.persistence.dto;

import com.ex.microservices.lab.persistence.entity.CarData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Objects;

@Data
public class CarDataDTO {
	public Double rpm;
	public Double speed;
	public Double fuelLeft;
	public Long date;
	public String userUUID;
	@JsonIgnore
	public CarData toCarData() {
		return new CarData(null, rpm, speed, fuelLeft, date, userUUID);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CarDataDTO)) return false;
		CarDataDTO that = (CarDataDTO) o;
		return Objects.equals(getRpm(), that.getRpm()) &&
				Objects.equals(getSpeed(), that.getSpeed()) &&
				Objects.equals(getFuelLeft(), that.getFuelLeft()) &&
				Objects.equals(getDate(), that.getDate()) &&
				Objects.equals(getUserUUID(), that.getUserUUID());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getRpm(), getSpeed(), getFuelLeft(), getDate(), getUserUUID());
	}
}
