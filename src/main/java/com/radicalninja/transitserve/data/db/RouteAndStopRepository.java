package com.radicalninja.transitserve.data.db;

import com.radicalninja.transitserve.data.association.RouteAndStop;
import com.radicalninja.transitserve.data.model.Route;
import com.radicalninja.transitserve.data.model.Stop;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RouteAndStopRepository extends MongoRepository<RouteAndStop, Integer> {

    List<RouteAndStop> findByRoute(Route route);
    List<RouteAndStop> findByStop(Stop stop);

}
