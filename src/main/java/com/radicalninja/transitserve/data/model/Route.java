package com.radicalninja.transitserve.data.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.index.Indexed;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class Route {

    @JsonProperty
    @Indexed(unique = true)
    private String routeId;

    @JsonProperty
    private String shortName;

    @JsonProperty
    private String longName;

    @JsonProperty
    private Type type;

    @JsonProperty
    private int colorHex;

    public Route(String routeId, String shortName, String longName, Type type, int colorHex) {
        this.routeId = routeId;
        this.shortName = shortName;
        this.longName = longName;
        this.type = type;
        this.colorHex = colorHex;
    }
}
