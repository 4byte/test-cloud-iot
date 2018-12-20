package com.ex.microservices.lab.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;

@Document(collection = "car_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarData {
	@Id
	public String id;
	public Double rpm;
	public Double speed;
	@Field("fuel_left")
	public Double fuelLeft;
	public Long date;
	@Field("user_uuid")
	public String userUUID;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CarData)) return false;
		CarData carData = (CarData) o;
		return Objects.equals(getId(), carData.getId()) &&
				Objects.equals(getRpm(), carData.getRpm()) &&
				Objects.equals(getSpeed(), carData.getSpeed()) &&
				Objects.equals(getFuelLeft(), carData.getFuelLeft()) &&
				Objects.equals(getDate(), carData.getDate()) &&
				Objects.equals(getUserUUID(), carData.getUserUUID());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getRpm(), getSpeed(), getFuelLeft(), getDate(), getUserUUID());
	}
}
