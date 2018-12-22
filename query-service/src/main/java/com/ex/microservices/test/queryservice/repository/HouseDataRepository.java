package com.ex.microservices.test.queryservice.repository;

import com.ex.microservices.test.queryservice.entity.HouseData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface HouseDataRepository extends MongoRepository<HouseData,String> {
	Optional<List<HouseData>> getAllByDate(Long date, Pageable pageable);
	Optional<List<HouseData>> getAllByUserUUID(String userUUID, Pageable pageable);
}
