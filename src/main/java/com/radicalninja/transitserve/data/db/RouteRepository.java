package com.radicalninja.transitserve.data.db;

import com.radicalninja.transitserve.data.model.Route;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RouteRepository extends MongoRepository<Route, ObjectId> {

    // TODO: Train / bus CRUD methods here.

}
