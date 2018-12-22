package com.ex.microservices.test.queryservice.repository;

import com.ex.microservices.test.queryservice.entity.CarData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CarDataRepository extends MongoRepository<CarData,String> {
	Optional<List<CarData>> getAllByDate(Long date);
}
