package com.ex.microservices.lab.persistence.repository;

import com.ex.microservices.lab.persistence.entity.SmartWatch;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SmartWatchRepository extends MongoRepository<SmartWatch,String> {
	Optional<List<SmartWatch>> getAllByDate(Long date);
}
