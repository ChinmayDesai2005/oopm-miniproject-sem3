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
        flights = mf1.readJsonFile("src/Model/flights.json");
        airports = ma1.readJsonFile("src/Model/airports.json");
        ObjectMapper mapper = new ObjectMapper();

        int choice;

        do{
            System.out.println("Menu:");
            System.out.println("1. Add a new Flight");
            System.out.println("2. Display a Flight");
            System.out.println("3. Add a new Airport");
            System.out.println("4. Display an Airport");
            System.out.println("5. Schedule a Flight to an Airport");
            System.out.println("6. Display all Schedules");
            System.out.println("7. Add Airport Terminal");
            System.out.println("8. Remove Airport Terminal");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Enter Flight Name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter Flight Code: ");
                    String code = scanner.next();

                    System.out.println("Enter Flight Model: ");
                    String model = scanner.next();

                    scanner.nextLine();
                    System.out.println("Enter the classes in the Flight: ");
                    String flightClasses = scanner.nextLine();

                    System.out.println("Enter Number of Passengers: ");
                    int passengers = scanner.nextInt();

                    System.out.println("Do you wish to have flightId to be sequential(S) or user-input(U) generated: ");
                    String seq_or_ran = scanner.next();

                    int flightId = flights.size() + 1;

                    //Use Of Constructor and Polymorphism
                    if(seq_or_ran.equals("S")){
                        CommercialFlight flg = new CommercialFlight(flightId, name, code, model, passengers, flightClasses);
                        flights.add(flg);
                    }
                    else if(seq_or_ran.equals("U")){
                        System.out.println("Enter Id of the Flight("+flightId+1+" - 100): ");
                        int id = scanner.nextInt();
                        CommercialFlight flg = new CommercialFlight(id-1, name, code, model, passengers, flightClasses);
                        flights.add(flg);
                    }


                    System.out.println("Flight created and added to array!");

                    break;
                case 2:
                    flights = mf1.readJsonFile("src/Model/flights.json");
                    System.out.println("Enter Flight Id to Display Flight: ");
                    int flight_id_to_display = scanner.nextInt();
                    System.out.println(flights.get(flight_id_to_display-1).displayFlight());

                    break;
                case 3:
                        System.out.println("Enter Airport Name: ");
                        String airport_name = scanner.nextLine();

                        System.out.println("Enter Airport Location: ");
                        String airport_location = scanner.nextLine();

                        System.out.println("Enter Airport Code: ");
                        String airport_code = scanner.next();

                        System.out.println("Enter Airport Capacity: ");
                        int capacity = scanner.nextInt();

                        System.out.println("Does the Airport Support International FLights? (true/false)");
                        boolean isInternational = scanner.nextBoolean();

                        System.out.println("Enter Number of Hangers: ");
                        int hangers = scanner.nextInt();

                        System.out.println("Enter Number of Runways: ");
                        int runways = scanner.nextInt();

                        int airportId = airports.size() + 1;

                        Airport currentAirport = new Airport();
                        currentAirport.setAirportId(airportId);
                        currentAirport.setAirportName(airport_name);
                        currentAirport.setAirportLocation(airport_location);
                        currentAirport.setAirportCode(airport_code);
                        currentAirport.setAirportCapacity(capacity);
                        currentAirport.setIsInternational(isInternational);
                        currentAirport.setNoOfHangers(hangers);
                        currentAirport.setNoOfRunways(runways);
                        airports.add(currentAirport);

                        System.out.println("Airport created and added to array!");

                    break;
                case 4:
                    airports = ma1.readJsonFile("src/Model/airports.json");
                    System.out.println("Enter Airport Id to Display Airport: ");
                    int airport_id_to_display = scanner.nextInt();
                    System.out.println(airports.get(airport_id_to_display-1).displayAirport());
                    break;

                case 5:
                        System.out.println("Enter Id of Flight to Schedule: ");
                        int selected_flight_id = scanner.nextInt();

                        System.out.println("Enter Id of Airport to Schedule: ");
                        int selected_airport_id = scanner.nextInt();

                        System.out.println("Enter the date (year month day) to schedule: ");
                        int year = scanner.nextInt();
                        int month = scanner.nextInt();
                        int day = scanner.nextInt();

                        Calendar schedule_date = Calendar.getInstance();
                        schedule_date.set(Calendar.YEAR, year);
                        schedule_date.set(Calendar.MONTH, month - 1);
                        schedule_date.set(Calendar.DAY_OF_MONTH, day);

                        Schedule temp_schedule = new Schedule();
                        int scheduleCount = schedules.size() + 1;

                        temp_schedule.schedule_fight_to_airport(flights.get(selected_flight_id - 1), airports.get(selected_airport_id - 1), schedule_date);
                        schedules.add(temp_schedule);

                        System.out.println("Flight Scheduled to Airport and added to array!");

                    break;
                case 6:
                    for(int i = 0; i < schedules.size(); i++)
                    {
                        schedules.get(i).display_flights_scheduled_airport();
                    }

                    break;
                case 7:
                    System.out.println("Enter the id of the Airport: ");
                    int airport_id = Integer.parseInt(String.valueOf(scanner.nextInt()));
                    if(airport_id-1  < airports.size())
                    {
                        System.out.println("Terminal Format : TerminalCode TerminalName TerminalLocation");
                        System.out.println("Add Terminal to the airport "+airports.get(airport_id - 1).getAirportName() +": ");
                        scanner.nextLine();
                        String terminal = scanner.nextLine();
                        airports.get(airport_id - 1).addAirportTerminal(terminal);
                    }
                    else {
                        System.out.println("Airport isn't added. IndexOutOfBounds!");
                    }
                    break;
                case 8:
                    System.out.print("Enter id of the Airport: ");
                    airport_id = Integer.parseInt(String.valueOf(scanner.nextInt()));
                    if(airport_id-1 < airports.size())
                    {
                        System.out.print("Enter index of the Terminal to be removed for the Airport "+ airports.get(airport_id - 1).getAirportName() +": ");
                        int terminal_no = Integer.parseInt(String.valueOf(scanner.nextInt()));
                        airports.get(airport_id - 1).removeAirportTerminal(terminal_no);
                    }
                    else {
                        System.out.println("Enter Proper Index. Index entered does not exist");
                    }
                    break;
                case 9:
                    System.out.println("Exiting!");

                    break;
                default:
                    System.out.println("Invalid choice. Try Again!");

                    break;

            }
        }while(choice != 9);

    }
}