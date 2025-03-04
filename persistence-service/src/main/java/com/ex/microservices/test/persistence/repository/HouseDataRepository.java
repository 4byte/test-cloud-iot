package com.ex.microservices.test.persistence.repository;

import com.ex.microservices.test.persistence.entity.HouseData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface HouseDataRepository extends MongoRepository<HouseData,String> {
	Optional<List<HouseData>> getAllByDate(Long date);
}
