package com.ex.microservices.lab.persistence.repository;

import com.ex.microservices.lab.persistence.entity.CarData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarDataRepository extends MongoRepository<CarData,String> {

}
