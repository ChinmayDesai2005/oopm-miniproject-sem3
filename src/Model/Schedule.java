package Model;

public class Schedule {

    Airport ObjAirport;
    Flight ObjFlight;

    public void schedule_fight_to_airport(Airport TempAirport, Flight TempFlight){
        ObjAirport = TempAirport;
        ObjFlight = TempFlight;
    }
}
