package com.radicalninja.transitserve.data;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.radicalninja.transitserve.data.association.RouteAndStop;
import com.radicalninja.transitserve.data.db.RouteAndStopRepository;
import com.radicalninja.transitserve.data.db.RouteRepository;
import com.radicalninja.transitserve.data.db.StopRepository;
import com.radicalninja.transitserve.data.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TrainStopsImporter {

    // TODO: Add logging to this class
    private final static String TRAIN_CSV_IMPORT_FILE = "train_stops.csv";
    private final static String TRAIN_CSV_ZIP_URL = "http://www.transitchicago.com/assets/1/developer_center/cta_L_stops.zip";
    private final static String TRAIN_CSV_FILENAME = "cta_L_stops_new.csv";

    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private StopRepository stopRepository;
    @Autowired
    private RouteAndStopRepository routeAndStopRepository;

    // Base stops
    private Route red = new Route("red", "Red", "Red Line", Type.TRAIN, 0xffee254c);
    private Route blue = new Route("blue", "Blue", "Blue Line", Type.TRAIN, 0xff487a9b);
    private Route brn = new Route("brn", "Brown", "Brown Line", Type.TRAIN, 0xffa1857d);
    private Route g = new Route("g", "Green", "Green Line", Type.TRAIN, 0xff2f9463);
    private Route org = new Route("org", "Orange", "Orange Line", Type.TRAIN, 0xfff16f20);
    private Route p = new Route("p", "Purple", "Purple Line", Type.TRAIN, 0xff6b668d);
    private Route pexp = new Route("pexp", "Purple Express", "Purple Line Express", Type.TRAIN, 0xff6b668d);
    private Route pink = new Route("pink", "Pink", "Pink Line", Type.TRAIN, 0xfff8bbc7);
    private Route y = new Route("y", "Yellow", "Yellow Line", Type.TRAIN, 0xfff9f304);

    public void performImport() throws IOException {
        if (routeRepository.count() == 0) {
            System.out.println("Performing route import job.");
            importRoutes();
        } else {
            System.out.println("Skipping route import job.");
        }
        if (stopRepository.count() == 0) {
            System.out.println("Performing stop data import job.");
            importStops();
        } else {
            System.out.println("Skipping stop data import job.");
        }
    }

    // URL, File, InputStream
    private ObjectReader makeObjectReader() {
        final CsvMapper mapper = new CsvMapper();
        final CsvSchema schema = mapper.schemaFor(CsvTrainStop.class).withSkipFirstDataRow(true);
        return mapper.readerFor(CsvTrainStop.class).with(schema);
    }


    private <T> List<T> parseCsvData(final MappingIterator<T> iterator) throws IOException {
        final List<T> data = new ArrayList<>();
        while (iterator.hasNextValue()) {
            final T item = iterator.nextValue();
            data.add(item);
        }
        return data;
    }


    private List<CsvTrainStop> parseCsvData(final File file) throws IOException {
        final ObjectReader reader = makeObjectReader();
        final MappingIterator<CsvTrainStop> iterator = reader.readValues(file);
        return parseCsvData(iterator);
    }


    private List<CsvTrainStop> parseCsvData(final URL url) throws IOException {
        final ObjectReader reader = makeObjectReader();
        final MappingIterator<CsvTrainStop> iterator = reader.readValues(url);
        return parseCsvData(iterator);
    }

    private void importRoutes() {

        routeRepository.save(red);
        routeRepository.save(blue);
        routeRepository.save(brn);
        routeRepository.save(g);
        routeRepository.save(org);
        routeRepository.save(p);
        routeRepository.save(pexp);
        routeRepository.save(pink);
        routeRepository.save(y);
    }

    private void importStops() throws IOException {
        final File csvFile = new File(TRAIN_CSV_IMPORT_FILE);
        final List<CsvTrainStop> stops = parseCsvData(csvFile);
        processCsvData(stops);
    }

    private void processCsvData(final List<CsvTrainStop> csvTrainStops) {
        for (final CsvTrainStop trainStop : csvTrainStops) {
            final TrainStop stop = trainStop.createTrainStop();
            stopRepository.save(stop);
            setupAssociations(trainStop, stop);
        }
    }

    private void setupAssociations(final CsvTrainStop csvTrainStop, final TrainStop trainStop) {
        setupAssociation(csvTrainStop.red, red, trainStop);
        setupAssociation(csvTrainStop.blue, blue, trainStop);
        setupAssociation(csvTrainStop.brown, brn, trainStop);
        setupAssociation(csvTrainStop.green, g, trainStop);
        setupAssociation(csvTrainStop.orange, org, trainStop);
        setupAssociation(csvTrainStop.purple, p, trainStop);
        setupAssociation(csvTrainStop.purpleExpress, pexp, trainStop);
        setupAssociation(csvTrainStop.pink, pink, trainStop);
        setupAssociation(csvTrainStop.yellow, y, trainStop);
    }

    private void setupAssociation(final boolean associate, final Route route, final Stop stop) {
        if (associate) {
            final RouteAndStop routeAndStop = new RouteAndStop();
            routeAndStop.setRoute(route);
            routeAndStop.setStop(stop);
            routeAndStopRepository.save(routeAndStop);
        }
    }

}
