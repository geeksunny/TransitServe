package com.radicalninja.transitserve.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;

@JsonDeserialize(using = Direction.DirectionDeserializer.class)
public enum Direction {

    NORTH('N'),
    SOUTH('S'),
    EAST('E'),
    WEST('W'),
    INVALID(' ');

    public static final Direction[] A = { NORTH, EAST };
    public static final Direction[] B = { SOUTH, WEST };

    private final char code;

    Direction(final char directionCode) {
        code = directionCode;
    }

    public static Direction fromCode(final char directionCode) {
        switch (directionCode) {
            case 'N':
            case 'n':
                return NORTH;
            case 'S':
            case 's':
                return SOUTH;
            case 'E':
            case 'e':
                return EAST;
            case 'W':
            case 'w':
                return WEST;
        }
        return INVALID;
    }

    public static class DirectionDeserializer extends JsonDeserializer<Direction> {
        @Override
        public Direction deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            final char[] contents = p.getTextCharacters();
            final char code = (contents.length > 0) ? contents[0] : ' ';
            return Direction.fromCode(code);
        }
    }

}
