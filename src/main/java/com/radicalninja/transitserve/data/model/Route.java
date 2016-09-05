package com.radicalninja.transitserve.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Route {

    @Id
    private int id;

    @Indexed(unique = true)
    private String routeId;

    private String shortName;

    private String longName;

    private Type type;

    private int colorHex;

    public Route(String routeId, String shortName, String longName, Type type, int colorHex) {
        this.routeId = routeId;
        this.shortName = shortName;
        this.longName = longName;
        this.type = type;
        this.colorHex = colorHex;
    }
}
