package com.radicalninja.transitserve.data.model;

public interface Stop {

    Direction getDirectionId();

    LatLong getLocation();

    int getMapId();

    String getStationDescription();

    String getStationName();

    int getStopId();

    String getStopName();

    void setDirectionId(Direction directionId);

    void setLocation(LatLong location);

    void setMapId(int mapId);

    void setStationDescription(String stationDescription);

    void setStationName(String stationName);

    void setStopId(int stopId);

    void setStopName(String stopName);

}
