import Model.*;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException{

        ArrayList<CommercialFlight> flights = new ArrayList<CommercialFlight>();
        ArrayList<Airport> airports = new ArrayList<Airport>();
        ArrayList<Schedule> schedules = new ArrayList<Schedule>();
        Scanner scanner = new Scanner(System.in);
        manageFlight mf1 = new manageFlight();
        manageAirport ma1 = new manageAirport();
//        flights = mf1.readJsonFile("src/Model/flights.json");
//        airports = ma1.readJsonFile("src/Model/airports.json");
//        ObjectMapper mapper = new ObjectMapper();

        int choice;

        do{
            System.out.println("Menu:");
            System.out.println("1. Load Flights");
            System.out.println("2. Display All Flights");
            System.out.println("3. Display Flight by Id");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    flights = mf1.readJsonFile("src/Model/flights.json");
                    System.out.println("All Flights Loaded!");
                    break;

                case 2:
                    System.out.println("------------------------------------------------------");
                    for(int i = 0; i < flights.size(); i++){
                        System.out.println(flights.get(i).displayFlight());
                        System.out.println("------------------------------------------------------");
                    }
                    break;

                case 3:
                    System.out.println("Enter Flight Id to Display: ");
                    int flight_id = scanner.nextInt();
                    System.out.println(flights.get(flight_id - 1).displayFlight());
                    break;

                case 4:
                    System.out.println("Exiting!");

                    break;
                default:
                    System.out.println("Invalid choice. Try Again!");

                    break;

            }
        }while(choice != 4);

    }
}