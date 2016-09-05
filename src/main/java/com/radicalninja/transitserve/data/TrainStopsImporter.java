package com.radicalninja.transitserve.data;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.radicalninja.transitserve.data.model.CsvTrainStop;
import com.radicalninja.transitserve.data.model.Route;
import com.radicalninja.transitserve.data.model.Stop;
import com.radicalninja.transitserve.data.model.Type;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TrainStopsImporter {

    private final static String TRAIN_CSV_ZIP_URL = "http://www.transitchicago.com/assets/1/developer_center/cta_L_stops.zip";
    private final static String TRAIN_CSV_FILENAME = "cta_L_stops_new.csv";

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

    public boolean importStops() throws IOException {
        final File csvFile = new File("train_stops.csv");
        final List<CsvTrainStop> stops = parseCsvData(csvFile);
        // TODO: Import into MongoDB
        return true;
    }

    private void processCsvData(final List<CsvTrainStop> csvTrainStops) {

    }

    private void setupAssociations() {

    }

    private void setupAssociation(final boolean associate, final Route route, final Stop stop) {

    }

}
