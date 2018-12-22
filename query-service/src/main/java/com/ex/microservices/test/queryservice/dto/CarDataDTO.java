package com.ex.microservices.test.queryservice.dto;

import com.ex.microservices.test.queryservice.entity.CarData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarDataDTO {
	private Double rpm;
	private Double speed;
	private Double fuelLeft;
	private Long date;
	private String userUUID;
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
