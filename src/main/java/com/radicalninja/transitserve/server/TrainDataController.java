package com.radicalninja.transitserve.server;

import com.radicalninja.transitserve.data.db.RouteAndStopRepository;
import com.radicalninja.transitserve.data.db.RouteRepository;
import com.radicalninja.transitserve.data.db.StopRepository;
import com.radicalninja.transitserve.data.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainDataController {

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

}
