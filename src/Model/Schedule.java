package Model;

import java.util.Calendar;

public class Schedule {
    private Calendar schedule_date;

    Airport ObjAirport;
    Flight ObjFlight;

    public void schedule_fight_to_airport(Airport tempAirport, Flight tempFlight, Calendar cal1) {
        ObjAirport = tempAirport;
        ObjFlight = tempFlight;
    }
        public void display_flights_scheduled()
        {
            System.out.println("\n-Flight details-");
            System.out.println("Flight Name: "+this.ObjFlight.getFlightName());
            System.out.println("To the airport: "+this.ObjFlight.getToAirport());
            System.out.println("No of hours: "+this.ObjFlight.getFlightCode());
            System.out.println("Flight model: "+this.ObjFlight.getFlightModel());
            System.out.println("Flight capacity: "+this.ObjFlight.getFlightCapacity());
            System.out.println("Flight date: "+this.ObjFlight.getFlightDate());

        }

    }


