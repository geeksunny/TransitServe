package com.radicalninja.transitserve.data.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;
import java.io.Serializable;
import java.util.Locale;

@JsonDeserialize(using = LatLong.LocationDeserializer.class)
public class LatLong implements Serializable {

    private static final String FORMAT_STRING = "(%f,%f)";

    double latitude, longitude;

    public LatLong() { }

    public LatLong(final String coordinates) {
        // (41.85177331, -87.75669201)
        final String[] coords = coordinates.replaceAll("[\\(\\)\\s]", "").split(",");
        latitude = Double.parseDouble(coords[0]);
        longitude = Double.parseDouble(coords[1]);
    }

    public LatLong(final double latitude, final double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, FORMAT_STRING, latitude, longitude);
    }


    public static class LocationDeserializer extends JsonDeserializer<LatLong> {
        @Override
        public LatLong deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            return new LatLong(p.getText());
        }
    }


    //    @com.raizlabs.android.dbflow.annotation.TypeConverter
//    public static class LatLongConverter extends TypeConverter<String, LatLong> {
//        @Override
//        public String getDBValue(LatLong model) {
//            return (null == model) ? null : model.toString();
//        }
//
//        @Override
//        public LatLong getModelValue(String data) {
//            return new LatLong(data);
//        }
//    }

}
