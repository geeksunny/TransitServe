package com.radicalninja.transitserve.server;

import com.radicalninja.transitserve.data.association.RouteAndStop;
import com.radicalninja.transitserve.data.db.RouteAndStopRepository;
import com.radicalninja.transitserve.data.db.RouteRepository;
import com.radicalninja.transitserve.data.db.StopRepository;
import com.radicalninja.transitserve.data.model.Route;
import com.radicalninja.transitserve.data.model.Stop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainDataController {

    // TODO: Implement an error response model.

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private StopRepository stopRepository;
    @Autowired
    private RouteAndStopRepository routeAndStopRepository;

    @RequestMapping("/routes")
    public List<Route> allRoutes(/*@RequestParam(value = "name", defaultValue = "World") String name*/) {
        return routeRepository.findAll();
    }

    @RequestMapping("/stops")
    public List<Stop> stopsForRoute(@RequestParam(value = "route", required = false) String routeId) {
        if (StringUtils.isEmpty(routeId)) {
            return stopRepository.findAll();
        }
        final List<RouteAndStop> stopsForRoute = routeAndStopRepository.findByRouteId(routeId);
        return RouteAndStop.getAllStops(stopsForRoute);
    }

}
