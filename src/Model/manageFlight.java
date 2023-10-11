package Model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.Calendar;

public class manageFlight extends fileHandlingFlight{
    ArrayList<CommercialFlight> flights = new ArrayList<CommercialFlight>();
    public ArrayList<CommercialFlight> loadJsonFile(String file_path) {return readJsonFile(file_path);}
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
            System.out.println("------------------------------------");
            System.out.println(e);
            System.out.println("ERROR : Please check the path specified for JSON file!");
            System.out.println("-------------------------------------");
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
}
