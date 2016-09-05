package com.radicalninja.transitserve.data.association;

import com.radicalninja.transitserve.data.model.Route;
import com.radicalninja.transitserve.data.model.Stop;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;

@CompoundIndexes(
        @CompoundIndex(name = "RouteAndStop _ind1", def = "{'route':1,'stop':1}", unique = true)
)
public class RouteAndStop {

    @Id
    private Integer id;

    @Indexed
    private Route route;

    @Indexed
    private Stop stop;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
