package com.ex.microservices.test.queryservice.repository;

import com.ex.microservices.test.queryservice.entity.CarData;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CarDataRepository extends MongoRepository<CarData,String> {
	Optional<List<CarData>> getAllByDate(Long date, Pageable pageable);
	Optional<List<CarData>> getAllByUserUUID(String userUUID,Pageable pageable);
}
