package com.radicalninja.transitserve;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvFactory;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.radicalninja.transitserve.model.TrainStopCsv;
import org.springframework.boot.info.InfoProperties;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TrainStopsImporter {


    public static void testParse() throws IOException {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(TrainStopCsv.class).withSkipFirstDataRow(true);

        MappingIterator<TrainStopCsv> iterator =
                mapper.readerFor(TrainStopCsv.class).with(schema).readValues(new File("train_stops.csv"));
        final List<TrainStopCsv> stops = new ArrayList<>();
        while (iterator.hasNextValue()) {
//            try {
                final TrainStopCsv stop = iterator.nextValue();
                stops.add(stop);
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println("done");
    }


    private void importStops() throws IOException {
//        final InputStream csvInputStream = App.getInstance().getAssets().open("train_stops.csv");
//        final CSVReader csvReader = new CSVReader(new InputStreamReader(csvInputStream));
//        Log.d(TAG, "Beginning TrainStop Import Job from file (assets/train_stops.csv)");
//        final DatabaseDefinition database = FlowManager.getDatabase(TransitDB.class);
//        for (final String[] line : csvReader) {
//            if (headerRowMap.isEmpty()) {
//                // TODO: Map headers
//                for (int i = 0; i < line.length; i++) {
//                    final String cell = line[i];
//                    headerRowMap.put(cell, i);
//                }
//                continue;
//            }
//            //////////
//            try {
//                final TrainStop stop = processLine(line);
//                Transaction transaction = database.beginTransactionAsync(new ITransaction() {
//                    @Override
//                    public void execute(DatabaseWrapper databaseWrapper) {
//                        stop.save(databaseWrapper);
//                    }
//                }).success(new Transaction.Success() {
//                    @Override
//                    public void onSuccess(Transaction transaction) {
//                        Log.e(TAG, "TrainStop ("+stop.getStopName()+") success saving");
//                        setupAssociations(line, stop);
//                    }
//                }).error(new Transaction.Error() {
//                    @Override
//                    public void onError(Transaction transaction, Throwable error) {
//                        Log.e(TAG, "TrainStop ("+stop.getStopName()+") error saving");
//                    }
//                }).build();
//                Log.d(TAG, "Saving with dbflow");
//                transaction.execute();
//                //final SqlResult sqlResult = manager.saveTrainStop(stop);
//                //Log.d(TAG, String.format("Result: %s | %s", sqlResult.toString(), stop.toString()));
//            } catch (Exception e) {
//                Log.e(TAG, "Error when trying to parse a CSV line!", e);
//            }
//        }
//        Log.d(TAG, "Finished with TrainStop Import Job!");
    }

}
