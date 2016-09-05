package com.radicalninja.transitserve.data.association;

import com.radicalninja.transitserve.data.model.Route;
import com.radicalninja.transitserve.data.model.Stop;

public class RouteAndStop {

    private Route route;

    private Stop stop;

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Stop getStop() {
        return stop;
    }

    public void setStop(Stop stop) {
        this.stop = stop;
    }

}
