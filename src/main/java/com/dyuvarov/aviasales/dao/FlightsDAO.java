package com.dyuvarov.aviasales.dao;

import au.com.bytecode.opencsv.CSVReader;
import com.dyuvarov.aviasales.model.Flight;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
/**
 * provides access to flights in CSV file
 */
public class FlightsDAO {
    final String filePath;    //file with data

    public FlightsDAO(@Value("${filepath}") String path) {
        filePath = path;
    }

    /**
     *
     * @param id - flight id
     * @return Flight object if id found in file, else null
     */
    public Flight flightById(String id) {
        FileReader fileReader;
        try {
            fileReader = new FileReader(filePath);
        }
        catch (FileNotFoundException exception) {
            exception.printStackTrace();
            return null;
        }

        CSVReader reader = new CSVReader(fileReader);
        try {
            String[] line = reader.readNext();                   //skip header
            while ((line = reader.readNext()) != null) {
                if (line.length != 8)
                    continue;
                if (line[0].equals(id)) {
                    return (new Flight(line[7], line[3], line[4], line[5], line[6]));
                }
            }
        }
        catch (IOException exception) {
            exception.printStackTrace();
            return null;
        }
        return null;
    }
}
