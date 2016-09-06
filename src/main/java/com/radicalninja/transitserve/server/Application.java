package com.radicalninja.transitserve.server;

import com.radicalninja.transitserve.data.TrainStopsImporter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // TODO: Create class for saving app config to local json file.
        // TODO: Save flag indicating if TrainStops have been imported, last updated date, etc

        try {
            System.out.println("Performing app-start train stop import task!");
            trainStopsImporter().performImport();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public TrainStopsImporter trainStopsImporter() {
        return new TrainStopsImporter();
    }

}
