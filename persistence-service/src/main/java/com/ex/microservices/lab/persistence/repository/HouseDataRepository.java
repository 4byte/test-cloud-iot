package com.ex.microservices.lab.persistence.repository;

import com.ex.microservices.lab.persistence.entity.HouseData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HouseDataRepository extends MongoRepository<HouseData,String> {

}
