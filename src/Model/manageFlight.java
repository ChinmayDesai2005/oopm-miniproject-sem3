package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.Calendar;

public class manageFlight extends fileHandlingFlight implements Displayable{
    ArrayList<CommercialFlight> flights = new ArrayList<CommercialFlight>();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;

    public manageFlight(){
        readJsonFile("src/Model/flights.json");
    }
    public ArrayList<CommercialFlight> readJsonFile(String file_path){
        ObjectMapper objectMapper = new ObjectMapper();

        try{

            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int id = node.get("flight_id").asInt();
                    String flight_name = node.get("flight_name").asText();
                    String flight_code = node.get("flight_code").asText();
                    String flight_model = node.get("flight_model").asText();
                    String flight_classes = node.get("flight_classes").asText();
                    int no_of_passengers = node.get("no_of_passengers").asInt();
                    CommercialFlight temp_flight = new CommercialFlight(id, flight_name, flight_code, flight_model, no_of_passengers, flight_classes);
                    flights.add(temp_flight);


                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return flights;
    }

    @Override
    public void writeJsonFile(ArrayList<CommercialFlight> flights) {
        ObjectMapper Obj = new ObjectMapper();
        try {

            for (int i = 0; i < flights.size(); i++)
            {
                // Converting the Java object into a JSON string
                String flight_str = Obj.writeValueAsString(flights.get(i));
                // Displaying Java object into a JSON string
                System.out.println(flight_str);
            }
        }
        catch (IOException e) {
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
