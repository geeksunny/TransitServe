package com.radicalninja.transitserve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);
        try {
            TrainStopsImporter.testParse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
