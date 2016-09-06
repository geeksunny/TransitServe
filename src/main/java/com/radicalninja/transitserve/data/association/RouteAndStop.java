package com.radicalninja.transitserve.data.association;

import com.radicalninja.transitserve.data.model.Route;
import com.radicalninja.transitserve.data.model.Stop;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@CompoundIndexes(
        @CompoundIndex(name = "RouteAndStop _ind1", def = "{'route':1,'stop':1}", unique = true)
)
public class RouteAndStop {

    // TODO: See if there's a cleaner way to implement this. foreign key?
    @Indexed
    private String routeId;
    @Indexed
    private int stopId;

    @Indexed
    private Route route;

    @Indexed
    private Stop stop;

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
        this.routeId = route.getRouteId();
    }

    public Stop getStop() {
        return stop;
    }

    public void setStop(Stop stop) {
        this.stop = stop;
        this.stopId = stop.getStopId();
    }

    public static List<Route> getAllRoutes(final Collection<RouteAndStop> records) {
        final List<Route> routes = new ArrayList<>(records.size());
        for (final RouteAndStop routeAndStop : records) {
            routes.add(routeAndStop.getRoute());
        }
        return routes;
    }

    public static List<Stop> getAllStops(final Collection<RouteAndStop> records) {
        final List<Stop> stops = new ArrayList<>(records.size());
        for (final RouteAndStop routeAndStop : records) {
            stops.add(routeAndStop.getStop());
        }
        return stops;
    }

}
