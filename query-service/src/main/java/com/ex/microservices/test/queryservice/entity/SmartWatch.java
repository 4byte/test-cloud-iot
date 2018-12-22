package com.ex.microservices.test.queryservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;

@Document(collection = "smart_watch")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmartWatch {
	@Id
	public String id;
	@Field("heart_rate")
	public Double heartRate;
	@Field("charge_left")
	public Double chargeLeft;
	public Long date;
	@Field("user_uuid")
	public String userUUID;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof SmartWatch)) return false;
		SmartWatch that = (SmartWatch) o;
		return Objects.equals(getId(), that.getId()) &&
				Objects.equals(getHeartRate(), that.getHeartRate()) &&
				Objects.equals(getChargeLeft(), that.getChargeLeft()) &&
				Objects.equals(getDate(), that.getDate()) &&
				Objects.equals(getUserUUID(), that.getUserUUID());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getHeartRate(), getChargeLeft(), getDate(), getUserUUID());
	}
}
