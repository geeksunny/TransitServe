package com.radicalninja.transitserve.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;

@CompoundIndexes(
        @CompoundIndex(name = "TrainStop _ind1", def = "{'stopId':1,'directionId':1}", unique = true)
)
public class TrainStop implements Stop {

    @Id
    @Indexed
    private int stopId;

    @Indexed
    private Direction directionId;

    private String stopName;

    private String stationName;

    private String stationDescription;

    private int mapId;

    private boolean isAdaAccessible;

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

    public static class Builder {
        private Direction directionId;
        private boolean isAdaAccessible;
        private LatLong location;
        private int mapId;
        private String stationDescription;
        private String stationName;
        private int stopId;
        private String stopName;

        public Builder setDirectionId(String directionId) {
            this.directionId = Direction.fromCode(directionId.charAt(0));
            return this;
        }

        public Builder setIsAdaAccessible(String isAdaAccessible) {
            this.isAdaAccessible = Boolean.parseBoolean(isAdaAccessible);
            return this;
        }

        public Builder setLocation(String location) {
            this.location = new LatLong(location);
            return this;
        }

        public Builder setMapId(String mapId) {
            this.mapId = Integer.parseInt(mapId);
            return this;
        }

        public Builder setStationDescription(String stationDescription) {
            this.stationDescription = stationDescription;
            return this;
        }

        public Builder setStationName(String stationName) {
            this.stationName = stationName;
            return this;
        }

        public Builder setStopId(String stopId) {
            this.stopId = Integer.parseInt(stopId);
            return this;
        }

        public Builder setStopName(String stopName) {
            this.stopName = stopName;
            return this;
        }

        public TrainStop build() {
            final TrainStop newStop = new TrainStop();
            newStop.stopId = this.stopId;
            newStop.directionId = this.directionId;
            newStop.stopName = this.stopName;
            newStop.stationName = this.stationName;
            newStop.stationDescription = this.stationDescription;
            newStop.mapId = this.mapId;
            newStop.isAdaAccessible = this.isAdaAccessible;
            newStop.location = this.location;

            return newStop;
        }
    }
}
