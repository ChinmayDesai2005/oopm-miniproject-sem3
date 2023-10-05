package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class manageAirport extends fileHandlingAirport{
    ArrayList<Airport> airports = new ArrayList<Airport>();
    public ArrayList<Airport> loadJsonFile(String file_path) {
        return readJsonFile(file_path);
    }
    public ArrayList<Airport> readJsonFile(String file_path) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON file
            //JsonNode rootNode = objectMapper.readTree(new File("src/Model/temp.json"));
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int id = node.get("id").asInt();
                    String airport_name = node.get("airport_name").asText();
                    String airport_code = node.get("airport_code").asText();
                    String airport_location = node.get("airport_location").asText();
                    boolean is_airport_international = node.get("is_airport_international").asBoolean();
                    int no_of_hangers = node.get("no_of_hangers").asInt();
                    int no_of_runways = node.get("no_of_runways").asInt();
                    int airport_capacity = node.get("airport_capacity").asInt();

                    Airport temp_airport = new Airport();
                    temp_airport.setAirportId(id);
                    temp_airport.setAirportName(airport_name);
                    temp_airport.setAirportCode(airport_code);
                    temp_airport.setAirportLocation(airport_location);
                    temp_airport.setIsInternational(is_airport_international);
                    temp_airport.setNoOfRunways(no_of_runways);
                    temp_airport.setNoOfHangers(no_of_hangers);
                    temp_airport.setAirportCapacity(airport_capacity);

                    airports.add(temp_airport);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return airports;
    }
}
