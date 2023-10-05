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

        do {
            System.out.println("Menu:");
            System.out.println("1. Create a Flight");
            System.out.println("2. Update a Flight");
            System.out.println("3. Display a Flight");
            System.out.println("4. Display All Flights");
            System.out.println("5. Delete a Flight");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
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
                    if (seq_or_ran.equals("S")) {
                        CommercialFlight flg = new CommercialFlight(flightId, name, code, model, passengers, flightClasses);
                        flights.add(flg);
                    } else if (seq_or_ran.equals("U")) {
                        System.out.println("Enter Id of the Flight(" + flightId + 1 + " - 100): ");
                        int id = scanner.nextInt();
                        CommercialFlight flg = new CommercialFlight(id - 1, name, code, model, passengers, flightClasses);
                        flights.add(flg);
                    }


                    System.out.println("Flight created and added to array!");

                    break;

                case 2:
                    System.out.println("Enter the Flight ID to update : ");
                    int flight_id = scanner.nextInt();
                    scanner.nextLine();
                    int choice_to_change;
                    do {
                        System.out.println("1.Change Flight Name ");
                        System.out.println("2.Change Flight Code");
                        System.out.println("3.Change Flight Model");
                        System.out.println("4.Change Flight Class");
                        System.out.println("5.Change Number of Passengers");
                        System.out.println("6.Exit Update");

                        System.out.println("Enter your choice: ");
                        choice_to_change = scanner.nextInt();

                        switch (choice_to_change) {
                            case 1:
                                scanner.nextLine();
                                System.out.print("Enter Flight Name: ");
                                String name_update = scanner.nextLine();
                                flights.get(flight_id - 1).setFlightName(name_update);
                                mapper.writeValue(Paths.get("src/Model/flights.json").toFile(), flights);
                                break;
                            case 2:
                                System.out.print("Enter Flight Code: ");
                                String flight_code_update = scanner.nextLine();
                                flights.get(flight_id - 1).setFlightCode(flight_code_update);
                                mapper.writeValue(Paths.get("src/Model/flights.json").toFile(), flights);
                                break;
                            case 3:
                                System.out.print("Enter Flight Model: ");
                                String flight_model_update = scanner.next();
                                flights.get(flight_id - 1).setFlightModel(flight_model_update);
                                mapper.writeValue(Paths.get("src/Model/flights.json").toFile(), flights);
                                break;
                            case 4:
                                System.out.print("Enter Flight Class: ");
                                String flight_class_update = scanner.next();
                                flights.get(flight_id - 1).setFlightClasses(flight_class_update);
                                mapper.writeValue(Paths.get("src/Model/flights.json").toFile(), flights);
                                break;
                            case 5:
                                System.out.print("Enter Number of Passengers: ");
                                int noOfPassengers_update = scanner.nextInt();
                                flights.get(flight_id - 1).setNoOfPassengers(noOfPassengers_update);
                                mapper.writeValue(Paths.get("src/Model/flights.json").toFile(), flights);
                                break;
                            default:
                                System.out.println("Invalid choice. Try again.");
                                break;
                        }
                    } while (choice_to_change != 6);
                    break;


                case 3:
                    flights = mf1.readJsonFile("src/Model/flights.json");
                    System.out.println("Enter Flight Id to Display Flight: ");
                    int flight_id_to_display = scanner.nextInt();
                    System.out.println(flights.get(flight_id_to_display - 1).displayFlight());

                    break;
                case 4:
                    flights = mf1.readJsonFile("src/Model/flights.json");
                    for (int i = 0; i < flights.size(); i++) {
                        System.out.println(flights.get(i).display());
                    }
                    break;
                case 5:
                    System.out.print("Enter Flight Id to Delete: ");
                    int flight_id_delete = scanner.nextInt();
                    String flightName = flights.get(flight_id_delete - 1).getFlightName();
                    System.out.println("FLight Deleted Name : " + flightName);
                    flights.remove(flight_id_delete - 1);
                    mapper.writeValue(Paths.get("src/Model/flights.json").toFile(), flights);
                    break;


                case 6:
                    System.out.println("Exiting!");

                    break;
                default:
                    System.out.println("Invalid choice. Try Again!");

                    break;

            }
        }while(choice != 6);

        scanner.close();
    }
}