package com.ex.microservices.test.apigateway.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Objects;

@Data
public class SmartWatchDTO {
	public Double heartRate;
	public Double chargeLeft;
	public Long date;
	public String userUUID;
	@JsonIgnore

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof SmartWatchDTO)) return false;
		SmartWatchDTO that = (SmartWatchDTO) o;
		return Objects.equals(getHeartRate(), that.getHeartRate()) &&
				Objects.equals(getChargeLeft(), that.getChargeLeft()) &&
				Objects.equals(getDate(), that.getDate()) &&
				Objects.equals(getUserUUID(), that.getUserUUID());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getHeartRate(), getChargeLeft(), getDate(), getUserUUID());
	}
}
