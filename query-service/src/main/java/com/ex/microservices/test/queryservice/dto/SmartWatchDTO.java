package com.ex.microservices.test.queryservice.dto;

import com.ex.microservices.test.queryservice.entity.SmartWatch;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Objects;

@Data
public class SmartWatchDTO {
	private Double heartRate;
	private Double chargeLeft;
	private Long date;
	private String userUUID;
	@JsonIgnore
	public SmartWatch toSmartWatch() {
		return new SmartWatch(null, heartRate, chargeLeft, date, userUUID);
	}

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
