package com.ex.microservices.lab.persistence.repository;

import com.ex.microservices.lab.persistence.entity.HouseData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface HouseDataRepository extends MongoRepository<HouseData,String> {
	Optional<List<HouseData>> getAllByDate(Long date);
}
