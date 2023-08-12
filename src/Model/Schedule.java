package Model;

import java.util.Calendar;

public class Schedule {
    private Calendar scheduleDate;
    Airport ObjAirport;
    Flight ObjFlight;

    public void schedule_fight_to_airport(Airport tempAirport, Flight tempFlight, Calendar cal1) {
        ObjAirport = tempAirport;
        ObjFlight = tempFlight;
        scheduleDate = cal1;
    }
    public void display_flights_scheduled()
    {
        System.out.println("\n-Flight schedule details-");
        System.out.println("Flight Name: "+this.ObjFlight.getFlightName());
        System.out.println("Flight Code: "+this.ObjFlight.getFlightCode());
        System.out.println("To airport: "+this.ObjFlight.getToAirport());
        System.out.println("Flight model: "+this.ObjFlight.getFlightModel());
        System.out.println("Flight capacity: "+this.ObjFlight.getFlightCapacity());
        System.out.println("Flight date: "+this.scheduleDate.get(Calendar.DAY_OF_MONTH)+" "+this.scheduleDate.get(Calendar.MONTH)+" "+this.scheduleDate.get(Calendar.YEAR));

    }

}


