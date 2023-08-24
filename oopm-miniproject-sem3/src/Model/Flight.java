package Model;

import java.util.Calendar;
public class Flight {
    int flightId;
    private String flightName;
    private String flightCode;
    private String flightModel;

    //Flight Constructor
    public Flight(int flightId, String flightName, String flightCode, String flightModel)
    {
        setFlightId(flightId);
        setFlightName(flightName);
        setFlightCode(flightCode);
        setFlightModel(flightModel);
    }

    public Flight(String flightName, String flightCode, String flightModel)
    {

        setFlightId((int)Math.random());
        setFlightName(flightName);
        setFlightCode(flightCode);
        setFlightModel(flightModel);
    }


    public void setFlightId(int flightId){this.flightId = flightId;}
    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public void setFlightModel(String flightModel) {
        this.flightModel = flightModel;
    }

    public int getFlightId(){return this.flightId;}

    public String getFlightName() {
        return this.flightName;
    }

    public String getFlightCode() {return this.flightCode;}

    public String getFlightModel() {
        return this.flightModel;
    }





}