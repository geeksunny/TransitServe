package com.radicalninja.transitserve.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class Route {

    /*
        @PrimaryKey(autoincrement = true)
    private int _id;
    @Column
    @Unique
    private String routeId;
    @Column
    private Type type;
    @Column
    private String longName;
    @Column
    private String shortName;
    @Column
    private int colorHex;
     */

    @Id
    private int id;
    @Indexed(unique = true)
    private String routeId;
    private Type type
}
