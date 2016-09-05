package com.radicalninja.transitserve.server;

import com.radicalninja.transitserve.data.TrainStopsImporter;
import com.radicalninja.transitserve.data.db.RouteAndStopRepository;
import com.radicalninja.transitserve.data.db.RouteRepository;
import com.radicalninja.transitserve.data.db.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private StopRepository stopRepository;
    @Autowired
    private RouteAndStopRepository routeAndStopRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // TODO: Create class for saving app config to local json file.
        // TODO: Save flag indicating if TrainStops have been imported, last updated date, etc

        try {
            final TrainStopsImporter importer = new TrainStopsImporter();
            importer.importStops();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
