package com.ex.microservices.lab.persistence.repository;

import com.ex.microservices.lab.persistence.entity.SmartWatch;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SmartWatchRepository extends MongoRepository<SmartWatch,String> {

}
