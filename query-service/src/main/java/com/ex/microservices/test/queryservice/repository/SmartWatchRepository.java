package com.ex.microservices.test.queryservice.repository;

import com.ex.microservices.test.queryservice.entity.SmartWatch;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SmartWatchRepository extends MongoRepository<SmartWatch,String> {
	Optional<List<SmartWatch>> getAllByDate(Long date, Pageable pageable);
	Optional<List<SmartWatch>> getAllByUserUUID(String  userUUID, Pageable pageable);
}
