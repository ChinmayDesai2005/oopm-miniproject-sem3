package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.Calendar;

public class manageFlight extends fileHandlingFlight implements Displayable{
    ArrayList<CommercialFlight> flights = new ArrayList<CommercialFlight>();

    JSONArray flightsJSON;
    String toJSON;

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

//
//    public manageFlight(){
//        readJsonFile("src/Model/flights.json");
//    }
    public ArrayList<CommercialFlight> loadJsonFile(String file_path) {return readJsonFile(file_path);}
    public ArrayList<CommercialFlight> readJsonFile(String file_path){
        toJSON = file_path;
        JSONParser jsonParser = new JSONParser();

        try(FileReader reader = new FileReader(file_path)){

            Object rootNode = jsonParser.parse(reader);
            flightsJSON = (JSONArray) rootNode;
//            System.out.println(flightsJSON);

            for(int i = 0; i < flightsJSON.size(); i++) {
                System.out.println(flightsJSON.get(i));
                JSONObject node = (JSONObject) flightsJSON.get(i);
                int id = ((Long) node.get("flight_id")).intValue();
                String flight_name = node.get("flight_name").toString();
                String flight_code = node.get("flight_code").toString();
                String flight_model = node.get("flight_model").toString();
                String flight_classes = node.get("flight_classes").toString();
                int no_of_passengers = ((Long) node.get("no_of_passengers")).intValue();
                CommercialFlight temp_flight = new CommercialFlight(id, flight_name, flight_code, flight_model, no_of_passengers, flight_classes);
                flights.add(temp_flight);
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }

        return flights;
    }

    @Override
    public void writeJsonFile(ArrayList<CommercialFlight> flights) {
        flightsJSON.clear();
        for (CommercialFlight flight : flights) {
            JSONObject newFlight = new JSONObject();
            newFlight.put("flight_id", flight.getFlightId());
            newFlight.put("flight_name", flight.getFlightName());
            newFlight.put("flight_code", flight.getFlightCode());
            newFlight.put("flight_model", flight.getFlightModel());
            newFlight.put("flight_classes", flight.getFlightClasses());
            newFlight.put("no_of_passengers", flight.getNoOfPassengers());
            flightsJSON.add(newFlight);
        }
        try (FileWriter file = new FileWriter(toJSON)) {
//            file.write("This is something");
            System.out.println("Writing to file!");
            //We can write any JSONArray or JSONObject instance to the file
            file.write(flightsJSON.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Id");
        headers.add("Name");
        headers.add("Code");
        headers.add("Model");
        headers.add("Classes");
        headers.add("Passengers");

        return headers;
    }

    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> flight_details = new ArrayList<String>();

        flight_details.add(String.valueOf(flights.get(line).getFlightId()));
        flight_details.add(flights.get(line).getFlightName());
        flight_details.add(flights.get(line).getFlightCode());
        flight_details.add(flights.get(line).getFlightModel());
        flight_details.add(String.valueOf(flights.get(line).getFlightClasses()));
        flight_details.add(String.valueOf(flights.get(line).getNoOfPassengers()));
        return flight_details;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> flights_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            flights_subset.add(getLine(i));
        }
        return flights_subset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return highlightedLine;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(getFirstLineToDisplay() + getLinesBeingDisplayed() - 1);
        return lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        highlightedLine = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        lastLineIndex = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        linesBeingDisplayed = numberOfLines;
    }

    public ArrayList getTable() {
        return flights;
    }
}
