import Model.Airport;
import Model.Flight;
import Model.Schedule;

import java.util.Calendar;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int currentFlightCount = 0;
        int currentAirportCount = 0;
        int currentScheduleCount = 0;

        Scanner scanner = new Scanner(System.in);

        Flight[] flights;
        flights = new Flight[100];

        Airport[] airports;
        airports = new Airport[100];

        Schedule[] schedules;
        schedules = new Schedule[100];

        int choice;

        do{
            System.out.println("Menu:");
            System.out.println("1. Add a new Flight");
            System.out.println("2. Display a Flight");
            System.out.println("3. Add a new Airport");
            System.out.println("4. Display an Airport");
            System.out.println("5. Schedule a Flight to an Airport");
            System.out.println("6. Display all Schedules");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    if(currentFlightCount < flights.length) {
                        System.out.println("Enter Flight Name: ");
                        String name = scanner.nextLine();

                        System.out.println("Enter Flight Code: ");
                        String code = scanner.next();

                        System.out.println("Enter Flight Model: ");
                        String model = scanner.next();

                        System.out.println("Enter Flight Capacity: ");
                        int capacity = scanner.nextInt();

                        System.out.println("Do you wish to have flightId to be sequential(S) or user-input(U) generated: ");
                        String seq_or_ran = scanner.next();

                        //Use Of Constructor and Polymorphism
                        if(seq_or_ran.equals("S")){
                            flights[currentFlightCount] = new Flight(currentFlightCount + 1, name, code, model, capacity);
                            currentFlightCount++;
                        }
                        else if(seq_or_ran.equals("U")){
                            System.out.println("Enter Id of the Flight("+currentFlightCount+1+" - 100): ");
                            int id = scanner.nextInt();
                            flights[id-1] = new Flight(id-1, name, code, model, capacity);
                            currentFlightCount++;
                        }


                        System.out.println("Flight created and added to array!");

                    } else {
                        System.out.println("Too many Flights! Array cannot store anymore flights.");
                    }

                    break;
                case 2:
                    System.out.println("Enter Flight Id to Display Flight: ");
                    int flight_id_to_display = scanner.nextInt();
                    Flight currentFlight = flights[flight_id_to_display - 1];

                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("FlightId: "+currentFlight.getFlightId());
                    System.out.println("FlightName: "+currentFlight.getFlightName());
                    System.out.println("FlightCode: "+currentFlight.getFlightCode());
                    System.out.println("FlightModel: "+currentFlight.getFlightModel());
                    System.out.println("FlightCapacity: "+currentFlight.getFlightCapacity());
                    System.out.println("-----------------------------------------------------------------------");

                    break;
                case 3:
                    if(currentAirportCount < airports.length) {
                        System.out.println("Enter Airport Name: ");
                        String name = scanner.nextLine();

                        System.out.println("Enter Airport Location: ");
                        String location = scanner.nextLine();

                        System.out.println("Enter Airport Code: ");
                        String code = scanner.next();

                        System.out.println("Enter Airport Capacity: ");
                        int capacity = scanner.nextInt();

                        System.out.println("Does the Airport Support International FLights? (true/false)");
                        boolean isInternational = scanner.nextBoolean();

                        System.out.println("Enter Number of Hangers: ");
                        int hangers = scanner.nextInt();

                        System.out.println("Enter Number of Runways: ");
                        int runways = scanner.nextInt();


                        airports[currentAirportCount] = new Airport();
                        currentAirportCount++;

                        Airport currentAirport = airports[currentAirportCount - 1];
                        currentAirport.setAirportId(currentAirportCount);
                        currentAirport.setAirportName(name);
                        currentAirport.setAirportLocation(location);
                        currentAirport.setAirportCode(code);
                        currentAirport.setAirportCapacity(capacity);
                        currentAirport.setIsInternational(isInternational);
                        currentAirport.setNoOfHangers(hangers);
                        currentAirport.setNoOfRunways(runways);

                        System.out.println("Airport created and added to array!");

                    } else {
                        System.out.println("Too many Airports! Array cannot store anymore airports.");
                    }

                    break;
                case 4:
                    System.out.println("Enter Airport Id to Display Airport: ");
                    int airport_id_to_display = scanner.nextInt();
                    Airport currentAirport = airports[airport_id_to_display - 1];

                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("AirportId: "+currentAirport.getAirportId());
                    System.out.println("AirportName: "+currentAirport.getAirportName());
                    System.out.println("AirportCode: "+currentAirport.getAirportCode());
                    System.out.println("AirportLocation: "+currentAirport.getAirportLocation());
                    System.out.println("AirportCapacity: "+currentAirport.getAirportCapacity());
                    System.out.println("isInternational: "+currentAirport.getIsInternational());
                    System.out.println("NoOfHangers: "+currentAirport.getNoOfHangers());
                    System.out.println("NoOfRunways: "+currentAirport.getNoOfRunways());
                    System.out.println("-----------------------------------------------------------------------");

                    break;

                case 5:
                    if(currentScheduleCount < schedules.length) {
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

                        schedules[currentScheduleCount] = new Schedule();
                        currentScheduleCount++;

                        schedules[currentScheduleCount - 1].schedule_fight_to_airport(flights[selected_flight_id - 1], airports[selected_airport_id - 1], schedule_date);

                        System.out.println("Flight Scheduled to Airport and added to array!");

                    } else {
                        System.out.println("Too many Schedules! Array cannot store anymore schedules.");
                    }

                    break;
                case 6:
                    for(int i = 0; i < currentScheduleCount; i++)
                    {
                        schedules[i].display_flights_scheduled_airport();
                    }

                    break;
                case 7:
                    System.out.println("Exiting!");

                    break;
                default:
                    System.out.println("Invalid choice. Try Again!");

                    break;

            }
        }while(choice != 7);

    }
}