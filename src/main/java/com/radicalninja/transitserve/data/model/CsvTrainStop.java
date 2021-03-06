package com.radicalninja.transitserve.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;

@JsonPropertyOrder({"stopId", "directionId", "stopName", "stationName", "stationDescriptiveName", "mapId", "ada", "red",
        "blue", "green", "brown", "purple", "purpleExpress", "yellow", "pink", "orange", "location"})
public class CsvTrainStop {
    //STOP_ID,DIRECTION_ID,STOP_NAME,STATION_NAME,STATION_DESCRIPTIVE_NAME,MAP_ID,ADA,RED,BLUE,G,BRN,P,Pexp,Y,Pnk,O,Location

    @JsonProperty("STOP_ID")
    private int stopId;

    @JsonProperty("DIRECTION_ID")
    private Direction directionId;

    @JsonProperty("STOP_NAME")
    private String stopName;

    @JsonProperty("STATION_NAME")
    private String stationName;

    @JsonProperty("STATION_DESCRIPTIVE_NAME")
    private String stationDescriptiveName;

    @JsonProperty("MAP_ID")
    private int mapId;

    @JsonProperty("ADA")
    @JsonDeserialize(using = CaseInsensitiveBooleanDeserializer.class)
    private boolean ada;

    @JsonProperty("RED")
    @JsonDeserialize(using = CaseInsensitiveBooleanDeserializer.class)
    public boolean red;

    @JsonProperty("BLUE")
    @JsonDeserialize(using = CaseInsensitiveBooleanDeserializer.class)
    public boolean blue;

    @JsonProperty("G")
    @JsonDeserialize(using = CaseInsensitiveBooleanDeserializer.class)
    public boolean green;

    @JsonProperty("BRN")
    @JsonDeserialize(using = CaseInsensitiveBooleanDeserializer.class)
    public boolean brown;

    @JsonProperty("P")
    @JsonDeserialize(using = CaseInsensitiveBooleanDeserializer.class)
    public boolean purple;

    @JsonProperty("Pexp")
    @JsonDeserialize(using = CaseInsensitiveBooleanDeserializer.class)
    public boolean purpleExpress;

    @JsonProperty("Y")
    @JsonDeserialize(using = CaseInsensitiveBooleanDeserializer.class)
    public boolean yellow;

    @JsonProperty("Pnk")
    @JsonDeserialize(using = CaseInsensitiveBooleanDeserializer.class)
    public boolean pink;

    @JsonProperty("O")
    @JsonDeserialize(using = CaseInsensitiveBooleanDeserializer.class)
    public boolean orange;

    @JsonProperty("Location")
    private LatLong location;

    public TrainStop createTrainStop() {
        final TrainStop stop = new TrainStop();
        stop.setStopId(stopId);
        stop.setDirectionId(directionId);
        stop.setStopName(stopName);
        stop.setStationName(stationName);
        stop.setStationDescription(stationDescriptiveName);
        stop.setMapId(mapId);
        stop.setAdaAccessible(ada);
        stop.setLocation(location);
        return stop;
    }

    public static class CaseInsensitiveBooleanDeserializer extends JsonDeserializer<Boolean> {
        @Override
        public Boolean deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            return Boolean.parseBoolean(p.getText().toLowerCase());
        }
    }
}
