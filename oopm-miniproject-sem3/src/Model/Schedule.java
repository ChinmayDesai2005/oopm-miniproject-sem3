package Model;

import java.util.Calendar;

public class Schedule {
    private Calendar scheduleDate;
    Airport ObjAirport;
    CommercialFlight ObjFlight;

    public void schedule_fight_to_airport(CommercialFlight tempFlight, Airport tempAirport, Calendar cal1) {
        ObjFlight = tempFlight;
        ObjAirport = tempAirport;
        scheduleDate = cal1;
    }
    public void display_flights_scheduled_airport()
    {
        System.out.println("\n-Flight schedule details-");
        System.out.println("Flight Name: "+this.ObjFlight.getFlightName());
        System.out.println("Flight Code: "+this.ObjFlight.getFlightCode());
        System.out.println("Flight Capacity: "+this.ObjFlight.getNoOfPassengers());
        System.out.println("Flight Classes: "+this.ObjFlight.getFlightClasses());
        System.out.println("Flight Model: "+this.ObjFlight.getFlightModel());
        System.out.println("To Airport: "+this.ObjAirport.getAirportName());
        System.out.println("Airport Location: "+this.ObjAirport.getAirportLocation());
        System.out.println("Airport Code: "+this.ObjAirport.getAirportCode());
        System.out.println("Flight date: "+this.scheduleDate.get(Calendar.DAY_OF_MONTH)+" "+this.scheduleDate.get(Calendar.MONTH)+" "+this.scheduleDate.get(Calendar.YEAR));

    }

}


