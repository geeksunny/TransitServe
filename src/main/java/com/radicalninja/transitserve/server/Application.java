package com.radicalninja.transitserve.server;

import com.radicalninja.transitserve.data.TrainStopsImporter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        try {
            final TrainStopsImporter importer = new TrainStopsImporter();
            importer.importStops();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //SpringApplication.run(Application.class, args);
    }

}
