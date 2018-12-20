package com.ex.microservices.lab.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "car_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarData {
	@Id
	public String id;
}
