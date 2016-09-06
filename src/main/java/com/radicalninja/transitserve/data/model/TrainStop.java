package com.radicalninja.transitserve.data.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;

@CompoundIndexes(
        @CompoundIndex(name = "TrainStop _ind1", def = "{'stopId':1,'directionId':1}", unique = true)
)
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class TrainStop implements Stop {

    @JsonProperty
    @Indexed
    private int stopId;

    @JsonProperty
    @Indexed
    private Direction directionId;

    @JsonProperty
    private String stopName;

    @JsonProperty
    private String stationName;

    @JsonProperty
    private String stationDescription;

    @JsonProperty
    private int mapId;

    @JsonProperty
    private boolean isAdaAccessible;

    @JsonProperty
    private LatLong location;

    @Override
    public Direction getDirectionId() {
        return directionId;
    }

    public boolean isAdaAccessible() {
        return isAdaAccessible;
    }

    @Override
    public LatLong getLocation() {
        return location;
    }

    @Override
    public int getMapId() {
        return mapId;
    }

    public String getStationDescription() {
        return stationDescription;
    }

    @Override
    public String getStationName() {
        return stationName;
    }

    @Override
    public int getStopId() {
        return stopId;
    }

    @Override
    public String getStopName() {
        return stopName;
    }

    public void setDirectionId(Direction directionId) {
        this.directionId = directionId;
    }

    public void setAdaAccessible(boolean adaAccessible) {
        isAdaAccessible = adaAccessible;
    }

    @Override
    public void setLocation(LatLong location) {
        this.location = location;
    }

    @Override
    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    @Override
    public void setStationDescription(String stationDescription) {
        this.stationDescription = stationDescription;
    }

    @Override
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    @Override
    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    protected TrainStop() { }

    @Override
    public String toString() {
        return "TrainStop{" +
                "stopId=" + stopId +
                ", directionId=" + directionId +
                ", stopName='" + stopName + '\'' +
                ", stationName='" + stationName + '\'' +
                ", stationDescription='" + stationDescription + '\'' +
                ", mapId=" + mapId +
                ", isAdaAccessible=" + isAdaAccessible +
                ", location=" + location +
                '}';
    }

}
