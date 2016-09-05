package com.radicalninja.transitserve.data.db;

import com.radicalninja.transitserve.data.model.Stop;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StopRepository extends MongoRepository<Stop, Integer> {

    // TODO: Train / bus CRUD methods here.

}
